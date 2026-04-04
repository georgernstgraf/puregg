package de.gaffga.android.zazentimer.screens;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

/**
 * Base page class that contains common functionality for all page objects.
 */
public abstract class BasePage {
    
    /**
     * Checks if an element is displayed on the screen.
     * @param viewId The ID of the view to check
     */
    public void checkElementIsDisplayed(int viewId) {
        onViewWithId(viewId).check(matches(isDisplayed()));
    }
    
    /**
     * Clicks on a view with the specified ID.
     * @param viewId The ID of the view to click
     */
    public void clickOnView(int viewId) {
        onViewWithId(viewId).perform(click());
    }
    
    /**
     * Gets a ViewInteraction for a view with the specified ID.
     * @param viewId The ID of the view
     * @return ViewInteraction for the view
     */
    protected ViewInteraction onViewWithId(int viewId) {
        return Espresso.onView(ViewMatchers.withId(viewId));
    }
}