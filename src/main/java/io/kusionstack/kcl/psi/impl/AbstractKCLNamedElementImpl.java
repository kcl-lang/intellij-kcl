/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.psi.impl;

import io.kusionstack.kcl.psi.KCLNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version KCLNamedElementImpl: KCLNamedElementImpl.java, v 0.1 2020年09月23日 5:01 下午 amyxia Exp $
 */
public abstract class AbstractKCLNamedElementImpl extends ASTWrapperPsiElement implements KCLNamedElement {
    public AbstractKCLNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}