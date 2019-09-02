package org.kechis.brewfest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.StringContains.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.kechis.brewfest.view.MainActivity

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityEspressoTest {

    @JvmField
    @Rule
    val testRule = ActivityTestRule<MainActivity>(MainActivity::class.java)


    @Test
    fun textShouldBeUpdateAndImageDisplayedOnButtonClick() {
        onView(withId(R.id.queryFAB)).perform(click())
        onView(withId(R.id.food)).check(matches(isDisplayed()))
        onView(withId(R.id.title))
            .check(matches(withText(containsString("What are you eating today?"))))
    }
}
