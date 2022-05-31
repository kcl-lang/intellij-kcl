/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

/**
 * @author amyxia
 * @version BuiltInTypeSymbol: BuiltInTypeSymbol.java, v 0.1 2021年05月31日 3:28 下午 amyxia Exp $
 */
public class BuiltInTypeSymbol extends Symbol implements Type {
    public BuiltInTypeSymbol(String name) {
        super(name);
    }
}