package uz.example.retrofit2.lesson2

import android.content.DialogInterface
import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiService = ApiClent.getRetrofit().create(ApiServise::class.java)

        apiService.getAllCurrency().enqueue(object : Callback<List<Currency>> {
            override fun onResponse(
                call: Call<List<Currency>>,
                response: Response<List<Currency>>
            ) {
                adapter = CurrencyAdapter(response.body()!!)
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
