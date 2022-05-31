/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl;

import io.kusionstack.kcl.lexer.KCLIndentingLexer;
import io.kusionstack.kcl.psi.KCLTypes;
import com.intellij.application.options.CodeStyle;
import com.intellij.formatting.IndentInfo;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.TokenType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.lineIndent.LineIndentProvider;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.text.CharArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * @author amyxia
 * @version KCLLineIndentProvider: KCLLineIndentProvider.java, v 0.1 2021年04月28日 6:09 下午 amyxia Exp $
 */
public class KCLLineIndentProvider implements LineIndentProvider {

    @Override
    public @Nullable String getLineIndent(@NotNull Project project, @NotNull Editor editor, @Nullable Language language, int offset) {
        assert isSuitableFor(language);
        if (offset <= 0) {
            return DO_NOT_ADJUST;
        }

        int editorOffset = editor.getCaretModel().getOffset();
        LogicalPosition lineColumn = editor.getCaretModel().getLogicalPosition();// use logical position
        Document doc = editor.getDocument();
        if (offset != editorOffset) {
            // after push backspace
            // at the middle of a line, but all the tokens in this line ahead are whitespaces
            // should delete one indent
            // final nearest smaller indent in lines before
            if (lineColumn.line == 0) {
                return "";
            }
            String currentLine = doc.getText(
                    new TextRange(doc.getLineStartOffset(lineColumn.line), editorOffset));
            if (currentLine.isEmpty()) {
                return null;
            }
            String currentLineIndent = getIndentOfLine(currentLine);
            int lastLineNum = lineColumn.line - 1;
            while (lastLineNum >= 0) {
                String lastLineContent = doc.getText(
                        new TextRange(doc.getLineStartOffset(lastLineNum), doc.getLineEndOffset(lastLineNum)));
                if (!lastLineContent.trim().isEmpty()) {
                    int firstNonWsOffset = firstNonBlankIndex(lastLineContent);
                    if (firstNonWsOffset != lastLineContent.length()) {
                        String lastLineIndent = lastLineContent.substring(0, firstNonWsOffset);
                        boolean smaller = indentSmallerThan(lastLineIndent, currentLineIndent);
                        if (smaller) {
                            return lastLineIndent;
                        }
                    }
                }
                lastLineNum--;
            }
        } else {
            // after push enter
            // at the end of a line && in current line, the caret position has '{' or '[' or ':' before
            // should add 4 more whitespaces than current line's leading ws
            KCLSemanticEditorPosition position = getPosition(editor, offset - 1);

            if (position.isAtAnyOf(KCLTypes.NEWLINE, TokenType.WHITE_SPACE)) {
                position.moveToEndOfPreviousLine();
                if (position.isAtAnyOf(KCLTypes.LEFT_BRACE, KCLTypes.LEFT_BRACKETS, KCLTypes.LEFT_PARENTHESES, KCLTypes.COLON)) {
                    return getIndentString(editor, position.getStartOffset());
                }
            }

            return null;
        }

        return null;
    }

    private String getIndentString(@NotNull Editor editor, int offset) {
        CodeStyleSettings settings = CodeStyle.getSettings(editor);
        CommonCodeStyleSettings.IndentOptions indentOptions = settings.getIndentOptions(KCLFileType.INSTANCE);
        CharSequence docChars = editor.getDocument().getCharsSequence();

        String baseIndent = "";
        if (offset > 0) {
            int indentStart = CharArrayUtil.shiftBackwardUntil(docChars, offset, "\n") + 1;
            if (indentStart >= 0) {
                int indentEnd = CharArrayUtil.shiftForward(docChars, indentStart, " \t");
                int indentSize = indentEnd - indentStart;
                if (indentSize > 0) {
                    baseIndent = docChars.subSequence(indentStart, indentEnd).toString();
                }
            }
        }
        baseIndent += new IndentInfo(0, indentOptions.TAB_SIZE, 0).generateNewWhiteSpace(indentOptions);

        return baseIndent;
    }

    @Override
    public boolean isSuitableFor(@Nullable Language language) {
        return language != null && language.isKindOf(KCLLanguage.INSTANCE);
    }

    static KCLSemanticEditorPosition getPosition(Editor editor, int offset) {
        return new KCLSemanticEditorPosition((EditorEx) editor, offset);
    }

    private int firstNonBlankIndex(String content) {
        assert !content.isEmpty();
        char[] chars = content.toCharArray();
        int i = 0;
        for (; i < chars.length; i++) {
            if (chars[i] != ' ' && chars[i] != '\t') {
                return i;
            }
        }
        return i;
    }

