package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ru.alexleru.brickseasy.R

class LoadingFragment : Fragment(R.layout.fragment_loading) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            nextFragment(view)
        }, 1000)


    }

    private fun nextFragment(view: View) {

        Navigation.findNavController(view)
            .navigate(R.id.action_loadingFragment_to_bottomNavFragment)
    }

}

