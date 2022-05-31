/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import io.kusionstack.kcl.psi.KCLSingleName;

/**
 * KCLSymbol is the base class for all symbols in KCL
 *
 * @author amyxia
 * @version KCLSymbol: KCLSymbol.java, v 0.1 2021年01月07日 7:48 下午 amyxia Exp $
 */
public class Symbol {
    private String        name;      // All symbols at least have a name
    private Type          type;
    private Scope         Scope;      // All symbols know what scope contains them.
    private KCLSingleName node;    // points at ID node in psi tree

    public Symbol(String name) {
        this.name = name;
    }

    public Symbol(String name, KCLSingleName node) {
        this(name);
        this.node = node;
    }

    public Symbol(String name, Type type, KCLSingleName node) {
        this(name, node);
        this.type = type;
    }

    public String getName() { return name; }

    /**
     * Getter method for property <tt>Scope</tt>.
     *
     * @return property value of Scope
     */
    public Scope getScope() {
        return Scope;
    }

    /**
     * Setter method for property <tt>Scope</tt>.
     *
     * @param scope value to be assigned to property Scope
     */
    public void setScope(Scope scope) {
        Scope = scope;
    }

    /**
     * Getter method for property <tt>def</tt>.
     *
     * @return property value of def
     */
    public KCLSingleName getNode() {
        return node;
    }

    /**
     * Getter method for property <tt>type</tt>.
     *
     * @return property value of type
     */
    public Type getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     *
     * @param type value to be assigned to property type
     */
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Symbol && this.getNode().equals(((Symbol) obj).getNode());
    }

    @Override
    public int hashCode() {
        return this.getNode().hashCode();
    }
}