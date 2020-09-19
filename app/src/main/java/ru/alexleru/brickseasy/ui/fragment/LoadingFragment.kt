package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.vk.api.sdk.VK
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.R

class LoadingFragment : Fragment(R.layout.fragment_loading) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            nextFragment(view)
        }, 1000)


    }

    private fun nextFragment(view: View) {
//
//        APP_ACTIVITY.googleSignInClient()?.signOut()
//        if (VK.isLoggedIn() || GoogleSignIn.getLastSignedInAccount(APP_ACTIVITY) != null)
//            Navigation.findNavController(view)
//                .navigate(R.id.action_loadingFragment_to_bottomNavFragment)
//        else
//            Navigation.findNavController(view)
//                .navigate(R.id.action_loadingFragment_to_loggedOutFragment)

        Navigation.findNavController(view)
            .navigate(R.id.action_loadingFragment_to_bottomNavFragment)
    }

}

