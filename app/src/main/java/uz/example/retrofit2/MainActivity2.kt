package uz.example.retrofit2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.example.retrofit2.Adapter.Adapter
import uz.example.retrofit2.databinding.ActivityMain2Binding
import uz.example.retrofit2.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", -1)
        val item = intent.getSerializableExtra("item") as? SuperHerosItem


        // Agar item null bo'lmasa, obyektning qiymatlarini set qilish
        item?.let {

            binding.realName.text = it.realName
            binding.firstappearance.text = it.firstappearance
             binding.createdby.text = it.createdby
            binding.publisher.text = it.publisher
             binding.bio.text = it.bio
        }
    }}
