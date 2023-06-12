// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.kusionstack.kcl.psi.KCLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.kusionstack.kcl.psi.*;

public class KCLQuantTargetImpl extends ASTWrapperPsiElement implements KCLQuantTarget {

  public KCLQuantTargetImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitQuantTarget(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KCLConfigExpr getConfigExpr() {
    return findChildByClass(KCLConfigExpr.class);
  }

  @Override
  @Nullable
  public KCLDictComp getDictComp() {
    return findChildByClass(KCLDictComp.class);
  }

  @Override
  @Nullable
  public KCLIdentifier getIdentifier() {
    return findChildByClass(KCLIdentifier.class);
  }

  @Override
  @Nullable
  public KCLListComp getListComp() {
    return findChildByClass(KCLListComp.class);
  }

  @Override
  @Nullable
  public KCLListExpr getListExpr() {
    return findChildByClass(KCLListExpr.class);
  }

}
