package org.kechis.brewfest

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.kechis.brewfest.view.MainActivity

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityKakaoTest {

    @JvmField
    @Rule
    val testRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    val mBrewScreen = BrewScreen()


    @Test
    fun initialViewsDisplayedProperly() {
        mBrewScreen {
            fab { isDisplayed() }
            imageView {
                isDisplayed()
                hasDrawable(R.drawable.brewdog)
            }
        }
    }

}