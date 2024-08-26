package uz.example.retrofit2.lesson2

import com.google.gson.annotations.SerializedName

data class Currency(
    val id: Int,
    @SerializedName(value = "Code")
    val code: String,
    @SerializedName(value = "Ccy")
    val ccy: String,
    @SerializedName(value = "CcyNm_RU")
    val ccyNmRu: String,
    @SerializedName(value = "CcyNm_UZ")
    val ccyNmUz: String,

    @SerializedName(value = "CcyNm_UZC")
    val ccyNmUzc: String,

    @SerializedName(value = "CcyNm_EN")
    val ccyNmEn: String,

    @SerializedName(value = "Nominal")
    val nominal: String,


    @SerializedName(value = "Rate")
    val rate: String,

    @SerializedName(value = "Diff")
    val diff: String,

    @SerializedName(value = "Date")
    val date: String,

    ) {
}
