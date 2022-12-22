package com.example.kt6hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kt6hw1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                binding.etInput.setText(it.data?.getStringExtra(DATA))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnter.setOnClickListener {
            if (binding.etInput.text.isNotEmpty()) {
                launcher.launch(Intent(this, SecondActivity::class.java).apply {
                    putExtra(
                        DATA,
                        binding.etInput.text.toString()
                    )
                })
            } else {
                Toast.makeText(this, "You should write something", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val DATA = "key"
    }
}