package com.example.kotlin11


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.kotlin11.databinding.ActivityMainBinding
import android.content.Intent
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstEdit.setText(intent.getStringExtra(SecondActivity.MESSAGE2))
        registerForActivity()
        onClick()
    }

    fun onClick() {
        binding.btnFirst.setOnClickListener {
            if (binding.firstEdit.text.toString().isEmpty()) {
                Toast.makeText(this, getString(R.string.style_edit), Toast.LENGTH_SHORT).show()
            } else openActivity()
        }
    }
    private fun registerForActivity(){
        resultLauncher=
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result: ActivityResult->
                if (result.resultCode==Activity.RESULT_OK){
                    binding.firstEdit.setText(result.data?.getStringExtra(EXTRA_MESSAGE))
                }
            }
    }

    private fun openActivity(){
        Intent(this,SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE,binding.firstEdit.text.toString())
            resultLauncher.launch(this)

        }
    }



}
