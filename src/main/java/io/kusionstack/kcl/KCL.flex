package io.kusionstack.kcl.lexer;

import io.kusionstack.kcl.psi.KCLTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
%%

%class _KCLLexer
%implements FlexLexer
%unicode
%function advance

%type IElementType

NAME=\$?[a-zA-Z_]\w*
COMMENT="#"[^\n]*
NEWLINE=((\r?\n[\t ]*)|{COMMENT})+

// ignore: whitespace, line continue
WHITE_SPACE=[\ \t]
LINE_CONTINUE=\\[\t \f]*\r?\n

// NUMBER
DEC_NUMBER = \-?(0|[1-9]\d*)// 十进制
HEX_NUMBER = \-?0[xX][0-9a-fA-F]+// 十六进制
OCT_NUMBER = \-?0[oO]?[0-7]+// 八进制
BIN_NUMBER = \-?0[bB][0-1]+// 二进制
FLOAT_NUMBER = ([-+]?\d+\.\d*|\.\d+)([eE][-+]?\d+)?|\d+([eE][-+]?\d+)

// STRING
STRING=[UuBbCcRr]{0,3}({QUOTED_LITERAL} | {DOUBLE_QUOTED_LITERAL})
LONG_STRING=[UuBbCcRr]{0,3}({TRIPLE_QUOTED_LITERAL}|{TRIPLE_APOS_LITERAL})
QUOTED_LITERAL="'" ([^\\\'\r\n] | {ESCAPE_SEQUENCE} | (\\[\r\n]))* ("'"|\\)?
DOUBLE_QUOTED_LITERAL=\"([^\\\"\r\n]|{ESCAPE_SEQUENCE}|(\\[\r\n]))*?(\"|\\)?
ESCAPE_SEQUENCE=\\[^\r\n]

ANY_ESCAPE_SEQUENCE = \\[^]

THREE_QUO = (\"\"\")
ONE_TWO_QUO = (\"[^\\\"]) | (\"\\[^]) | (\"\"[^\\\"]) | (\"\"\\[^])
QUO_STRING_CHAR = [^\\\"] | {ANY_ESCAPE_SEQUENCE} | {ONE_TWO_QUO}
TRIPLE_QUOTED_LITERAL = {THREE_QUO} {QUO_STRING_CHAR}* {THREE_QUO}?

THREE_APOS = (\'\'\')
ONE_TWO_APOS = ('[^\\']) | ('\\[^]) | (''[^\\']) | (''\\[^])
APOS_STRING_CHAR = [^\\'] | {ANY_ESCAPE_SEQUENCE} | {ONE_TWO_APOS}
TRIPLE_APOS_LITERAL = {THREE_APOS} {APOS_STRING_CHAR}* {THREE_APOS}?

%%

"="                   { return KCLTypes.ASSIGN; }
":"                   { return KCLTypes.COLON; }
//";"                   { return KCLTypes.SEMI_COLON; }
","                   { return KCLTypes.COMMA; }
"?"                   { return KCLTypes.QUESTION; }
"->"                  { return KCLTypes.RIGHT_ARROW; }
"("                   { return KCLTypes.LEFT_PARENTHESES; }
")"                   { return KCLTypes.RIGHT_PARENTHESES; }
"["                   { return KCLTypes.LEFT_BRACKETS; }
"]"                   { return KCLTypes.RIGHT_BRACKETS; }
"{"                   { return KCLTypes.LEFT_BRACE; }
"}"                   { return KCLTypes.RIGHT_BRACE; }
"+"                   { return KCLTypes.PLUS; }
"-"                   { return KCLTypes.MINUS; }
"*"                   { return KCLTypes.MULTIPLY; }
"/"                   { return KCLTypes.DIVIDE; }
"%"                   { return KCLTypes.MOD; }
"."                   { return KCLTypes.DOT; }
"&"                   { return KCLTypes.AND; }
"|"                   { return KCLTypes.OR; }
"^"                   { return KCLTypes.XOR; }
"~"                   { return KCLTypes.NOT; }
"<"                   { return KCLTypes.LESS_THAN; }
">"                   { return KCLTypes.GREATER_THAN; }
"=="                  { return KCLTypes.EQUAL_TO; }
"!="                  { return KCLTypes.NOT_EQUAL_TO; }
">="                  { return KCLTypes.GREATER_THAN_OR_EQUAL_TO; }
"<="                  { return KCLTypes.LESS_THAN_OR_EQUAL_TO; }
"**"                  { return KCLTypes.DOUBLE_STAR; }
"//"                  { return KCLTypes.DOUBLE_DIVIDE; }
"<<"                  { return KCLTypes.SHIFT_LEFT; }
">>"                  { return KCLTypes.SHIFT_RIGHT; }
"@"                   { return KCLTypes.AT; }

"+="                  { return KCLTypes.COMP_PLUS; }
"-="                  { return KCLTypes.COMP_MINUS; }
"*="                  { return KCLTypes.COMP_MULTIPLY; }
"/="                  { return KCLTypes.COMP_DIVIDE; }
"%="                  { return KCLTypes.COMP_MOD; }
"&="                  { return KCLTypes.COMP_AND; }
"|="                  { return KCLTypes.COMP_OR; }
"^="                  { return KCLTypes.COMP_XOR; }
"**="                 { return KCLTypes.COMP_DOUBLE_STAR; }
"//="                 { return KCLTypes.COMP_DOUBLE_DIVIDE; }
"<<="                 { return KCLTypes.COMP_SHIFT_LEFT; }
">>="                 { return KCLTypes.COMP_SHIFT_RIGHT; }


// Special tokens
"import"              { return KCLTypes.IMPORT; }
"as"                  { return KCLTypes.AS; }
"schema"              { return KCLTypes.SCHEMA; }
"mixin"               { return KCLTypes.MIXIN; }
"protocol"            { return KCLTypes.PROTOCOL; }
"relaxed"             { return KCLTypes.RELAXED; }
"check"               { return KCLTypes.CHECK; }
"for"                 { return KCLTypes.FOR; }
"assert"              { return KCLTypes.ASSERT; }
"if"                  { return KCLTypes.IF; }
"elif"                { return KCLTypes.ELIF; }
"else"                { return KCLTypes.ELSE; }
"or"                  { return KCLTypes.K_OR; }
"and"                 { return KCLTypes.K_AND; }
"not"                 { return KCLTypes.K_NOT; }
"in"                  { return KCLTypes.IN; }
"is"                  { return KCLTypes.IS; }
"final"               { return KCLTypes.FINAL; }
"lambda"              { return KCLTypes.LAMBDA; }
"all"                 { return KCLTypes.ALL; }
"any"                 { return KCLTypes.ANY; }
"filter"              { return KCLTypes.FILTER; }
"map"                 { return KCLTypes.MAP; }
"type"                { return KCLTypes.K_TYPE; }

// types
"str"                 { return KCLTypes.STRING_TYPE; }
"int"                 { return KCLTypes.INT_TYPE; }
"float"               { return KCLTypes.FLOAT_TYPE; }
"bool"                { return KCLTypes.BOOL_TYPE; }

// Constant tokens
"True"                { return KCLTypes.TRUE; }
"False"               { return KCLTypes.FALSE; }
"None"                { return KCLTypes.NONE; }
"Undefined"           { return KCLTypes.UNDEFINED; }

// Binary prefix
"n"                   { return KCLTypes.SI_N_L; }
"u"                   { return KCLTypes.SI_U_L; }
"m"                   { return KCLTypes.SI_M_L; }
"k"                   { return KCLTypes.SI_K_L; }
"K"                   { return KCLTypes.SI_K; }
"M"                   { return KCLTypes.SI_M; }
"G"                   { return KCLTypes.SI_G; }
"T"                   { return KCLTypes.SI_T; }
"P"                   { return KCLTypes.SI_P; }
"Ki"                  { return KCLTypes.SI_K_IEC; }
"Mi"                  { return KCLTypes.SI_M_IEC; }
"Gi"                  { return KCLTypes.SI_G_IEC; }
"Ti"                  { return KCLTypes.SI_T_IEC; }
"Pi"                  { return KCLTypes.SI_P_IEC; }
//"i"                   { return KCLTypes.IEC; }


{LINE_CONTINUE}       {/* ignore */}
{NAME}               { return KCLTypes.NAME; }
{COMMENT}            { return KCLTypes.COMMENT; }
{NEWLINE}            { return KCLTypes.NEWLINE; }

{DEC_NUMBER}         { return KCLTypes.DEC_NUMBER; }
{HEX_NUMBER}         { return KCLTypes.HEX_NUMBER; }
{OCT_NUMBER}         { return KCLTypes.OCT_NUMBER; }
{BIN_NUMBER}         { return KCLTypes.BIN_NUMBER; }
{FLOAT_NUMBER}       { return KCLTypes.FLOAT_NUMBER; }

{STRING}             { return KCLTypes.STRING; }
{LONG_STRING}        { return KCLTypes.LONG_STRING; }
{WHITE_SPACE}        { return TokenType.WHITE_SPACE;}

[^]                   { return TokenType.BAD_CHARACTER; }
[\u000b]                    { return TokenType.BAD_CHARACTER; }