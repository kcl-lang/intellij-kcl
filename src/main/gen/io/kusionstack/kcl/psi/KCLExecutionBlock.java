// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KCLExecutionBlock extends KCLElement {

  @Nullable
  KCLIfSimpleStmt getIfSimpleStmt();

  @NotNull
  List<KCLSchemaInitStmt> getSchemaInitStmtList();

}
