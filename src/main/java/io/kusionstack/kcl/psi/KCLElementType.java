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
 * @version KCLElementType: KCLElementType.java, v 0.1 2020年09月22日 5:51 下午 amyxia Exp $
 */
public class KCLElementType extends IElementType {
    public KCLElementType(@NotNull @NonNls String debugName) {
        super(debugName, KCLLanguage.INSTANCE);
    }
}