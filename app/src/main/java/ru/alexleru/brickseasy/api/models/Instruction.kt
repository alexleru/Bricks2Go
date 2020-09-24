package ru.alexleru.brickseasy.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.collections.ArrayList

@Parcelize
data class Instruction(
    val name: String,
    val difficulty: Int,
    val id: UUID,
    @SerializedName("main_photo")
    val mainPhoto: Photo,
    @SerializedName("details_photos")
    val detailsPhotos: ArrayList<Photo>,
    @SerializedName("assembly_photos")
    val assemblyPhotos: ArrayList<Photo>
) : Parcelable

@Parcelize
data class Photo(
    @SerializedName("instruction_id")
    val instructionId: UUID,
    val path: String,
    val id: UUID,
    val description: String? = null
) : Parcelable

fun List<Instruction>.filterLevel(level: Int) = this.filter { it.difficulty == level }
fun List<Instruction>.filterByID(ids: ArrayList<UUID>) = this.filter{it.id in ids}

