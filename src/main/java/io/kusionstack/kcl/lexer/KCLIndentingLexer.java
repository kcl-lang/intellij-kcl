/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.lexer;

import io.kusionstack.kcl.psi.KCLTypes;
import com.intellij.lexer.DelegateLexer;
import com.intellij.lexer.FlexAdapter;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author amyxia
 * @version KCLIndentingLexer: KCLIndentingLexer.java, v 0.1 2021年01月28日 4:10 下午 amyxia Exp $
 */
public class KCLIndentingLexer extends DelegateLexer {
    private static final Logger             LOGGER        = Logger.getInstance(KCLIndentingLexer.class);
    private final        Stack<String>      myIndentStack = new Stack<>();
    private final        List<PendingToken> myTokenQueue  = new ArrayList<>();
    private static final boolean            DUMP_TOKENS   = false;
    private static final int                MaxStackSize  = 1000;
    private              boolean            addFinalBreak = true;

    public KCLIndentingLexer() {
        super(new FlexAdapter(new _KCLLexer(null)));
    }

    private static class PendingToken {
        private       IElementType _type;
        private final int          _start;
        private final int          _end;

        public PendingToken(IElementType type, int start, int end) {
            _type = type;
            _start = start;
            _end = end;
        }

        public IElementType getType() {
            return _type;
        }

        public int getStart() {
            return _start;
        }

        public int getEnd() {
            return _end;
        }

        public void setType(IElementType type) {
            _type = type;
        }

        @Override
        public String toString() {
            return _type + ":" + _start + "-" + _end;
        }
    }

    @Override
    public IElementType getTokenType() {
        if (!myTokenQueue.isEmpty()) {
            return myTokenQueue.get(0).getType();
        }
        return super.getTokenType();
    }

    @Override
    public int getTokenStart() {
        if (!myTokenQueue.isEmpty()) {
            return myTokenQueue.get(0).getStart();
        }
        return super.getTokenStart();
    }

    @Override
    public int getTokenEnd() {
        if (!myTokenQueue.isEmpty()) {
            return myTokenQueue.get(0).getEnd();
        }
        return super.getTokenEnd();
    }

    @Override
    public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
        if (DUMP_TOKENS) {
            LOGGER.debug("\n--- LEXER START---");
        }
        super.start(buffer, startOffset, endOffset, initialState);
        setStartState();
    }

    private void setStartState() {
        myIndentStack.clear();
        myIndentStack.push("");
        if (!myTokenQueue.isEmpty()) {
            LOGGER.error("myTokenQueue not clear");
        }
    }

    @Override
    public void advance() {
        if (DUMP_TOKENS && getTokenType() != null) {
            LOGGER.debug(getTokenStart() + "-" + getTokenEnd() + ":" + getTokenType() + "\n ");
        }
        if (!myTokenQueue.isEmpty()) {
            myTokenQueue.remove(0);
        } else {
            IElementType lastToken = getBaseTokenType();
            String lastTokenText = getBaseTokenText();
            int lastTokenEnd = getBaseTokenEnd();

            advanceBase();

            if (getBaseTokenType() == null && addFinalBreak) {
                // deal with EOF
                int tokenStart = getBaseTokenStart();
                // add missing new line if needed
                if (lastToken != KCLTypes.NEWLINE) {
                    pushToken(KCLTypes.NEWLINE, tokenStart, tokenStart);
                }
                // add missing DEDENT if needed
                while (myIndentStack.size() > 1) {
                    pushToken(KCLTypes.DEDENT, tokenStart, tokenStart);
                    myIndentStack.pop();
                }
                addFinalBreak = false;
            } else if (lastToken == KCLTypes.NEWLINE) {
                // when not at EOF, and last token is NEWLINE, deal with newline indent
                dealWithIndent(lastTokenText, lastTokenEnd);
            }
        }
    }

    private void advanceBase() {
        super.advance();
    }

    @Nullable
    private IElementType getBaseTokenType() {
        return super.getTokenType();
    }

    private int getBaseTokenStart() {
        return super.getTokenStart();
    }

    private int getBaseTokenEnd() {
        return super.getTokenEnd();
    }

    @NotNull
    private String getBaseTokenText() {
        return getBufferSequence().subSequence(getBaseTokenStart(), getBaseTokenEnd()).toString();
    }

    private void pushToken(IElementType type, int start, int end) {
        myTokenQueue.add(new PendingToken(type, start, end));
    }

    private boolean exceedMaxStackSize() {
        return myIndentStack.size() >= MaxStackSize;
    }

    private void dealWithIndent(String text, int offset) {
        // check text content after the last \n
        String lastLine = text.substring(text.lastIndexOf('\n') + 1);
        if (lastLine.contains("#")) {
            // if the last line contains comment, no indent/dedent needed.
            return;
        }
        if (myIndentStack.peek().equals(lastLine)) {
            return;
        }

        if (lastLine.startsWith(myIndentStack.peek())) {
            // need indent
            if (!exceedMaxStackSize()) {
                myIndentStack.push(lastLine);
                pushToken(KCLTypes.INDENT, offset, offset);
            }
            return;
        }

        if (myIndentStack.peek().startsWith(lastLine)) {
            // need dedent
            while (myIndentStack.size() > 1 && myIndentStack.peek().length() > lastLine.length()) {
                myIndentStack.pop();
                pushToken(KCLTypes.DEDENT, offset, offset);
            }
            return;
        }

        // when current line prefix does not match any existing prefix, fall back to count text length
        int currentIndent = indentLength(lastLine);
        while (true) {
            if (currentIndent < indentLength(myIndentStack.peek()) && myIndentStack.size() > 1) {
                myIndentStack.pop();
                pushToken(KCLTypes.DEDENT, offset, offset);
            } else {
                return;
            }
        }
    }

    public static int indentLength(String text) {
        return (int) (text.chars().filter(ch -> ch == ' ').count() + (text.chars().filter(ch -> ch == '\t').count() * 4));
    }

}