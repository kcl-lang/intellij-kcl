/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * @author amyxia
 * @version KCLColorSettingsPage: KCLColorSettingsPage.java, v 0.1 2020年09月23日 11:27 上午 amyxia Exp $
 */
public class KCLColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[] {
            new AttributesDescriptor("Keyword", KCLSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Operator Sign", KCLSyntaxHighlighter.OPERATOR_SIGN),
            new AttributesDescriptor("Identifier", KCLSyntaxHighlighter.NAME),
            new AttributesDescriptor("Basic Type", KCLSyntaxHighlighter.BASIC_TYPE),
            new AttributesDescriptor("Build In Literal", KCLSyntaxHighlighter.BOOL_NONE_LITERAL),
            new AttributesDescriptor("String Literal", KCLSyntaxHighlighter.STRING),
            new AttributesDescriptor("DocString Comment", KCLSyntaxHighlighter.DOC_STRING),
            new AttributesDescriptor("End Of Line Comment", KCLSyntaxHighlighter.END_OF_LINE_COMMENT),

            new AttributesDescriptor("Bad Value", KCLSyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return KCLIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new KCLSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "# You are reading the \".properties\" entry.\n" +
                "! The exclamation mark can also mark text as comments.\n" +
                "import module1\n" +
                "import module2 as asName\n" +
                "import ..pkg.module.sub_module1\n" +
                "import ..pkg.module.sub_module2 as asName\n" +
                "\n" +
                "schema Person:\n" +
                "    \"\"\"schema docstring begin\n" +
                "    schema docstring end\"\"\"" +
                "\n" +
                "    name?: str = \"alice\"\n" +
                "    age: int = 5" +
                "\n" +
                "# The backslash below tells the application to continue reading\n" +
                "# the value onto the next line.\n" +
                "myList = [1, 2, \\\n"
                + "3]\n" +
                "\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "KCL";
    }
}