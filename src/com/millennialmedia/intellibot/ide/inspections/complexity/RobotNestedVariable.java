package com.millennialmedia.intellibot.ide.inspections.complexity;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.RobotTokenTypes;
import com.millennialmedia.intellibot.psi.element.Variable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * @author mrubino
 * @since 2015-08-24
 */
public class RobotNestedVariable extends SimpleRobotInspection {

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.NAME.variable.nested");
    }

    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof Variable){
            return !((Variable) element).isNested();
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.variable.nested");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.complexity";
    }
}
