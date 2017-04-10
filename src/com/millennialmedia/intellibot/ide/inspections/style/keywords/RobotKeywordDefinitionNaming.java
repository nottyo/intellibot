package com.millennialmedia.intellibot.ide.inspections.style.keywords;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.KeywordDefinition;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 3/30/2017 AD.
 */
public class RobotKeywordDefinitionNaming extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof KeywordDefinition) {
            return ((KeywordDefinition) element).isCapitalize();
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.keywordDefinition.naming");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.keywordDefinition.naming");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
