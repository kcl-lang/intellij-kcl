/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl;

import io.kusionstack.kcl.psi.KCLFile;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version KCLStructureViewModel: KCLStructureViewModel.java, v 0.1 2020年09月24日 2:03 下午 amyxia Exp $
 */
public class KCLStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
    public KCLStructureViewModel(PsiFile psiFile) {
        super(psiFile, new KCLStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }


    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element instanceof KCLFile;
    }

}