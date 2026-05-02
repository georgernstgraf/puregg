package de.gaffga.android.zazentimer.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;

import de.gaffga.android.zazentimer.R;

public class SettingsPage extends BasePage {

    public SettingsPage() {
        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}
    }

    private void scrollToPreference(int textResId) {
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                onView(withText(textResId)).perform(scrollTo());
                onView(withText(textResId)).check(matches(isDisplayed()));
                return;
            } catch (Exception e) {
                SystemClock.sleep(500);
            }
        }
    }

    public SettingsPage clickBackup() {
        scrollToPreference(R.string.pref_title_backup);
        onView(withText(R.string.pref_title_backup)).perform(click());
        return this;
    }

    public SettingsPage clickRestoreAndConfirm() {
        scrollToPreference(R.string.pref_title_restore);
        onView(withText(R.string.pref_title_restore)).perform(click());
        SystemClock.sleep(300);
        onView(withText(R.string.ok)).perform(click());
        return this;
    }

    public MainPage goBack() {
        pressBack();
        return new MainPage();
    }
}
