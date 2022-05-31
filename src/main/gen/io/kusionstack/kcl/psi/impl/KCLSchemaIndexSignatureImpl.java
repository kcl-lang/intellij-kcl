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

public class KCLSchemaIndexSignatureImpl extends ASTWrapperPsiElement implements KCLSchemaIndexSignature {

  public KCLSchemaIndexSignatureImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitSchemaIndexSignature(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public KCLBasicType getBasicType() {
    return findNotNullChildByClass(KCLBasicType.class);
  }

  @Override
  @Nullable
  public KCLSingleName getSingleName() {
    return findChildByClass(KCLSingleName.class);
  }

  @Override
  @Nullable
  public KCLTest getTest() {
    return findChildByClass(KCLTest.class);
  }

  @Override
  @NotNull
  public KCLType getType() {
    return findNotNullChildByClass(KCLType.class);
  }

}
