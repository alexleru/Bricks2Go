package ru.alexleru.brickseasy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_of_model.*
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.APP_TOOLBAR
import ru.alexleru.brickseasy.R
import ru.alexleru.brickseasy.api.models.Instruction
import ru.alexleru.brickseasy.api.models.filterLevel
import ru.alexleru.brickseasy.ui.fragment.listOfModelFragment.ListOfModelAdapter
import ru.alexleru.brickseasy.ui.fragment.listOfModelFragment.ListOfModelFragmentDirections

class ListOfFavoritesFragment : Fragment(R.layout.fragment_list_of_favorites) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        APP_TOOLBAR.setTextToolbar(getString(R.string.favorites))
    }

    override fun onResume() {
        super.onResume()
        model_recycle_view.apply {
            layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = ListOfModelAdapter(
                APP_ACTIVITY.instructions.filterLevel(1) //TODO
            ) { instruction -> instructionItemClicked(instruction) }
        }
    }

    private fun instructionItemClicked(instruction: Instruction) {
        val action = ListOfFavoritesFragmentDirections.actionListOfFavoritesFragmentToChoiceFragment(instruction)
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment_bottom_nav_host)
            .navigate(action)
    }
}