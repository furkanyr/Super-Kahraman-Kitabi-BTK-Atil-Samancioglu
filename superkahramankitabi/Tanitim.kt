package com.yerinde.superkahramankitabi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yerinde.superkahramankitabi.databinding.ActivityMainBinding
import com.yerinde.superkahramankitabi.databinding.ActivityTanitimBinding

class Tanitim : AppCompatActivity() {
    private lateinit var binding: ActivityTanitimBinding

    @SuppressLint("NewApi", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitimBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val secilenKahraman = intent.getSerializableExtra("Hero", SuperKahraman::class.java)
        //val secilenKahraman = intent.getSerializableExtra("Hero") as SuperKahraman

        binding.imageView.setImageResource(secilenKahraman!!.image)
        binding.textView2.setText(secilenKahraman.name)
        binding.textView3.setText(secilenKahraman.age)
        binding.textView4.setText(secilenKahraman.job)

    }
}