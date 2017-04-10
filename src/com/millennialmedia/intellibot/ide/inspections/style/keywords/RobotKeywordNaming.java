package com.millennialmedia.intellibot.ide.inspections.style.keywords;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.KeywordInvokable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 3/30/2017 AD.
 */
public class RobotKeywordNaming extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof KeywordInvokable){
            return ((KeywordInvokable) element).isCapitalize();
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.keyword.naming");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.keyword.naming");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
