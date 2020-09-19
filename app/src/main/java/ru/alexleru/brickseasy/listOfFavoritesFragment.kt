package ru.alexleru.brickseasy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_of_model.*
import ru.alexleru.brickseasy.ui.fragment.listOfModelFragment.ListOfModelAdapter

class listOfFavoritesFragment : Fragment(R.layout.fragment_list_of_favorites) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        APP_TOOLBAR.setTextToolbar(getString(R.string.favorites))
    }

    override fun onResume() {
        super.onResume()
        model_recycle_view.apply {
            layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = ListOfModelAdapter(true)
        }
    }}