    /**
     * check if the left indent string smaller than the right one
     *
     * @param left  indent string, contains only whitespaces or tabs
     * @param right indent string, contains only whitespaces or tabs
     * @return if the left indent string smaller than the right one
     */
    private boolean indentSmallerThan(@NotNull String left, @NotNull String right) {
        if (left.equals(right)) {
            return false;
        }
        if (right.startsWith(left)) {
            return true;
        }
        if (left.startsWith(right)) {
            return false;
        }
        // fall back to count text length
        return KCLIndentingLexer.indentLength(left) < KCLIndentingLexer.indentLength(right);
    }

    /**
     * get the indent prefix of a line
     *
     * @param line the line that may contains indent(leading whitespaces or tabs)
     * @return the indent string
     */
    private String getIndentOfLine(String line) {
        int firstNoneBlankIndex = firstNonBlankIndex(line);
        if (firstNoneBlankIndex == line.length()) {
            return line;
        }
        return line.substring(0, firstNoneBlankIndex);
    }

    private static class KCLSemanticEditorPosition {
        private final HighlighterIterator iterator;

        KCLSemanticEditorPosition(EditorEx editor, int offset) {
            iterator = editor.getHighlighter().createIterator(offset);
        }

        void moveBefore() {
            if (!iterator.atEnd()) {
                iterator.retreat();
            }
        }

        boolean isAt(@NotNull IElementType elementType) {
            return !iterator.atEnd() && iterator.getTokenType() == elementType;
        }

        void moveToEndOfPreviousLine() {
            moveBeforeOptional(TokenType.WHITE_SPACE);
            if (isAtAnyOf(KCLTypes.NEWLINE)) {
                moveBefore();
                moveBeforeOptional(TokenType.WHITE_SPACE);
            }
        }

        void moveBeforeOptional(IElementType @NotNull ... elementTypes) {
            while (isAtAnyOf(elementTypes)) {
                iterator.retreat();
            }
        }

        boolean isAtAnyOf(IElementType @NotNull ... elementTypes) {
            return !iterator.atEnd() && Arrays.stream(elementTypes).anyMatch(e -> e == iterator.getTokenType());
        }

        int getStartOffset() {
            return !iterator.atEnd() ? iterator.getStart() : -1;
        }
    }

    // 该provider能看到的结果已经是换行或删除之后的样子
    // 如果是在行尾换行，光标后的空格会被忽略，光标前的空格还在；拿到的offset是在默认换行行为完成之后，光标后面的符号那里（和当前行indent一致）

    // 如果是行首减行，光标前的空格会被直接删除到行首，光标后的空格还在；并且虽然删除到了行首，但被删除空格还在，只是到了光标的后面；拿到的offset是在删除到行首之后，光标后面的符号那里（如果删除的时候光标前有空格，则该符号就是空格）
    // 也就是说，如果行首减行，并且光标前有空格时，不论光标后是否有空格，offset值是一模一样的
    // 如果行首减行，并且此刻光标前没有空格，光标后有空格，要怎么和上一条区分呢: 行首减行的时候，editor.getCaretModel().getOffset()能获得真实的offset值

    // 如果是行中间换行，换行后的样子：并不一定是直接和indent保持一致，如果光标后面有几个空格，那么预期的光标位置将是：与上一行indent保持一致的基础上，再往后越过这几个空格，放在不是空格的token之前，也就是上一行indent+光标后ws个数
    // 如果是"伪行中间换行"，也就是虽然从光标上看是在行的中间，但光标后只有空格，没有别的字符，
    // 1. **并且直到文件结尾没有新行了**，那么预期的光标位置将是：与上一行indent保持一致，新行的光标前面是indent的ws，后面是旧行的空格(-1 因为current就是后面空格的第一个了)
    // 2. 大部分情况下，如果直到文件结尾还有新行，这些空格会被融合进NEWLINE token中，此时，current = NEWLINE，offset为和上行的indent保持一致后的光标位置，也就是说空格消失了，作为了NEWLINE token的一部分
    //(但要注意newline 的start offset是在换行前光标的位置）

    // 如果行尾换行，并且光标前面有空格，光标后没有空格：
    // 1. 如果直到文件结尾没有新行了：换行后：光标位置在 与上一行的indent保持一致后的位置，current =
    //Whitespace（是缩进中的最后一个空格），然后往前推一直推到换行符（因为enter造成的）之前，newline前会有几个空格（原本在光标前的那几个），然后是空格前的别的token
    // 2. 大部分情况下，如果直到文件结尾还有新行，换行后的光标位置就是在 与上一行的indent保持一致后的位置，而current=NEWLINE，而该NEWLINE的start offset < offset
    //往前看的话，前面会有换行前光标之前的空格，接着空格前的别的token


}