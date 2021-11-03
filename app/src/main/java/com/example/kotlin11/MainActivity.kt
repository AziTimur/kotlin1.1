package com.example.kotlin11


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.kotlin11.databinding.ActivityMainBinding
import android.content.Intent
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstEdit.setText(intent.getStringExtra(SecondActivity.MESSAGE2))
        onClick()
    }

    fun onClick() {
        val intent = Intent(this, SecondActivity::class.java).apply {}
        binding.btnFirst.setOnClickListener() {
            when (binding.firstEdit.text.isEmpty()) {
                true -> toast("EditText не может быть пустым")
                false -> binding.btnFirst.setOnClickListener {
                    val message = binding.firstEdit.text.toString()
                    intent.putExtra(Companion.MESSAGE, binding.firstEdit.text.toString())
                    startActivity(intent)
                }
            }
        }

    }

    private fun toast(massage: String) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();
    }

    companion object {
        const val MESSAGE = "sssssd"
    }

}
