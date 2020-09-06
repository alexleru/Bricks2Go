package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_success.*
import ru.alexleru.brickseasy.R


class SuccessFragment : Fragment(R.layout.fragment_success) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_success_result.text = "Вход выполнен успешно"
        button_go_to_assembly_level.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_successFragment_to_bottomNavFragment)
        }
    }
}