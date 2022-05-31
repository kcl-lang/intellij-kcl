/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl;

import io.kusionstack.kcl.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author amyxia
 * @version KCLFoldingBuilder: KCLFoldingBuilder.java, v 0.1 2021年04月27日 7:09 下午 amyxia Exp $
 */
public class KCLFoldingBuilder extends FoldingBuilderEx implements DumbAware {
    @Override
    public @NotNull FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {

        // Initialize the list of folding regions
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        // following kcl code blocks can be folded:
        // schema stmt
        // config expr in schema expr
        // schema check block
        // dict expr; list expr
        // dict comp; list comp
        // schema docstring
        Collection<KCLElement> structs = PsiTreeUtil.findChildrenOfAnyType(root, KCLSchemaStmt.class, KCLConfigExpr.class,
                KCLCheckBlock.class, KCLListExpr.class, KCLDictComp.class, KCLListComp.class);

        for (final KCLElement struct : structs) {
            FoldingGroup group = FoldingGroup.newGroup(String.format("kcl struct: %s", struct.getTextRange()));
            // add folding descriptor for schema stmt
            if (struct instanceof KCLSchemaStmt) {
                KCLSchemaStmt schema = (KCLSchemaStmt) struct;
                KCLSchemaBody schemaBody = schema.getSchemaBody();

                if (schemaBody != null) {
                    LeafPsiElement prevColon = findPrevLeafOfType(schema, schemaBody);
                    PsiElement schemaBlockEnd = findLastNonNewLineChild(schemaBody);
                    if (prevColon != null) {
                        FoldingDescriptor descriptor = buildFoldingDescriptor(struct.getNode(),
                                prevColon.getTextRange().getStartOffset() + 1, schemaBlockEnd.getTextRange().getEndOffset(), group);
                        if (descriptor != null) {
                            descriptors.add(descriptor);
                        }
                    }

                    // add folding descriptor for schema docstring
                    if (schemaBody.getNode().getFirstChildNode().getElementType() == KCLTypes.LONG_STRING) {
                        ASTNode docstring = schemaBody.getNode().getFirstChildNode();
                        FoldingGroup docstringGroup = FoldingGroup.newGroup(String.format("kcl docstring: %s", docstring.getTextRange()));
                        FoldingDescriptor descriptor = buildFoldingDescriptor(docstring, docstring.getTextRange().getStartOffset() + 3,
                                docstring.getTextRange().getEndOffset() - 3, docstringGroup);
                        if (descriptor != null) {
                            descriptors.add(descriptor);
                        }
                    }
                }
                continue;
            }

            if (struct instanceof KCLCheckBlock) {
                // add folding descriptor for schema check block
                KCLCheckBlock checkBlock = (KCLCheckBlock) struct;
                LeafPsiElement checkBlockColon = findPrevLeafOfType(checkBlock, checkBlock.getCheckExprList().get(0));
                PsiElement checkBlockEnd = findLastNonNewLineChild(checkBlock);
                if (checkBlockColon != null) {
                    FoldingDescriptor descriptor = buildFoldingDescriptor(struct.getNode(),
                            checkBlockColon.getTextRange().getStartOffset() + 1,
                            checkBlockEnd.getTextRange().getEndOffset(), group);

                    if (descriptor != null) {
                        descriptors.add(descriptor);
                    }
                }
                continue;
            }

            if (struct instanceof KCLConfigExpr || struct instanceof KCLListExpr || struct instanceof KCLDictComp
                    || struct instanceof KCLListComp) {
                // add folding descriptor for:
                // config expr in schema expr
                // list expr
                // dict comp; list comp
                FoldingDescriptor descriptor = buildFoldingDescriptor(struct.getNode(), struct.getTextRange().getStartOffset() + 1,
                        struct.getTextRange().getEndOffset() - 1, group);
                if (descriptor != null) {
                    descriptors.add(descriptor);
                }
            }
        }
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }

    @Nullable
    private LeafPsiElement findPrevLeafOfType(KCLElement scope, KCLElement current) {
        IElementType colon = KCLTypes.COLON;
        LeafPsiElement prevLeaf = (LeafPsiElement) PsiTreeUtil.prevLeaf(current);
        while (prevLeaf != null && scope.getTextRange().contains(prevLeaf.getTextRange())
                && prevLeaf.getElementType() != colon) {
            prevLeaf = (LeafPsiElement) PsiTreeUtil.prevLeaf(prevLeaf);
        }
        if (prevLeaf != null && scope.getTextRange().contains(prevLeaf.getTextRange())
                && prevLeaf.getElementType() == colon) {
            return prevLeaf;
        }
        return null;
    }

    private PsiElement findLastNonNewLineChild(KCLElement scope) {
        PsiElement lastElement = PsiTreeUtil.getDeepestLast(scope);
        if (lastElement instanceof LeafPsiElement && ((LeafPsiElement) lastElement).getElementType() == KCLTypes.NEWLINE) {
            return lastElement.getPrevSibling();
        } else {
            return lastElement;
        }
    }

    private @Nullable FoldingDescriptor buildFoldingDescriptor(ASTNode node, int rangeStart, int rangeEnd, FoldingGroup group) {
        if (rangeStart >= rangeEnd) {
            return null;
        }
        return new FoldingDescriptor(node, new TextRange(rangeStart, rangeEnd), group);
    }
}