package com.millennialmedia.intellibot.psi.element;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiReference;
import com.millennialmedia.intellibot.psi.ref.RobotVariableReference;
import com.millennialmedia.intellibot.psi.util.PatternUtil;
import com.millennialmedia.intellibot.psi.util.ReservedVariable;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.xerces.impl.xpath.regex.Match;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mrubino
 * @since 2015-07-15
 */
public class VariableImpl extends RobotPsiElementBase implements Variable {

    public VariableImpl(@NotNull final ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference getReference() {
        return new RobotVariableReference(this);
    }

    @Override
    public boolean isNested() {
        // TODO: this should become a check if the parent is a variable or a variable definition once we identify the nesting correctly
        String text = getPresentableText();
        return StringUtil.getOccurrenceCount(text, "}") > 1 &&
                (StringUtil.getOccurrenceCount(text, "${") + StringUtil.getOccurrenceCount(text, "@{") + StringUtil.getOccurrenceCount(text, "%{") > 1);
    }

    @Override
    public boolean isValidNaming() {
        //ignore checking wih %{ENV_VARIABLE} and reserved variables
        if(Pattern.matches("%\\{.*\\}", getPresentableText()) || ReservedVariable.isReservedVariable(getPresentableText())){
            return true;
        }
        String regex = "^[$|@|&]\\{[a-z0-9_]+\\}[=]?";
        return Pattern.matches(regex, getPresentableText().trim());
    }
}
