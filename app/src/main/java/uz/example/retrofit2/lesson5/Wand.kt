package uz.example.retrofit2.lesson5

import com.google.gson.annotations.SerializedName

data class Wand(

	@field:SerializedName("core")
	val core: String? = null,

	@field:SerializedName("length")
	val length: Int? = null,

	@field:SerializedName("wood")
	val wood: String? = null
)