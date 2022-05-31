/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import io.kusionstack.kcl.psi.KCLSingleName;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * @author amyxia
 * @version ScopedSymbol: ScopedSymbol.java, v 0.1 2021年05月31日 9:45 下午 amyxia Exp $
 */
public abstract class ScopedSymbol extends Symbol implements Scope {
    private final Scope enclosingScope;

    public ScopedSymbol(String name, Type type, Scope enclosingScope, KCLSingleName node) {
        super(name, type, node);
        this.enclosingScope = enclosingScope;
    }

    public ScopedSymbol(String name, Scope enclosingScope, KCLSingleName node) {
        super(name, node);
        this.enclosingScope = enclosingScope;
    }

    public List<Symbol> resolve(String name) {
        List<Symbol> s = getMembers().get(name);
        if (s != null) {
            return s;
        }
        // if not here, check any parent scope
        if (getParentScope() != null) {
            return getParentScope().resolve(name);
        }
        return null; // not found
    }

    public void define(Symbol symbol) {
        List<Symbol> list = getMembers().get(symbol.getName());
        if (list == null) {
            getMembers().put(symbol.getName(), Lists.newArrayList(symbol));
        } else {
            list.add(symbol);
        }
        symbol.setScope(this); // track the scope in each symbol
    }

    public Scope getParentScope() { return getEnclosingScope(); }

    public Scope getEnclosingScope() { return enclosingScope; }

    public String getScopeName() { return this.getName(); }

    /**
     * Indicate how subclasses store scope members. Allows us to factor out common code in this class.
     */
    public abstract Map<String, List<Symbol>> getMembers();
}