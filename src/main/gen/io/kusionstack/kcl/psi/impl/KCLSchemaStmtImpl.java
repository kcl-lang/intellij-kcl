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
import com.intellij.navigation.ItemPresentation;

public class KCLSchemaStmtImpl extends ASTWrapperPsiElement implements KCLSchemaStmt {

  public KCLSchemaStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitSchemaStmt(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KCLDecorators getDecorators() {
    return findChildByClass(KCLDecorators.class);
  }

  @Override
  @Nullable
  public KCLForMixinHost getForMixinHost() {
    return findChildByClass(KCLForMixinHost.class);
  }

  @Override
  @NotNull
  public List<KCLIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KCLIdentifier.class);
  }

  @Override
  @Nullable
  public KCLSchemaArguments getSchemaArguments() {
    return findChildByClass(KCLSchemaArguments.class);
  }

  @Override
  @Nullable
  public KCLSchemaBody getSchemaBody() {
    return findChildByClass(KCLSchemaBody.class);
  }

  @Override
  @NotNull
  public KCLSingleName getSingleName() {
    return findNotNullChildByClass(KCLSingleName.class);
  }

  @Override
  @NotNull
  public String getName() {
    return KCLPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(@NotNull String newName) {
    return KCLPsiImplUtil.setName(this, newName);
  }

  @Override
  @NotNull
  public KCLSingleName getNameIdentifier() {
    return KCLPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return KCLPsiImplUtil.getPresentation(this);
  }

  @Override
  @Nullable
  public KCLIdentifier getSuperSchema() {
    return KCLPsiImplUtil.getSuperSchema(this);
  }

}
