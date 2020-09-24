package ru.alexleru.brickseasy.ui.fragment.assemblyFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image_assembly.view.*
import ru.alexleru.brickseasy.BASE_URL_PHOTO
import ru.alexleru.brickseasy.R
import ru.alexleru.brickseasy.api.models.Instruction

class AssemblyAdapterVP(val currentInstruction: Instruction) : RecyclerView.Adapter<AssemblyAdapterVP.VHPageViewer>() {
    class VHPageViewer(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHPageViewer = VHPageViewer(
        LayoutInflater.from(parent.context).inflate(R.layout.item_image_assembly, parent, false)
    )

    override fun getItemCount(): Int = currentInstruction.assemblyPhotos.size

    override fun onBindViewHolder(holder: VHPageViewer, position: Int) {
        Picasso.get()
            .load(BASE_URL_PHOTO + currentInstruction.assemblyPhotos[position].path)
            .error(R.drawable.clock)
            .into(holder.itemView.image_assembly)
    }


}