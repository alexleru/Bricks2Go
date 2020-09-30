package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide.with
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_choice.*
import ru.alexleru.brickseasy.APP_TOOLBAR
import ru.alexleru.brickseasy.BASE_URL_PHOTO
import ru.alexleru.brickseasy.R
import java.lang.Exception
import com.squareup.picasso.Callback.EmptyCallback as EmptyCallback1

class ChoiceFragment : Fragment(R.layout.fragment_choice) {
    private val args: ChoiceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        APP_TOOLBAR.setTextToolbar(getString(R.string.empty_string))

        text_title_model_choice.text = args.currentInstruction.name

        Picasso.get()
            .load(BASE_URL_PHOTO + args.currentInstruction.mainPhoto.path)
            .into(image_model_choice, object : Callback{
                override fun onSuccess() {
                }

                override fun onError(e: Exception?) {
                }
            } )
        button_model_choice.setOnClickListener {
            val action =
                ChoiceFragmentDirections.actionChoiceFragmentToDetailOfModelFragmentBottom(args.currentInstruction)
            Navigation.findNavController(view)
                .navigate(action)
        }
    }
}