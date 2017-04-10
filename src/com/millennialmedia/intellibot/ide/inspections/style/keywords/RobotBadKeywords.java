package com.millennialmedia.intellibot.ide.inspections.style.keywords;

import com.google.common.collect.ImmutableList;
import com.intellij.psi.PsiElement;
import com.millennialmedia.intellibot.RobotBundle;
import com.millennialmedia.intellibot.ide.inspections.SimpleRobotInspection;
import com.millennialmedia.intellibot.psi.element.KeywordInvokable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

/**
 * Created by traitanit on 4/4/2017 AD.
 */
public class RobotBadKeywords extends SimpleRobotInspection {

    public static final ImmutableList<String> BAD_KEYWORDS =
            ImmutableList.of("log", "log to console", "log many", "log variables", "sleep",
                    "set global variable");

    @Override
    public boolean skip(PsiElement element) {
        if (element instanceof KeywordInvokable) {
            List<String> badKeywords = BAD_KEYWORDS.asList();
            return !badKeywords.contains(((KeywordInvokable) element).getPresentableText().toLowerCase());
        }
        return true;
    }

    @Override
    public String getMessage() {
        return RobotBundle.message("INSP.NAME.keyword.badkeyword");
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return RobotBundle.message("INSP.keyword.badkeyword");
    }

    @NotNull
    @Override
    protected String getGroupNameKey() {
        return "INSP.GROUP.style";
    }
}
