package uz.example.retrofit2.lesson2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.example.retrofit2.databinding.ItemCurrencyBinding
import uz.example.retrofit2.databinding.ItemLayoutBinding

class CurrencyAdapter(val list: List<Currency>,

):RecyclerView.Adapter<CurrencyAdapter.VH>(){

    inner class VH(private  val binding:ItemCurrencyBinding,
        ):RecyclerView.ViewHolder(binding.root) {
        fun getBind(currency: Currency) {
          //  binding.codeTxt.text = "${currency.code}"
           // binding.ccyTxt.text = "${currency.ccy}"
        //    binding.ccyNmRuTxt.text = "${currency.ccyNmRu}"
            binding.ccyNmUzTxt.text = "${currency.ccyNmUz}"
         //   binding.ccyNmEnTxt.text = "${currency.ccyNmEn}"
            binding.nominalTxt.text = "${currency.nominal}"
            binding.rateTxt.text = "${currency.rate}"
            binding.diffTxt.text = "${currency.diff}"
            binding.dateTxt.text = "${currency.date}"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
       val binding=ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
      holder.getBind(list[position])
    }

}