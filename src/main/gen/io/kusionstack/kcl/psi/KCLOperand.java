// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KCLOperand extends KCLElement {

  @Nullable
  KCLConfigExpr getConfigExpr();

  @Nullable
  KCLDictComp getDictComp();

  @Nullable
  KCLIdentifier getIdentifier();

  @Nullable
  KCLLambdaExpr getLambdaExpr();

  @Nullable
  KCLListComp getListComp();

  @Nullable
  KCLListExpr getListExpr();

  @Nullable
  KCLQuantExpr getQuantExpr();

  @Nullable
  KCLSchemaExpr getSchemaExpr();

  @Nullable
  KCLTest getTest();

  @Nullable
  KCLTypeCastExpr getTypeCastExpr();

}
