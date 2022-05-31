/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl;

import io.kusionstack.kcl.psi.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author amyxia
 * @version KCLStructureViewElement: KCLStructureViewElement.java, v 0.1 2020年09月24日 2:05 下午 amyxia Exp $
 */
public class KCLStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private final NavigatablePsiElement myElement;

    public KCLStructureViewElement(NavigatablePsiElement element) {
        this.myElement = element;
    }

    @Override
    public Object getValue() {
        return myElement;
    }

    @Override
    public void navigate(boolean requestFocus) {
        myElement.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return myElement.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return myElement.canNavigateToSource();
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        String name = myElement.getName();
        return name != null ? name : "";
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        if (myElement instanceof KCLSingleName && PsiTreeUtil.getParentOfType(myElement, KCLSchemaStmt.class) != null) {
            KCLAttributeStmt attribute = PsiTreeUtil.getParentOfType(myElement, KCLAttributeStmt.class);
            String type = null;
            String value = null;
            if (attribute != null) {
                type = attribute.getType().getText();
                if (attribute.getTest() != null) {
                    int newlineIndex = attribute.getTest().getText().indexOf('\n');
                    value = newlineIndex == -1 ? attribute.getTest().getText() : attribute.getTest().getText().substring(0,
                            newlineIndex) + "...";
                }
            }
            return genAttrPresentation(type, value);
        }

        ItemPresentation presentation = myElement.getPresentation();
        return presentation != null ? presentation : new PresentationData();
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        if (myElement instanceof KCLFile) {
            List<TreeElement> treeElements = Lists.newLinkedList();

            // collect all the schemas defined in the KCL file
            Collection<KCLSchemaStmt> schemas = PsiTreeUtil.findChildrenOfType(myElement, KCLSchemaStmt.class);
            for (KCLSchemaStmt schema : schemas) {
                treeElements.add(new KCLStructureViewElement(schema));
            }

            // collect all the variables defined in the KCL file
            Collection<KCLAssignStmt> assignStmts = PsiTreeUtil.findChildrenOfType(myElement, KCLAssignStmt.class);
            Set<String> vars = Sets.newHashSet();
            for (KCLAssignStmt assign : assignStmts) {
                if (PsiTreeUtil.getParentOfType(assign, KCLSchemaStmt.class) == null) {
                    // only collect variables outside of the schema stmt
                    for (KCLIdentifier target : assign.getIdentifierList()) {
                        if (target.getSingleNameList().size() == 1 && !vars.contains(target.getSingleNameList().get(0).getName())) {
                            vars.add(target.getSingleNameList().get(0).getName());
                            treeElements.add(new KCLStructureViewElement(target.getSingleNameList().get(0)));
                        }
                    }
                }
            }
            return treeElements.toArray(new TreeElement[treeElements.size()]);
        }
        if (myElement instanceof KCLSchemaStmt) {
            Collection<KCLAttributeStmt> attributes = PsiTreeUtil.findChildrenOfType(myElement, KCLAttributeStmt.class);
            List<TreeElement> treeElements = Lists.newLinkedList();
            Set<String> attrs = Sets.newHashSet();
            for (KCLAttributeStmt attr : attributes) {
                if (!attrs.contains(attr.getSingleName().getName())) {
                    attrs.add(attr.getSingleName().getName());
                    treeElements.add(new KCLStructureViewElement(attr.getSingleName()));
                }
            }
            return treeElements.toArray(new TreeElement[treeElements.size()]);
        }

        return EMPTY_ARRAY;
    }

    private ItemPresentation genAttrPresentation(@Nullable String type, @Nullable String value) {
        return new ItemPresentation() {
            @Override
            public @Nullable String getPresentableText() {
                String typeText = "";
                String valueText = "";
                if (type != null) {
                    typeText = String.format(": %s", type);
                }
                if (value != null) {
                    valueText = String.format(" = %s", value);
                }
                return String.format("%s%s%s", myElement.getName(), typeText, valueText);
            }

            @Override
            public @Nullable String getLocationString() {
                return null;
            }

            @Override
            public Icon getIcon(boolean unused) {
                return KCLIcons.ATTRIBUTE;
            }
        };
    }
}