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

public class KCLLambdaExprImpl extends ASTWrapperPsiElement implements KCLLambdaExpr {

  public KCLLambdaExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitLambdaExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KCLExprStmt getExprStmt() {
    return findChildByClass(KCLExprStmt.class);
  }

  @Override
  @Nullable
  public KCLSchemaArguments getSchemaArguments() {
    return findChildByClass(KCLSchemaArguments.class);
  }

  @Override
  @NotNull
  public List<KCLSchemaInitStmt> getSchemaInitStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLSchemaInitStmt.class);
  }

  @Override
  @Nullable
  public KCLType getType() {
    return findChildByClass(KCLType.class);
  }

}
