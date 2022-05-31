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

public class KCLSchemaBodyImpl extends ASTWrapperPsiElement implements KCLSchemaBody {

  public KCLSchemaBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitSchemaBody(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KCLCheckBlock getCheckBlock() {
    return findChildByClass(KCLCheckBlock.class);
  }

  @Override
  @Nullable
  public KCLMixinStmt getMixinStmt() {
    return findChildByClass(KCLMixinStmt.class);
  }

  @Override
  @NotNull
  public List<KCLSchemaAttributeStmt> getSchemaAttributeStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLSchemaAttributeStmt.class);
  }

  @Override
  @NotNull
  public List<KCLSchemaIndexSignature> getSchemaIndexSignatureList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLSchemaIndexSignature.class);
  }

  @Override
  @NotNull
  public List<KCLSchemaInitStmt> getSchemaInitStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLSchemaInitStmt.class);
  }

}
