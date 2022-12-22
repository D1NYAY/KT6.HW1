package com.example.kt6hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kt6hw1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        binding.btnEnter.setOnClickListener {
            if (binding.etInput.text.isNotEmpty()) {
                val text = binding.etInput.text.toString()
                setResult(RESULT_OK, Intent().putExtra(MainActivity.DATA, text))
                finish()
            } else {
                Toast.makeText(this, "You should write something", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getData() {
        val data = intent.getStringExtra(MainActivity.DATA)
        binding.etInput.setText(data)
    }
}