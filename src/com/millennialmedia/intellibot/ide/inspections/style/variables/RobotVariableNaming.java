package com.millennialmedia.intellibot.ide.inspections.style.variables;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.Variable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 3/29/2017 AD.
 */
public class RobotVariableNaming extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof Variable){
            return ((Variable) element).isValidNaming();
        }
        return true;
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.variable.naming");
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.variable.naming");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
