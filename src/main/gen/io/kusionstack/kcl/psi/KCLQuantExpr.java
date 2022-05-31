// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KCLQuantExpr extends KCLElement {

  @NotNull
  List<KCLIdentifier> getIdentifierList();

  @NotNull
  KCLQuantOp getQuantOp();

  @NotNull
  KCLQuantTarget getQuantTarget();

  @NotNull
  List<KCLSimpleExpr> getSimpleExprList();

}
