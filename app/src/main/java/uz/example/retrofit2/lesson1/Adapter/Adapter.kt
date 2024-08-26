package uz.example.retrofit2.lesson1.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.example.retrofit2.lesson1.SuperHerosItem
import uz.example.retrofit2.databinding.ItemLayoutBinding

class Adapter(val list: List<SuperHerosItem>,
              val onClick: (position: Long) -> Unit,
):RecyclerView.Adapter<Adapter.VH>(){

    inner class VH(private  val binding:ItemLayoutBinding,
        ):RecyclerView.ViewHolder(binding.root) {
        fun getBind(superHerosItem: SuperHerosItem) {
            Picasso.get().load(superHerosItem.imageurl).into(binding.imageSubjectImg)
            binding.subjectNameTxt.text = "${superHerosItem.name}"
            binding.subjectCountTxt.text ="${superHerosItem.firstappearance}"

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
       val binding=ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
      holder.getBind(list[position])
        holder.itemView.setOnClickListener {
            onClick.invoke(position.toLong())
        }
    }

}