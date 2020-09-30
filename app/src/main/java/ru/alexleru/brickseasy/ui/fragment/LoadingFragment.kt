package ru.alexleru.brickseasy.ui.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.R

class LoadingFragment : Fragment(R.layout.fragment_loading) {

    fun nextFragment() {
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment_host)
            .navigate(R.id.action_loadingFragment_to_bottomNavFragment)
    }

}

