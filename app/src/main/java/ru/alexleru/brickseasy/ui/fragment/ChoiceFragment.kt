package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_choice.*
import ru.alexleru.brickseasy.R
import ru.alexleru.brickseasy.ui.fragment.listOfModelFragment.ListOfModelFragmentArgs

class ChoiceFragment : Fragment(R.layout.fragment_choice) {
    private val args: ChoiceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_title_model_choice.text = args.currentInstruction.name

        Picasso.get()
            .load(args.currentInstruction.mainPhoto.path)
            .error(R.drawable.clock)
            .into(image_model_choice)

        val action =
        button_model_choice.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_choiceFragment_to_detailOfModelFragmentBottom)
        }
    }
}