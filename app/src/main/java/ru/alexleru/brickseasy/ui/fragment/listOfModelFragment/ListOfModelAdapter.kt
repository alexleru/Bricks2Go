package ru.alexleru.brickseasy.ui.fragment.listOfModelFragment

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_of_list_model.view.*
import ru.alexleru.brickseasy.APP_ACTIVITY
import ru.alexleru.brickseasy.BASE_URL_PHOTO
import ru.alexleru.brickseasy.R
import ru.alexleru.brickseasy.api.models.Instruction

class ListOfModelAdapter(
    private val items: List<Instruction>,
    private val clickListener: (Instruction) -> Unit
) :
    RecyclerView.Adapter<ListOfModelAdapter.VHModels>() {

    class VHModels(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(instruction: Instruction, clickListener: (Instruction) -> Unit) {
            val image = itemView.image_model

            Picasso.get()
                .load(BASE_URL_PHOTO + instruction.mainPhoto.path)
                .error(R.drawable.clock)
                .into(image)

            itemView.setOnClickListener { clickListener(instruction) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHModels = VHModels(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_of_list_model, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VHModels, position: Int) {
        holder.bind(items[position], clickListener)

        isFavorite(holder, APP_ACTIVITY.getPreference().contains(items[position].id))

        holder.itemView.image_heart.setOnClickListener {
            var status = APP_ACTIVITY.getPreference().contains(items[position].id)
            isFavorite(holder, !status)
            if (status) APP_ACTIVITY.deletePreference(items[position].id)
            else APP_ACTIVITY.setPreference(items[position].id)
        }

    }

    private fun isFavorite(holder: VHModels, status: Boolean) {
        val imageHeartDrawable = holder.itemView.image_heart.drawable.mutate()
        if (status) setColor(imageHeartDrawable, R.color.colorPrimary)
        else setColor(imageHeartDrawable, R.color.colorPrimary40)
    }

    private fun setColor(imageHeartDrawable: Drawable, color: Int) {
        imageHeartDrawable.setColorFilter(
            ContextCompat.getColor(APP_ACTIVITY.applicationContext, color),
            PorterDuff.Mode.MULTIPLY
        )
    }

}