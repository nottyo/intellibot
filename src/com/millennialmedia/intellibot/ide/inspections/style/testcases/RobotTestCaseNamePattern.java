package com.millennialmedia.intellibot.ide.inspections.style.testcases;

import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.DefinedKeyword;
import com.millennialmedia.intellibot.psi.element.Heading;
import com.millennialmedia.intellibot.psi.element.KeywordDefinition;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.regex.Pattern;

/**
 * Created by traitanit on 3/31/2017 AD.
 */
public class RobotTestCaseNamePattern extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        PsiElement parent = element.getParent();
        if (element instanceof KeywordDefinition && parent instanceof Heading) {
            Heading heading = ((Heading) parent);
            if (heading.containsTestCases()) {
                return isValidTestCaseNamePattern(((KeywordDefinition) element).getPresentableText());
            }
        }
        return true;
    }

    private boolean isValidTestCaseNamePattern(@NotNull String testCase) {
        String regex = "^TC_[A-Z0-9]+_\\d{5}$";
        String testCaseName = testCase.split("\\s")[0];
        return Pattern.matches(regex, testCaseName) && !testCase.contains(".");
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.testcase.pattern");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.testcase.pattern");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
