package uz.example.retrofit2.lesson2

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.example.retrofit2.lesson1.Adapter.Adapter
import uz.example.retrofit2.databinding.ActivityMain2Binding
import uz.example.retrofit2.lesson1.SuperHerosItem

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: CurrencyAdapter
    var orginalList = emptyList<Currency>()
    var searchList = mutableListOf<Currency>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiService = ApiClent.getRetrofit().create(ApiServise::class.java)
        callToApi(apiService)
        search()
    }

    private fun search(){
        binding.search.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(belgi: CharSequence?, start: Int, before: Int, count: Int) {
                var searchText = belgi.toString().lowercase()

                var filterList = orginalList.filter { currency->
                    currency.ccy.lowercase().contains(searchText)
                }

                searchList.clear()

                searchList = filterList.toMutableList()

                adapter = CurrencyAdapter(searchList)
                binding.rec.adapter = adapter
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    private fun callToApi(apiService: ApiServise) {
        apiService.getAllCurrency().enqueue(object : Callback<List<Currency>> {
            override fun onResponse(
                call: Call<List<Currency>>,
                response: Response<List<Currency>>
            ) {
                orginalList = response.body()!!
                adapter = CurrencyAdapter(orginalList)
                binding.rec.adapter = adapter
            }

            override fun onFailure(call: Call<List<Currency>>, t: Throwable) {
                val dialog = AlertDialog.Builder(this@MainActivity3)

                dialog.setTitle("Xatolik")
                dialog.setMessage("Internetni yoq axir!")
                dialog.setNeutralButton("Takrorlash", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity3, "Bajarildi", Toast.LENGTH_SHORT).show()
                    }

                })
            }

        })
    }
}
