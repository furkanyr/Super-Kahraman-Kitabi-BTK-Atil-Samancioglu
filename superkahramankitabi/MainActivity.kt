package com.yerinde.superkahramankitabi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.yerinde.superkahramankitabi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var superHeroList: ArrayList<SuperKahraman>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val superman = SuperKahraman("Superman", "25", "Boss", R.drawable.superman)
        val batman = SuperKahraman("Batman", "32", "Bakery", R.drawable.batman)
        val hulk = SuperKahraman("Hulk", "41", "Fighter", R.drawable.hulk)
        val ironman = SuperKahraman("İron Man", "28", "Butcher",R.drawable.ironman)

        superHeroList = arrayListOf(superman, batman, hulk, ironman)

        val adapter = SuperKahramanAdapter(superHeroList)
        binding.superKRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.superKRecyclerView.adapter = adapter
    }
}