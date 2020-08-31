package ru.alexleru.brickseasy.ui.fragment.assymblyFragment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_image_assembly.view.*
import ru.alexleru.brickseasy.R

class AssemblyAdapterVP : RecyclerView.Adapter<AssemblyAdapterVP.VHPageViewer>() {
    class VHPageViewer(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHPageViewer = VHPageViewer(
        LayoutInflater.from(parent.context).inflate(R.layout.item_image_assembly, parent, false)
    )

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: VHPageViewer, position: Int) {
        if(position == 0) holder.itemView.image_assembly.setImageResource(R.color.colorAccent)
        else if (position == 1) holder.itemView.image_assembly.setImageResource(R.color.design_default_color_error)
        else holder.itemView.image_assembly.setImageResource(R.color.colorPrimaryDark)
    }


}