package de.gaffga.android.zazentimer;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import de.gaffga.android.zazentimer.screens.MainPage;

@HiltAndroidTest
@RunWith(AndroidJUnit4.class)
@LargeTest
public class BackupRestoreTest {

    @Rule
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Rule
    public ActivityScenarioRule<ZazenTimerActivity> activityRule =
            new ActivityScenarioRule<>(ZazenTimerActivity.class);

    @Test
    public void activityLaunchesSuccessfully() {
        MainPage mainPage = new MainPage();
        mainPage.verifyMainScreenIsDisplayed();
    }
    
    @Test
    public void testFreshAppLaunch() {
        MainPage mainPage = new MainPage();
        mainPage.verifyMainScreenIsDisplayed();
        mainPage.verifyDefaultSessionsAreVisible();
    }
}
