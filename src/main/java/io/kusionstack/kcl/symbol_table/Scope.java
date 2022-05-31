/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import java.util.List;

/**
 * @author amyxia
 * @version Scope: Scope.java, v 0.1 2021年05月31日 3:10 下午 amyxia Exp $
 */
public interface Scope {
    /**
     * @return name of the scope
     */
    public String getScopeName();

    /**
     * Where to look next for symbols; parentSchema or enclosing scope
     */
    public Scope getParentScope();

    /**
     * Scope in which this scope defined. For global scope, it's null
     */
    public Scope getEnclosingScope();

    /**
     * Define a symbol in the current scope
     */
    public void define(Symbol symbol);

    /**
     * Look up name in this scope or in parent scope if not here
     */
    public List<Symbol> resolve(String name);
}