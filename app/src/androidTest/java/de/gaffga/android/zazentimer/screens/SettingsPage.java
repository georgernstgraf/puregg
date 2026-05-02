package de.gaffga.android.zazentimer.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewParent;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.util.HumanReadables;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import de.gaffga.android.zazentimer.R;

public class SettingsPage extends BasePage {

    public SettingsPage() {
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        try {
            onView(withText(R.string.pref_title_backup)).perform(scrollTo());
        } catch (Exception e) {
            scrollPreferencesToBottom();
        }
    }

    private void scrollPreferencesToBottom() {
        try {
            onView(isRecyclerView()).perform(RecyclerViewActions.scrollToPosition(99));
            SystemClock.sleep(500);
        } catch (Exception ignored) {}
    }

    private static Matcher<View> isRecyclerView() {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View view) {
                return view instanceof RecyclerView;
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("is a RecyclerView");
            }
        };
    }

    public SettingsPage clickBackup() {
        scrollPreferencesToBottom();
        onView(withText(R.string.pref_title_backup)).perform(click());
        return this;
    }

    public SettingsPage clickRestoreAndConfirm() {
        scrollPreferencesToBottom();
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
