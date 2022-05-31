// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KCLSimpleStmt extends KCLElement {

  @Nullable
  KCLAssertStmt getAssertStmt();

  @Nullable
  KCLAssignStmt getAssignStmt();

  @Nullable
  KCLExprStmt getExprStmt();

  @Nullable
  KCLImportStmt getImportStmt();

  @Nullable
  KCLTypeAliasStmt getTypeAliasStmt();

  @Nullable
  KCLUnificationStmt getUnificationStmt();

}
