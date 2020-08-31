package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_logged_out.view.*
import ru.alexleru.brickseasy.R

class LoggedOutFragment : Fragment(R.layout.fragment_logged_out) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.without_registration.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_loggedOutFragment_to_bottomNavFragment)
        }
        view.login.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_loggedOutFragment_to_logginFragment)
        }

        view.registration.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_loggedOutFragment_to_registrationFragment)
        }
    }
}