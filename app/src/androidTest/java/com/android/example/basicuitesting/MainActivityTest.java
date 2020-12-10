package com.android.example.basicuitesting;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Test
    public void testActivity_inView() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    // Visibility test
    @Test
    public void testVisibility_title_nextButton() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.activity_main_title))
                .check(matches(isDisplayed())); // method 1

        onView(withId(R.id.activity_main_title))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))); // method 2

        onView(withId(R.id.button_next_activity))
                .check(matches(isDisplayed()));
    }

    // Text
    @Test
    public void testTitleTextDisplayed() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.activity_main_title))
                .check(matches(withText(R.string.text_mainactivity)));
    }

    // test navigation in between fragments ...................

    @Test
    public void test_navSecondaryActivity() {

        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.button_next_activity)).perform(click());

        onView(withId(R.id.secondary)).check(matches(isDisplayed()));
    }

    /**
     * Test both ways to navigate from SecondaryActivity to MainActivity
     */
    @Test
    public void test_backPress_toMainActivity() {

        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.button_next_activity)).perform(click());

        onView(withId(R.id.secondary)).check(matches(isDisplayed()));

        onView(withId(R.id.button_back)).perform(click()); // method 1

        onView(withId(R.id.main)).check(matches(isDisplayed()));

        onView(withId(R.id.button_next_activity)).perform(click());

        pressBack(); // method 2

        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

}
