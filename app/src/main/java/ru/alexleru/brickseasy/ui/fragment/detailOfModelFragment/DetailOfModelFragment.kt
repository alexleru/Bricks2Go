package ru.alexleru.brickseasy.ui.fragment.detailOfModelFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_bottom_nav.*
import kotlinx.android.synthetic.main.fragment_detail_of_model.*
import ru.alexleru.brickseasy.APP_TOOLBAR
import ru.alexleru.brickseasy.R

class DetailOfModelFragment : Fragment(R.layout.fragment_detail_of_model) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        APP_TOOLBAR.setTextToolbar(getString(R.string.details))
    }

    override fun onResume() {
        super.onResume()

        val layoutManagers = gridLayoutManager()
        detail_recycle_view.apply {
            layoutManager = layoutManagers
            setHasFixedSize(true)
            adapter = DetailOfModelAdapter()
        }
    }

    private fun gridLayoutManager(): GridLayoutManager {
        val layoutManagers = GridLayoutManager(context, 3)
        layoutManagers.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    in 0..29 -> 1
                    else -> 3
                }
            }
        }
        return layoutManagers
    }
}