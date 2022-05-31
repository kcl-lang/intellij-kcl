/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import io.kusionstack.kcl.psi.KCLFile;
import io.kusionstack.kcl.psi.KCLSingleName;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileSystemItem;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author amyxia
 * @version KCLSymbolTable: KCLSymbolTable.java, v 0.1 2021年01月07日 5:16 下午 amyxia Exp $
 */
public class SymbolTable {
    private Map<KCLSingleName, Symbol>       defs = Maps.newHashMap();
    private Map<KCLSingleName, List<Symbol>> refs = Maps.newHashMap();
    private Map<String, PkgSymbol>           pkgs = Maps.newHashMap();

    public SymbolTable() {
        initTypeSystem();
    }

    GlobalScope globalScope = new GlobalScope();

    private void initTypeSystem() {
        // define builtin types
        globalScope.define(new BuiltInTypeSymbol("str"));
        globalScope.define(new BuiltInTypeSymbol("bool"));
        globalScope.define(new BuiltInTypeSymbol("int"));
        globalScope.define(new BuiltInTypeSymbol("float"));
    }

    public void recordDefSymbol(KCLSingleName identifier, Symbol symbol) {
        defs.put(identifier, symbol);
    }

    public void recordRefSymbols(KCLSingleName identifier, List<Symbol> symbols) {
        refs.put(identifier, symbols);
    }

    public void recordRefSymbol(KCLSingleName identifier, Symbol symbol) {
        refs.put(identifier, Lists.newArrayList(symbol));
    }

    public @Nullable List<Symbol> searchSymbol(KCLSingleName name) {
        Symbol def = defs.get(name);
        if (def != null) {
            return Lists.newArrayList(def);
        }
        return refs.get(name);
    }

    public @Nullable Symbol searchDef(KCLSingleName name) {
        return this.defs.get(name);
    }

    public void recordPkg(PsiFileSystemItem pkg, PkgSymbol p) {
        String absolutePath = pkg.getVirtualFile().getPath();
        if (pkgs.get(absolutePath) != null) {
            return;
        }
        SymbolTable st = new SymbolTable();
        DefSymbolTableVisitor defVisitor = new DefSymbolTableVisitor(st);
        List<PsiElement> kclFiles = Arrays.stream(pkg.getChildren()).filter(e -> e instanceof KCLFile).collect(Collectors.toList());
        for (PsiElement file : kclFiles) {
            defVisitor.startVisit((KCLFile) file);
        }
        Map<String, List<Symbol>> members = Maps.newConcurrentMap();
        for (Map.Entry<KCLSingleName, Symbol> entry : st.defs.entrySet()) {
            List<Symbol> list = members.get(entry.getKey().getName());
            if (list == null) {
                members.put(entry.getKey().getName(), Lists.newArrayList(entry.getValue()));
            } else {
                list.add(entry.getValue());
            }
        }
        p.setMembers(members);
        pkgs.put(absolutePath, p);
    }

    public @Nullable PkgSymbol searchPkg(String absolutePath) {
        return pkgs.get(absolutePath);
    }
}