// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KCLIfEntry extends KCLElement {

  @NotNull
  List<KCLIfEntryExecBlock> getIfEntryExecBlockList();

  @NotNull
  List<KCLTest> getTestList();

}
