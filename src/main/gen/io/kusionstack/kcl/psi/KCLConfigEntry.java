// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KCLConfigEntry extends KCLElement {

  @Nullable
  KCLDoubleStarExpr getDoubleStarExpr();

  @Nullable
  KCLIfEntry getIfEntry();

  @NotNull
  List<KCLTest> getTestList();

}
