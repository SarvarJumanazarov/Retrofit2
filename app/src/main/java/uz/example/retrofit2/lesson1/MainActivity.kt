package uz.example.retrofit2.lesson1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.example.retrofit2.lesson1.Adapter.Adapter
import uz.example.retrofit2.databinding.ActivityMainBinding
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rec.layoutManager = LinearLayoutManager(this)

       val apiServise= ApiClent.getRetrofit().create(ApiServise::class.java)
        apiServise.getSuperHeros().enqueue(object :Callback<List<SuperHerosItem>>{
            override fun onResponse(
                call: Call<List<SuperHerosItem>>,
                response: Response<List<SuperHerosItem>>
            ) {
                val list = response.body()

                if (list != null) {
                    adapter = Adapter(list) { pos ->
                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        val item = list[pos.toInt()]
                        intent.putExtra("id", item.id)
                        intent.putExtra("item", item as Serializable)
                        startActivity(intent)
                    }
                    binding.rec.adapter=adapter

                }else{
                    Log.d("MAINACTIVITY", "Bo'sh javob keldi")
                }
            }

            override fun onFailure(call: Call<List<SuperHerosItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}