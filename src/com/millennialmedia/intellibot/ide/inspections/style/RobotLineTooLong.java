package com.millennialmedia.intellibot.ide.inspections.style;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.KeywordStatement;
import com.millennialmedia.intellibot.psi.element.VariableDefinition;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 3/30/2017 AD.
 */
public class RobotLineTooLong extends SimpleRobotInspection{
    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof KeywordStatement || element instanceof VariableDefinition) {
            return element.getTextLength() <= 150;
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.line.toolong");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.line.toolong");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
