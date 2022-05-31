/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import io.kusionstack.kcl.psi.KCLSingleName;
import com.intellij.psi.PsiFileSystemItem;

import java.util.List;
import java.util.Map;

/**
 * @author amyxia
 * @version PkgSymbol: PkgSymbol.java, v 0.1 2021年06月08日 10:31 上午 amyxia Exp $
 */
public class PkgSymbol extends ScopedSymbol implements Scope {
    private PsiFileSystemItem         resolvedModule;
    private boolean                   visited = false;
    /**
     * List of all fields and methods
     */
    private Map<String, List<Symbol>> members;

    public PkgSymbol(String name, Scope enclosingScope, KCLSingleName node, PsiFileSystemItem resolvedModule) {
        super(name, enclosingScope, node);
        this.resolvedModule = resolvedModule;
    }

    @Override
    public Map<String, List<Symbol>> getMembers() {
        return members;
    }

    /**
     * Getter method for property <tt>visited</tt>.
     *
     * @return property value of visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Setter method for property <tt>visited</tt>.
     *
     * @param visited value to be assigned to property visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Getter method for property <tt>resolvedModule</tt>.
     *
     * @return property value of resolvedModule
     */
    public PsiFileSystemItem getResolvedModule() {
        return resolvedModule;
    }

    public void setMembers(Map<String, List<Symbol>> members) {
        this.members = members;
    }

}