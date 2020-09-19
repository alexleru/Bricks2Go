package ru.alexleru.brickseasy.ui.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_bottom_nav.*
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.APP_TOOLBAR
import ru.alexleru.brickseasy.R

class BottomNavFragment : Fragment(R.layout.fragment_bottom_nav) {

    override fun onResume() {
        super.onResume()
        APP_TOOLBAR = this
        val navController =
            Navigation.findNavController(APP_ACTIVITY, R.id.fragment_bottom_nav_host)
        bottom_navigation.setupWithNavController(navController)
    }

    fun setTextToolbar(text: String) {
        text_toolbar_title.text = text
    }
}