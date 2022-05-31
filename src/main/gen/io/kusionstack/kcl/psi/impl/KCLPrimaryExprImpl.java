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

public class KCLPrimaryExprImpl extends ASTWrapperPsiElement implements KCLPrimaryExpr {

  public KCLPrimaryExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitPrimaryExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KCLCallSuffix> getCallSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLCallSuffix.class);
  }

  @Override
  @NotNull
  public KCLOperand getOperand() {
    return findNotNullChildByClass(KCLOperand.class);
  }

  @Override
  @NotNull
  public List<KCLSelectSuffix> getSelectSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLSelectSuffix.class);
  }

  @Override
  @NotNull
  public List<KCLSliceSuffix> getSliceSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLSliceSuffix.class);
  }

}
