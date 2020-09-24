package ru.alexleru.brickseasy.ui.fragment.detailOfModelFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.R
import ru.alexleru.brickseasy.api.models.Instruction

class DetailOfModelAdapter(private val currentInstruction: Instruction) :
    RecyclerView.Adapter<DetailOfModelAdapter.VHDetails>(),
    View.OnClickListener {
    class VHDetails(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDetails = VHDetails(
        if (viewType == R.layout.btn_of_list_detail)
            LayoutInflater.from(parent.context).inflate(
                R.layout.btn_of_list_detail, parent, false
            ) else LayoutInflater.from(parent.context)
            .inflate(R.layout.item_of_list_detail, parent, false)
    )

    override fun getItemCount(): Int = currentInstruction.detailsPhotos.size + 1

    override fun onBindViewHolder(holder: VHDetails, position: Int) {
        holder.itemView.setOnClickListener(this)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == currentInstruction.detailsPhotos.size) R.layout.btn_of_list_detail
        else R.layout.item_of_list_detail
    }

    override fun onClick(p0: View?) {
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment_bottom_nav_host)
            .navigate(R.id.action_detailOfModelFragmentBottom_to_assemblyFragment)
    }
}