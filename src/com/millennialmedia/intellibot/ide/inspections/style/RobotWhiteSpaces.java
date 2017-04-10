package com.millennialmedia.intellibot.ide.inspections.style;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.Argument;
import com.millennialmedia.intellibot.psi.element.BracketSetting;
import com.millennialmedia.intellibot.psi.element.KeywordInvokable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 4/4/2017 AD.
 */
public class RobotWhiteSpaces extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof PsiWhiteSpace) {
            PsiElement prevElement = element.getPrevSibling();
            PsiElement nextElement = element.getNextSibling();
            PsiElement parent = element.getParent();
            // whitespace btw keyword and argument
            if (prevElement instanceof KeywordInvokable && nextElement instanceof Argument) {
                return element.getTextLength() == 4;
            }
            // whitespace btw argument and argument
            if (prevElement instanceof Argument && nextElement instanceof Argument) {
                return element.getTextLength() == 4;
            }
            // whitespace btw bracket and argument
            if (parent instanceof BracketSetting && nextElement instanceof Argument) {
                return element.getTextLength() == 4;
            }
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.statement.whitespace");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.statement.whitespace");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
