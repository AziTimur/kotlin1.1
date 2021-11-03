package com.example.kotlin11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding.secondEdit.setText(intent.getStringExtra(MainActivity.MESSAGE))
        setClick()
    }

    private fun setClick() {
        val intent = Intent(this, SecondActivity::class.java).apply {}
        binding.btnSecond.setOnClickListener() {
            when (binding.secondEdit.text.isEmpty()) {
                true -> toast("EditText не может быть пустым")
                false -> binding.btnSecond.setOnClickListener {
                    val message = binding.secondEdit.text.toString()
                    intent.putExtra(MainActivity.MESSAGE, binding.secondEdit.text.toString())
                    startActivity(intent)
                }
            }

        }

    }

    private fun toast(massage: String) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();
    }
}