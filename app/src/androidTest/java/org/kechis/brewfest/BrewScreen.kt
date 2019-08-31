package org.kechis.brewfest

import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton

class BrewScreen: Screen<BrewScreen>() {

    val imageView: KImageView =
        KImageView { withId(R.id.logo) }

    val fab: KButton =
        KButton { withId(R.id.queryFAB) }

}
