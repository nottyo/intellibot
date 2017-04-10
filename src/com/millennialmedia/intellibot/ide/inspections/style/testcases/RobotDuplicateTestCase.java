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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by traitanit on 3/31/2017 AD.
 */
public class RobotDuplicateTestCase extends SimpleRobotInspection {
    @Override
    public boolean skip(PsiElement element) {
        PsiElement parent = element.getParent();
        if (element instanceof KeywordDefinition && parent instanceof Heading) {
            Heading heading = (Heading) parent;
            if (heading.containsTestCases()) {
                return findDuplicateTestCases(heading.getTestCases());
            }
        }
        return true;
    }

    private boolean findDuplicateTestCases(Collection<DefinedKeyword> testcaseList) {
        Set<String> uniqueTests = new HashSet<>();
        for (DefinedKeyword testcase : testcaseList) {
            if (!uniqueTests.add(testcase.getKeywordName().split("\\s")[0])) {
                return false;
            }
            uniqueTests.add(testcase.getKeywordName());
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.testcase.duplicate");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.testcase.duplicate");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
