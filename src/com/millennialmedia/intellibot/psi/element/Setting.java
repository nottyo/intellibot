package com.millennialmedia.intellibot.psi.element;

/**
 * @author mrubino
 */
public interface Setting extends RobotStatement {

    /**
     * Determines if the current element is a 'Suite Teardown' element.
     *
     * @return true if this is a suite teardown element; false otherwise.
     */
    boolean isSuiteTeardown();

    /**
     * Determines if the current element is a 'Test Teardown' element.
     *
     * @return true if this is a test teardown element; false otherwise.
     */
    boolean isTestTeardown();

    /**
     * Determines if the current element is a 'Default Tags' element.
     *
     * @return true if this is a default tags element; false otherwise.
     */
    boolean isDefaultTags();

    /**
     * Determines if the current element is a 'Force Tags' element.
     *
     * @return true if this is a force tags element; false otherwise.
     */
    boolean isForceTags();
}
