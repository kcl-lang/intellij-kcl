/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl;

import io.kusionstack.kcl.lexer.KCLIndentingLexer;
import io.kusionstack.kcl.parser.KCLParser;
import io.kusionstack.kcl.psi.KCLFile;
import io.kusionstack.kcl.psi.KCLTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version KCLParserDefinition: KCLParserDefinition.java, v 0.1 2020年09月23日 10:36 上午 amyxia Exp $
 */
public class KCLParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES   = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS       = TokenSet.create(KCLTypes.COMMENT);
    public static final TokenSet STRING_LITERAL = TokenSet.create(KCLTypes.STRING, KCLTypes.LONG_STRING);

    public static final IFileElementType FILE = new IFileElementType(KCLLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new KCLIndentingLexer();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return TokenSet.create(TokenType.WHITE_SPACE);
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRING_LITERAL;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new KCLParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new KCLFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return KCLTypes.Factory.createElement(node);
    }
}