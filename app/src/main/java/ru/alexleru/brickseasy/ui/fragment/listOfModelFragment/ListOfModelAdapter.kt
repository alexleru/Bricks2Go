package ru.alexleru.brickseasy.ui.fragment.listOfModelFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_of_list_model.view.*
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.R
import ru.alexleru.brickseasy.api.models.Instruction

class ListOfModelAdapter(private val items: List<Instruction>, private val clickListener: (Instruction) -> Unit ) :
    RecyclerView.Adapter<ListOfModelAdapter.VHModels>() {

    class VHModels(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(instruction: Instruction, clickListener: (Instruction) -> Unit){
            val image = itemView.image_model
            Picasso.get()
                .load(instruction.mainPhoto.path)
                .error(R.drawable.clock)
                .into(image)
            itemView.setOnClickListener{clickListener(instruction)}
            itemView.image_heart.setOnClickListener{ TODO()}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHModels = VHModels(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_of_list_model, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VHModels, position: Int) {
        holder.bind(items[position], clickListener)
    }

    private fun nextFragment() {
            Navigation.findNavController(APP_ACTIVITY, R.id.fragment_bottom_nav_host)
                .navigate(R.id.action_listOfFavoritesFragment_to_choiceFragment)
    }
}