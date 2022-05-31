/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.psi;

import io.kusionstack.kcl.KCLLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version KCLTokenType: KCLTokenType.java, v 0.1 2020年09月22日 5:46 下午 amyxia Exp $
 */
public class KCLTokenType extends IElementType {
    public KCLTokenType(@NotNull @NonNls String debugName) {
        super(debugName, KCLLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "KCLTokenType." + super.toString();
    }
}