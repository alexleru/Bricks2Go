package ru.alexleru.brickseasy.ui.fragment.listOfModelFragment

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_of_model.*
import ru.alexleru.brickseasy.R

class ListOfModelFragment : Fragment(R.layout.fragment_list_of_model) {

    override fun onResume() {
        super.onResume()

        model_recycle_view.apply {
            layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = ListOfModelAdapter()
        }
    }
}