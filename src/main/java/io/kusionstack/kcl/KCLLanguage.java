/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl;

import com.intellij.lang.Language;

/**
 * this file defines the language name
 *
 * @author amyxia
 * @version KclLanguage: KclLanguage.java, v 0.1 2020年09月21日 9:49 下午 amyxia Exp $
 */
public final class KCLLanguage extends Language {
    public static final KCLLanguage INSTANCE = new KCLLanguage();

    private KCLLanguage() {
        super("KCL");
    }
}