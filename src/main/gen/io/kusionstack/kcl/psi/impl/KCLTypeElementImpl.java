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

public class KCLTypeElementImpl extends ASTWrapperPsiElement implements KCLTypeElement {

  public KCLTypeElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KCLVisitor visitor) {
    visitor.visitTypeElement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KCLVisitor) accept((KCLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KCLBasicType getBasicType() {
    return findChildByClass(KCLBasicType.class);
  }

  @Override
  @Nullable
  public KCLCompoundType getCompoundType() {
    return findChildByClass(KCLCompoundType.class);
  }

  @Override
  @Nullable
  public KCLLiteralType getLiteralType() {
    return findChildByClass(KCLLiteralType.class);
  }

  @Override
  @Nullable
  public KCLSchemaType getSchemaType() {
    return findChildByClass(KCLSchemaType.class);
  }

}
