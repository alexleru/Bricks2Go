package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_registration.*
import ru.alexleru.brickseasy.R


class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_back.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_registrationFragment_to_loggedOutFragment)
        }
    }
}