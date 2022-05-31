/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import io.kusionstack.kcl.psi.KCLSingleName;

/**
 * VariableSymbol represents a variable definition (name,type) in symbol table
 *
 * @author amyxia
 * @version VariableSymbol: VariableSymbol.java, v 0.1 2021年05月31日 3:54 下午 amyxia Exp $
 */
public class VariableSymbol extends Symbol {
    public VariableSymbol(String name, Type type, KCLSingleName node) {
        super(name, type, node);
    }
}