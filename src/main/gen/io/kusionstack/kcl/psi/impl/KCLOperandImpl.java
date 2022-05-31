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

public class KCLOperandImpl extends ASTWrapperPsiElement implements KCLOperand {

  public KCLOperandImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitOperand(this);
  }

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
  public KCLLambdaExpr getLambdaExpr() {
    return findChildByClass(KCLLambdaExpr.class);
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

  @Override
  @Nullable
  public KCLQuantExpr getQuantExpr() {
    return findChildByClass(KCLQuantExpr.class);
  }

  @Override
  @Nullable
  public KCLSchemaExpr getSchemaExpr() {
    return findChildByClass(KCLSchemaExpr.class);
  }

  @Override
  @Nullable
  public KCLTest getTest() {
    return findChildByClass(KCLTest.class);
  }

  @Override
  @Nullable
  public KCLTypeCastExpr getTypeCastExpr() {
    return findChildByClass(KCLTypeCastExpr.class);
  }

}
