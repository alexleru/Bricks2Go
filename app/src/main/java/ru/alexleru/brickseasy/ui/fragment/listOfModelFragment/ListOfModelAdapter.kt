package ru.alexleru.brickseasy.ui.fragment.listOfModelFragment

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.R

class ListOfModelAdapter : RecyclerView.Adapter<ListOfModelAdapter.VHModels>(), OnClickListener {

    class VHModels(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHModels = VHModels(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_of_list_model, parent, false)
    )

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: VHModels, position: Int) {
        holder.itemView.tag = position
        holder.itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment_bottom_nav_host)
            .navigate(R.id.action_listOfModelFragment_to_choiceFragment)
    }
}