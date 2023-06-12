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

public class KCLQuantExprImpl extends ASTWrapperPsiElement implements KCLQuantExpr {

  public KCLQuantExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitQuantExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KCLIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLIdentifier.class);
  }

  @Override
  @NotNull
  public KCLQuantOp getQuantOp() {
    return findNotNullChildByClass(KCLQuantOp.class);
  }

  @Override
  @NotNull
  public KCLQuantTarget getQuantTarget() {
    return findNotNullChildByClass(KCLQuantTarget.class);
  }

  @Override
  @NotNull
  public List<KCLSimpleExpr> getSimpleExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLSimpleExpr.class);
  }

}
