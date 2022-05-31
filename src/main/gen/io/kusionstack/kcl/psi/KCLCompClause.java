// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KCLCompClause extends KCLElement {

  @NotNull
  KCLLoopVariables getLoopVariables();

  @NotNull
  KCLSimpleExpr getSimpleExpr();

  @Nullable
  KCLTest getTest();

}
