package com.android.example.basicuitesting;

import androidx.lifecycle.Lifecycle;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class SecondActivityTest {

    /**
     * ActivityScenarioRule:
     * https://developer.android.com/reference/androidx/test/ext/junit/rules/ActivityScenarioRule.html
     */

    @Rule
    public ActivityScenarioRule activityRule = new ActivityScenarioRule(SecondActivity.class);

    @Test
    public void testActivity_inView() {

        onView(withId(R.id.secondary))
                .check(matches(isDisplayed()));

        // Notice this does not effect the next test
        activityRule.getScenario().moveToState(Lifecycle.State.DESTROYED);
    }

    // Visibility
    @Test
    public void testVisibility_title_nextButton() {
        onView(withId(R.id.activity_secondary_title))
                .check(matches(isDisplayed()));

        onView(withId(R.id.button_back))
                .check(matches(isDisplayed()));
    }

    // Text
    @Test
    public void testTitleTextDisplayed() {
        onView(withId(R.id.activity_secondary_title))
                .check(matches(withText(R.string.text_secondaryactivity)));
    }

}
