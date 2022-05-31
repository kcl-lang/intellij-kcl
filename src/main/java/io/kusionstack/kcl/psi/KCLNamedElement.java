/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version KCLNamedElement: KCLNamedElement.java, v 0.1 2020年09月23日 5:00 下午 amyxia Exp $
 */
public interface KCLNamedElement extends PsiNameIdentifierOwner, NavigatablePsiElement {
    @NotNull
    String getName();

    @NotNull
    PsiElement getNameIdentifier();

    @NotNull
    ItemPresentation getPresentation();
}