package com.example.kotlin11

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Toast
import com.example.kotlin11.databinding.ActivityMainBinding
import com.example.kotlin11.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object {
        val MESSAGE2 = "dfssfd"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClick()
    }

    private fun setClick() {
        binding.secondEdit.setText(intent.getStringExtra(EXTRA_MESSAGE))

        binding.btnSecond.setOnClickListener {
            if (binding.secondEdit.text.toString().isEmpty()) {
                Toast.makeText(this, "заполните поля!", Toast.LENGTH_SHORT).show()
            } else openActivity()
        }

    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, binding.secondEdit.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}