package uz.example.retrofit2

import java.io.Serializable

class SuperHerosItem(  val name:String,
                       val realName:String,
                       val team:String,
                       val firstappearance:String,
                       val createdby:String,
                       val publisher:String,
                       val imageurl:String,
                       val bio:String,
                        val id: Int): Serializable {
}