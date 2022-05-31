/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * base Scope for Global Scope or local Scope.
 *
 * @author amyxia
 * @version BaseScope: BaseScope.java, v 0.1 2021年05月31日 3:13 下午 amyxia Exp $
 */
public abstract class BaseScope implements Scope {
    Scope                     enclosingScope; // null if global (outermost) scope
    Map<String, List<Symbol>> symbols = Maps.newLinkedHashMap();

    public BaseScope(Scope parent) { this.enclosingScope = parent; }

    public List<Symbol> resolve(String name) {
        List<Symbol> s = symbols.get(name);
        if (s != null) { return s; }
        // if not here, check any enclosing scope
        if (getParentScope() != null) { return getParentScope().resolve(name); }
        return null; // not found
    }

    public void define(Symbol symbol) {
        symbol.setScope(this); // track the scope in each symbol
        List<Symbol> list = symbols.get(symbol.getName());
        if (list == null) {
            symbols.put(symbol.getName(), Lists.newArrayList(symbol));
        } else {
            list.add(symbol);
        }
    }

    @Override
    public Scope getParentScope() {
        return getEnclosingScope();
    }

    @Override
    public Scope getEnclosingScope() {
        return enclosingScope;
    }
}