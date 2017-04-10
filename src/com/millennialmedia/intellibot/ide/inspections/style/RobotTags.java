package com.millennialmedia.intellibot.ide.inspections.style;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.*;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 4/4/2017 AD.
 */
public class RobotTags extends SimpleRobotInspection {
    private boolean isDefaultTags = false;

    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof Setting) {
            if(((Setting) element).isDefaultTags()) {
                Setting setting = (Setting) element;
                if (defaultTagsContainTagName(setting)) {
                    isDefaultTags = true;
                    return true;
                } else {
                    isDefaultTags = false;
                }
            } else {
                isDefaultTags = false;
            }
        } else if (element instanceof KeywordDefinition) {
            if (((KeywordDefinition) element).isTestCase()) {
                return isDefaultTags || ((KeywordDefinition) element).containTags();
            }
        }
        return true;
    }

    private boolean defaultTagsContainTagName(Setting element) {
        for (PsiElement child : element.getChildren()) {
            if (child instanceof Argument) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.tags.definition");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.tags.definition");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
