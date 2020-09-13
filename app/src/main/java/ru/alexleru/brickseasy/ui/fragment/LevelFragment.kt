package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_bottom_nav.*
import kotlinx.android.synthetic.main.fragment_level.*
import ru.alexleru.brickseasy.R

class LevelFragment : Fragment(R.layout.fragment_level) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        image_level1.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_levelFragmentBottom_to_listOfModelFragment)
        }
    }
}