/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

/**
 * @author amyxia
 * @version GlobalScope: GlobalScope.java, v 0.1 2021年05月31日 3:09 下午 amyxia Exp $
 */
public class GlobalScope extends BaseScope {
    public GlobalScope() {
        super(null);
    }

    @Override
    public String getScopeName() {
        return "global";
    }
}