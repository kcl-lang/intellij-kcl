/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl;

import io.kusionstack.kcl.lexer.KCLHighlightingLexer;
import io.kusionstack.kcl.psi.KCLTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author amyxia
 * @version KCLSyntaxHighlighter: KCLSyntaxHighlighter.java, v 0.1 2020年09月23日 11:08 上午 amyxia Exp $
 */
public class KCLSyntaxHighlighter extends SyntaxHighlighterBase {
    /**
     * keywords: as, assert, elif, else, final, for, if, import, schema, mixin, relaxed, check, and, in, is, not, or
     */
    public static final TextAttributesKey KEYWORD           = createTextAttributesKey("KCL_KEYWORDS",
            DefaultLanguageHighlighterColors.KEYWORD);
    /**
     * bool & None & Undefined literal: True, False, None, Undefined
     */
    public static final TextAttributesKey BOOL_NONE_LITERAL = createTextAttributesKey("KCL_BOOL_VALUE",
            DefaultLanguageHighlighterColors.KEYWORD);
    /**
     * number literal: number
     */
    public static final TextAttributesKey NUMBER            = createTextAttributesKey("KCL_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER);

    /**
     * operator sign: = : , ? ( ) [ ] { } + - * / % & | ^ ~ < > == != >= <= ** // << >> @ += -= *= /= %= &= |= ^= **= //= <<= >>=
     */
    public static final TextAttributesKey OPERATOR_SIGN       = createTextAttributesKey("KCL_OPERATOR_SIGN",
            DefaultLanguageHighlighterColors.OPERATION_SIGN);
    /**
     * dot: .
     */
    public static final TextAttributesKey DOT                 = createTextAttributesKey("KCL_DOT", DefaultLanguageHighlighterColors.DOT);
    /**
     * type: str, int, float, bool, any
     */
    public static final TextAttributesKey BASIC_TYPE          = createTextAttributesKey("KCL_BASIC_TYPE",
            DefaultLanguageHighlighterColors.KEYWORD);
    /**
     * identifier: name
     */
    public static final TextAttributesKey NAME                = createTextAttributesKey("KCL_NAME",
            DefaultLanguageHighlighterColors.IDENTIFIER);
    /**
     * string literal: "string"
     */
    public static final TextAttributesKey STRING              = createTextAttributesKey("KCL_STRING",
            DefaultLanguageHighlighterColors.STRING);
    /**
     * docstring comment: """docstring"""
     */
    public static final TextAttributesKey DOC_STRING          = createTextAttributesKey("KCL_DOC_STRING",
            DefaultLanguageHighlighterColors.DOC_COMMENT);
    /**
     * end of line comment: # comment
     */
    public static final TextAttributesKey END_OF_LINE_COMMENT = createTextAttributesKey("KCL_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);
    /**
     * bad charater
     */
    public static final TextAttributesKey BAD_CHARACTER       = createTextAttributesKey("KCL_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] KEYWORD_KEYS       = new TextAttributesKey[] {KEYWORD};
    private static final TextAttributesKey[] DOT_KEYS           = new TextAttributesKey[] {DOT};
    private static final TextAttributesKey[] OPERATOR_SIGN_KEYS = new TextAttributesKey[] {OPERATOR_SIGN};

    private static final TextAttributesKey[] BOOL_NONE_LITERALS = new TextAttributesKey[] {BOOL_NONE_LITERAL};
    private static final TextAttributesKey[] NUMBER_KEYS        = new TextAttributesKey[] {NUMBER};
    private static final TextAttributesKey[] STRING_KEYS        = new TextAttributesKey[] {STRING};

    private static final TextAttributesKey[] BASIC_TYPE_KEYS = new TextAttributesKey[] {BASIC_TYPE};
    private static final TextAttributesKey[] NAME_KEYS       = new TextAttributesKey[] {NAME};

    private static final TextAttributesKey[] DOC_STRING_KEYS = new TextAttributesKey[] {DOC_STRING};
    private static final TextAttributesKey[] COMMENT_KEYS    = new TextAttributesKey[] {END_OF_LINE_COMMENT};

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[] {BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS    = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new KCLHighlightingLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (isKCLKeyword(tokenType)) {
            return KEYWORD_KEYS;
        } else if (isKCLOperatorSign(tokenType)) {
            return OPERATOR_SIGN_KEYS;
        } else if (isBasicType(tokenType)) {
            return BASIC_TYPE_KEYS;
        } else if (tokenType.equals(KCLTypes.TRUE) || tokenType.equals(KCLTypes.FALSE) || tokenType.equals(KCLTypes.NONE) || tokenType
                .equals(KCLTypes.UNDEFINED)) {
            return BOOL_NONE_LITERALS;
        } else if (isKCLNumber(tokenType)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(KCLTypes.NAME)) {
            return NAME_KEYS;
        } else if (tokenType.equals(KCLTypes.STRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(KCLTypes.LONG_STRING)) {
            return DOC_STRING_KEYS;
        } else if (tokenType.equals(KCLTypes.DOT)) {
            return DOT_KEYS;
        } else if (tokenType.equals(KCLTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

    private boolean isKCLKeyword(IElementType tokenType) {
        IElementType[] KCLKeywords = {
                KCLTypes.AS,
                KCLTypes.ASSERT,
                KCLTypes.ELIF,
                KCLTypes.ELSE,
                KCLTypes.FINAL,
                KCLTypes.FOR,
                KCLTypes.IF,
                KCLTypes.IMPORT,
                KCLTypes.SCHEMA,
                KCLTypes.MIXIN,
                KCLTypes.RELAXED,
                KCLTypes.CHECK,
                KCLTypes.K_AND,
                KCLTypes.IN,
                KCLTypes.IS,
                KCLTypes.K_NOT,
                KCLTypes.K_OR,
                KCLTypes.ALL,
                KCLTypes.FILTER,
                KCLTypes.K_TYPE,
                KCLTypes.PROTOCOL,
                KCLTypes.LAMBDA,
        };

        return containsTokenType(KCLKeywords, tokenType);
    }

    private boolean isKCLOperatorSign(IElementType tokenType) {
        IElementType[] KCLOperatorSigns = {
                KCLTypes.ASSIGN,
                KCLTypes.COLON,
                KCLTypes.COMMA,
                KCLTypes.QUESTION,
                KCLTypes.RIGHT_ARROW,
                KCLTypes.LEFT_PARENTHESES,
                KCLTypes.RIGHT_PARENTHESES,
                KCLTypes.LEFT_BRACKETS,
                KCLTypes.RIGHT_BRACKETS,
                KCLTypes.LEFT_BRACE,
                KCLTypes.RIGHT_BRACE,
                KCLTypes.PLUS,
                KCLTypes.MINUS,
                KCLTypes.MULTIPLY,
                KCLTypes.DIVIDE,
                KCLTypes.MOD,
                KCLTypes.DOT,
                KCLTypes.AND,
                KCLTypes.OR,
                KCLTypes.XOR,
                KCLTypes.NOT,
                KCLTypes.LESS_THAN,
                KCLTypes.GREATER_THAN,
                KCLTypes.EQUAL_TO,
                KCLTypes.NOT_EQUAL_TO,
                KCLTypes.GREATER_THAN_OR_EQUAL_TO,
                KCLTypes.LESS_THAN_OR_EQUAL_TO,
                KCLTypes.DOUBLE_STAR,
                KCLTypes.DOUBLE_DIVIDE,
                KCLTypes.SHIFT_LEFT,
                KCLTypes.SHIFT_RIGHT,
                KCLTypes.AT,
                KCLTypes.COMP_PLUS,
                KCLTypes.COMP_MINUS,
                KCLTypes.COMP_MULTIPLY,
                KCLTypes.COMP_DIVIDE,
                KCLTypes.COMP_MOD,
                KCLTypes.COMP_AND,
                KCLTypes.COMP_OR,
                KCLTypes.COMP_XOR,
                KCLTypes.COMP_DOUBLE_STAR,
                KCLTypes.COMP_DOUBLE_DIVIDE,
                KCLTypes.COMP_SHIFT_LEFT,
                KCLTypes.COMP_SHIFT_RIGHT
        };
        return containsTokenType(KCLOperatorSigns, tokenType);
    }

    private boolean isKCLNumber(IElementType tokenType) {
        IElementType[] KCLNumbers = {
                KCLTypes.DEC_NUMBER,
                KCLTypes.HEX_NUMBER,
                KCLTypes.OCT_NUMBER,
                KCLTypes.BIN_NUMBER,
                KCLTypes.FLOAT_NUMBER
        };
        return containsTokenType(KCLNumbers, tokenType);
    }

    private boolean isBasicType(IElementType tokenType) {
        IElementType[] KCLBasicTypes = {
                KCLTypes.STRING_TYPE,
                KCLTypes.INT_TYPE,
                KCLTypes.FLOAT_TYPE,
                KCLTypes.BOOL_TYPE,
                KCLTypes.ANY,
                KCLTypes.MAP
        };
        return containsTokenType(KCLBasicTypes, tokenType);
    }

    private boolean containsTokenType(IElementType[] tokenTypes, IElementType tokenType) {
        for (IElementType token : tokenTypes) {
            if (token.equals(tokenType)) {
                return true;
            }
        }
        return false;
    }
}