package ru.alexleru.brickseasy.ui.fragment.detailOfModelFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_of_model.*
import ru.alexleru.brickseasy.APP_TOOLBAR
import ru.alexleru.brickseasy.BASE_URL_PHOTO
import ru.alexleru.brickseasy.R

class DetailOfModelFragment : Fragment(R.layout.fragment_detail_of_model) {

    val args: DetailOfModelFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        APP_TOOLBAR.setTextToolbar(getString(R.string.details))

        Picasso.get()
            .load(BASE_URL_PHOTO + args.currentInstruction.detailsPhotos[0].path)
            .error(R.drawable.clock)
            .into(image_model_detail)

        button_model_detail.setOnClickListener {
            val action =
                DetailOfModelFragmentDirections.actionDetailOfModelFragmentBottomToAssemblyFragment(
                    args.currentInstruction
                )
            Navigation.findNavController(view).navigate(action)
        }
    }

    override fun onResume() {
        super.onResume()

//        val layoutManagers = gridLayoutManager()
//        detail_recycle_view.apply {
//            layoutManager = layoutManagers
//            setHasFixedSize(true)
//            adapter = DetailOfModelAdapter(args.currentInstruction)
//        }
    }

    private fun gridLayoutManager(): GridLayoutManager {
        val layoutManagers = GridLayoutManager(context, 3)
        layoutManagers.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    in 0..args.currentInstruction.detailsPhotos.size -> 1
                    else -> 3
                }
            }
        }
        return layoutManagers
    }
}