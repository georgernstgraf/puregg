package de.gaffga.android.zazentimer;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static org.hamcrest.Matchers.containsString;

@HiltAndroidTest
@RunWith(AndroidJUnit4.class)
@LargeTest
public class DuplicateSessionTest {

    @Rule(order = 0)
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Rule(order = 1)
    public ActivityScenarioRule<ZazenTimerActivity> activityRule =
            new ActivityScenarioRule<>(ZazenTimerActivity.class);

    @Before
    public void init() {
        hiltRule.inject();
    }

    @Test
    public void testDuplicateSessionDoesNotCrash() {
        onView(withId(R.id.recycler_sessions))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.sessionOverflow))
                .perform(click());

        onView(withText(R.string.menu_copy_session))
                .perform(click());

        onView(withId(R.id.recycler_sessions))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testDuplicateSessionCreatesCopyWithPrefix() {
        onView(withId(R.id.sessionOverflow))
                .perform(click());

        onView(withText(R.string.menu_copy_session))
                .perform(click());

        onView(withText(containsString("Copy of")))
                .check(matches(isDisplayed()));
    }
}
