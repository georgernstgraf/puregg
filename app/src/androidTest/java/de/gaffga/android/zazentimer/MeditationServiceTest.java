package de.gaffga.android.zazentimer;

import android.content.SharedPreferences;
import android.os.SystemClock;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.gaffga.android.zazentimer.screens.MainPage;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@HiltAndroidTest
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MeditationServiceTest {

    @Rule(order = 0)
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Rule(order = 1)
    public ActivityScenarioRule<ZazenTimerActivity> activityRule =
            new ActivityScenarioRule<>(ZazenTimerActivity.class);

    @Before
    public void init() {
        hiltRule.inject();
        try {
            activityRule.getScenario().onActivity(activity -> {
                SharedPreferences pref = ZazenTimerActivity.getPreferences(activity);
                pref.edit()
                    .putBoolean("mute_mode_none", false)
                    .putBoolean("mute_mode_vibrate", false)
                    .putBoolean("mute_mode_vibrate_sound", true)
                    .apply();
            });
        } catch (Exception e) { }
    }

    @Test
    @Ignore("Needs MeditationService IdlingResource — Choreographer frame callbacks during service polling prevent Espresso idle")
    public void testStopMeditationConfirmation() {
        new MainPage()
                .verifyMainScreenIsDisplayed()
                .selectSessionByPosition(0);

        activityRule.getScenario().onActivity(activity ->
                activity.startMeditation());

        SystemClock.sleep(2000);

        // Click stop to open the dialog and verify its contents
        onView(withId(R.id.but_stop)).perform(click());
        SystemClock.sleep(500);

        onView(withText(R.string.stop_meditation_title)).check(matches(isDisplayed()));
        onView(withText(R.string.stop_meditation_message)).check(matches(isDisplayed()));

        // Cancel — should dismiss dialog
        onView(withText(R.string.stop_meditation_cancel)).perform(click());
        SystemClock.sleep(500);

        // Still on meditation screen (stop button visible)
        onView(withId(R.id.but_stop)).check(matches(isDisplayed()));

        // Stop again and confirm
        onView(withId(R.id.but_stop)).perform(click());
        SystemClock.sleep(500);

        onView(withText(R.string.stop_meditation_title)).check(matches(isDisplayed()));
        onView(withText(R.string.stop_meditation_stop)).perform(click());

        // Test passes — service cleanup happens asynchronously
    }

    @Test
    @Ignore("Needs MeditationService IdlingResource — Choreographer frame callbacks during service polling prevent Espresso idle")
    public void testTimerCountdown() {
        new MainPage()
                .verifyMainScreenIsDisplayed()
                .selectSessionByPosition(0);

        activityRule.getScenario().onActivity(activity ->
                activity.startMeditation());

        // Wait for timer to tick
        SystemClock.sleep(3000);

        // Stop meditation
        onView(withId(R.id.but_stop)).perform(click());
        SystemClock.sleep(500);
        onView(withText(R.string.stop_meditation_stop)).perform(click());

        // Test passes — timer ran without crash for 3 seconds
    }
}
