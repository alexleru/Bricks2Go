package ru.alexleru.brickseasy.ui.fragment.assymblyFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_assembly.*
import ru.alexleru.brickseasy.R

class AssemblyFragment : Fragment(R.layout.fragment_assembly) {

    override fun onResume() {
        super.onResume()

        var adapterVP = AssemblyAdapterVP()
        var view_pager = view_pager_image
        view_pager.adapter = adapterVP

        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == 0) {
                    image_arrow_left.visibility = View.GONE
                } else {
                    image_arrow_left.visibility = View.VISIBLE
                }

                if (position == 2) {
                    text_ready.visibility = View.VISIBLE
                    image_arrow_right.visibility = View.GONE
                    text_progress.visibility = View.GONE
                    button_take_photo.visibility = View.VISIBLE
                    button_start_new_assembly.visibility = View.VISIBLE
                } else {
                    text_ready.visibility = View.GONE
                    image_arrow_right.visibility = View.VISIBLE
                    text_progress.visibility = View.VISIBLE
                    button_take_photo.visibility = View.GONE
                    button_start_new_assembly.visibility = View.GONE
                }
                text_progress.text = "${position + 1} из 3"
            }
        })


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_take_photo.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_assemblyFragment_to_savePhotoFragment)
        }

        button_start_new_assembly.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_assemblyFragment_to_levelFragmentBottom)
        }
    }
}


