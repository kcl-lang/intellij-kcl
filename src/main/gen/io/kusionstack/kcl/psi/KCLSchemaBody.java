// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KCLSchemaBody extends KCLElement {

  @Nullable
  KCLCheckBlock getCheckBlock();

  @Nullable
  KCLMixinStmt getMixinStmt();

  @NotNull
  List<KCLSchemaAttributeStmt> getSchemaAttributeStmtList();

  @NotNull
  List<KCLSchemaIndexSignature> getSchemaIndexSignatureList();

  @NotNull
  List<KCLSchemaInitStmt> getSchemaInitStmtList();

}
