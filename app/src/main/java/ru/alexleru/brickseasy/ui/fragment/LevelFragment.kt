package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_level.*
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.APP_TOOLBAR
import ru.alexleru.brickseasy.R

class LevelFragment : Fragment(R.layout.fragment_level), View.OnClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        card_level_1.setOnClickListener(this)
        card_level_2.setOnClickListener(this)
        card_level_3.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        APP_TOOLBAR.setTextToolbar(getString(R.string.choose_level))
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.card_level_1 -> nextFragment(1)
            R.id.card_level_2 -> nextFragment(2)
            R.id.card_level_3 -> nextFragment(3)
        }
    }

    private fun nextFragment(level: Int) {
        val action = LevelFragmentDirections.actionLevelFragmentBottomToListOfModelFragment(level)
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment_bottom_nav_host)
            .navigate(action)
    }
}