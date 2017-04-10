package com.millennialmedia.intellibot.ide.inspections.style.keywords;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.BracketSetting;
import com.millennialmedia.intellibot.psi.element.KeywordDefinition;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 3/30/2017 AD.
 */
public class RobotDocumentation extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof KeywordDefinition) {
            for (PsiElement child: element.getChildren()) {
                if (child instanceof BracketSetting) {
                    if (((BracketSetting) child).isDocumented()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.keywordDefinition.documentation");
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.keywordDefinition.documentation");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
