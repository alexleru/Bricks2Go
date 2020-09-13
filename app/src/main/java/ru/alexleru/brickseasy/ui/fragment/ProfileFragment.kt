package ru.alexleru.brickseasy.ui.fragment

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import ru.alexleru.brickseasy.APP_Name
import ru.alexleru.brickseasy.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onResume() {
        super.onResume()
        text_name.text = APP_Name
    }
}