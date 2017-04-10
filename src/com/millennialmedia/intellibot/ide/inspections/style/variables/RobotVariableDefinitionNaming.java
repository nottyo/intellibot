package com.millennialmedia.intellibot.ide.inspections.style.variables;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.VariableDefinition;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 3/29/2017 AD.
 */
public class RobotVariableDefinitionNaming extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof VariableDefinition){
            return ((VariableDefinition) element).isValidNaming();
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.variableDefinition.naming");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.variableDefinition.naming");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
