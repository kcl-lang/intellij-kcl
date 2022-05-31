/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.lexer;

import com.intellij.lexer.FlexAdapter;

/**
 * @author amyxia
 * @version KCLHighlightingLexer: KCLHighlightingLexer.java, v 0.1 2021年02月04日 5:35 下午 amyxia Exp $
 */
public class KCLHighlightingLexer extends FlexAdapter {

    public KCLHighlightingLexer() {
        super(new _KCLHighlightingLexer(null));
    }

    @Override
    public _KCLHighlightingLexer getFlex() {
        return (_KCLHighlightingLexer) super.getFlex();
    }
}