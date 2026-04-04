package de.gaffga.android.zazentimer.screens;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import android.widget.Spinner;

import de.gaffga.android.zazentimer.R;

/**
 * Page object for the main screen of the application.
 */
public class MainPage extends BasePage {
    
    /**
     * Verifies that the main screen is displayed correctly.
     * @return This MainPage instance for method chaining
     */
    public MainPage verifyMainScreenIsDisplayed() {
        checkElementIsDisplayed(R.id.my_toolbar);
        checkElementIsDisplayed(R.id.but_start);
        checkElementIsDisplayed(R.id.spin_sessions);
        return this;
    }
    
    /**
     * Verifies that default sessions are visible in the spinner.
     * @return This MainPage instance for method chaining
     */
    public MainPage verifyDefaultSessionsAreVisible() {
        // Check that the spinner has at least one session
        onView(withId(R.id.spin_sessions)).check(matches(isDisplayed()));
        // Check that the start button is enabled (indicating a session is selected)
        onView(withId(R.id.but_start)).check(matches(isDisplayed()));
        return this;
    }
    
    /**
     * Selects a session from the spinner by its position.
     * @param position The position of the session in the spinner
     * @return This MainPage instance for method chaining
     */
    public MainPage selectSessionByPosition(int position) {
        onView(withId(R.id.spin_sessions)).perform(click());
        onData(is(instanceOf(String.class))).atPosition(position).perform(click());
        return this;
    }
    
    /**
     * Clicks the start meditation button.
     * @return The MeditationPage instance after starting meditation
     */
    public MeditationPage clickStartMeditation() {
        clickOnView(R.id.but_start);
        return new MeditationPage();
    }
}