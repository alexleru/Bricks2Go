package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.R

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_vk.setOnClickListener { APP_ACTIVITY.vkLogin() }
        image_google.setOnClickListener { APP_ACTIVITY.googleLogin() }
        image_back.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_logginFragment_to_loggedOutFragment)
        }

    }

}