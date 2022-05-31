/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import com.google.common.collect.Maps;
import io.kusionstack.kcl.psi.KCLIdentifier;
import io.kusionstack.kcl.psi.KCLSingleName;

import java.util.List;
import java.util.Map;

/**
 * @author amyxia
 * @version SchemaSymbol: SchemaSymbol.java, v 0.1 2021年05月31日 9:44 下午 amyxia Exp $
 */
public class SchemaSymbol extends ScopedSymbol implements Scope, Type {
    /**
     * This is the parentSchema not enclosingScope field. We still record the enclosing scope so we can push in and pop out of class defs.
     */
    private SchemaSymbol parentSchema;

    private final KCLIdentifier             parentNode;
    /**
     * List of all fields and methods
     */
    private final Map<String, List<Symbol>> members = Maps.newLinkedHashMap();

    public SchemaSymbol(String name, Scope enclosingScope, KCLIdentifier parent, KCLSingleName node) {
        super(name, enclosingScope, node);
        this.parentNode = parent;
    }

    public Scope getParentScope() {
        if (parentSchema == null) {
            return getEnclosingScope(); // globals
        }
        return parentSchema; // if not root object, return super
    }

    @Override
    public List<Symbol> resolve(String name) {
        // first resolve it as a member
        List<Symbol> s = resolveMember(name);
        if (s != null) {
            return s;
        }
        // if not a member, resolve it in the outer scope
        return getEnclosingScope().resolve(name);
    }

    /**
     * For a.b, only look in a's class hierarchy to resolve b, not globals
     */
    public List<Symbol> resolveMember(String name) {
        List<Symbol> s = this.members.get(name);
        if (s != null) { return s; }
        // if not here, check just the superclass chain
        if (parentSchema != null) {
            return parentSchema.resolveMember(name);
        }
        return null; // not found
    }

    @Override
    public Map<String, List<Symbol>> getMembers() {
        return members;
    }

    /**
     * Setter method for property <tt>parentSchema</tt>.
     *
     * @param parentSchema value to be assigned to property parentSchema
     */
    public void setParentSchema(SchemaSymbol parentSchema) {
        this.parentSchema = parentSchema;
    }

    /**
     * Getter method for property <tt>parentNode</tt>.
     *
     * @return property value of parentNode
     */
    public KCLIdentifier getParentNode() {
        return parentNode;
    }

}