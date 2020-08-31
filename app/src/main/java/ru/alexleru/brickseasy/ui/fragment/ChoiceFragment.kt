package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choice.*
import ru.alexleru.brickseasy.R

class ChoiceFragment : Fragment(R.layout.fragment_choice) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_model_choice.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_choiceFragment_to_detailOfModelFragmentBottom)
        }
    }
}