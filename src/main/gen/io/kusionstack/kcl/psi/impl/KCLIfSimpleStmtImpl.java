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

public class KCLIfSimpleStmtImpl extends ASTWrapperPsiElement implements KCLIfSimpleStmt {

  public KCLIfSimpleStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitIfSimpleStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KCLAssertStmt getAssertStmt() {
    return findChildByClass(KCLAssertStmt.class);
  }

  @Override
  @Nullable
  public KCLExprStmt getExprStmt() {
    return findChildByClass(KCLExprStmt.class);
  }

  @Override
  @Nullable
  public KCLSimpleAssignStmt getSimpleAssignStmt() {
    return findChildByClass(KCLSimpleAssignStmt.class);
  }

  @Override
  @Nullable
  public KCLUnificationStmt getUnificationStmt() {
    return findChildByClass(KCLUnificationStmt.class);
  }

}
