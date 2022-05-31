// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface KCLSchemaStmt extends KCLScopeOwner, KCLNamedElement {

  @Nullable
  KCLDecorators getDecorators();

  @Nullable
  KCLForMixinHost getForMixinHost();

  @NotNull
  List<KCLIdentifier> getIdentifierList();

  @Nullable
  KCLSchemaArguments getSchemaArguments();

  @Nullable
  KCLSchemaBody getSchemaBody();

  @NotNull
  KCLSingleName getSingleName();

  @NotNull
  String getName();

  PsiElement setName(@NotNull String newName);

  @NotNull
  KCLSingleName getNameIdentifier();

  @NotNull
  ItemPresentation getPresentation();

  @Nullable
  KCLIdentifier getSuperSchema();

}
