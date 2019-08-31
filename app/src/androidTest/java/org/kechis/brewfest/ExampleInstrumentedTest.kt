package org.kechis.brewfest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.kechis.brewfest.view.MainActivity


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {

    @get:Rule
    private val activityRule = ActivityTestRule(
        MainActivity::class.java, false)

    @Before
    fun setup() {
        activityRule.launchActivity(null)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().context
        assertEquals("org.kechis.brewfest", appContext.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun testToolbarText() {
        onView(withText(R.string.app_name)).check(ViewAssertions.matches(withParent(withId(R.id.my_toolbar))))

    }

}
