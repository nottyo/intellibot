package com.millennialmedia.intellibot.ide.inspections.style.keywords;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.config.RobotOptionsProvider;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.BracketSetting;
import com.millennialmedia.intellibot.psi.element.KeywordDefinition;
import com.millennialmedia.intellibot.psi.element.KeywordDefinitionId;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by traitanit on 3/30/2017 AD.
 */
public class RobotMinSteps extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        int stepsCount=0;
        int minSteps = RobotOptionsProvider.getInstance(element.getProject()).getMinSteps();
        if (element instanceof KeywordDefinition){
            for (PsiElement child : element.getChildren()){
                if (!(child instanceof BracketSetting) && !(child instanceof KeywordDefinitionId)){
                    stepsCount++;
                }
            }
            return stepsCount > minSteps;
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.steps.minsteps");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.steps.minsteps");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return null;
    }
}
