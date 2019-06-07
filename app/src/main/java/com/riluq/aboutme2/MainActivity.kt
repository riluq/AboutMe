package com.riluq.aboutme2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.riluq.aboutme.utils.gone
import com.riluq.aboutme.utils.visible
import com.riluq.aboutme2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var myName: MyName = MyName("Muhammad Alif Rizqi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.btnDone.setOnClickListener {
            addNickname(it)
        }
    }
    private fun addNickname(view: View) {
        binding.apply {
//            tvNickname.text = binding.edtNickname.text.trim()
            myName?.nickname = edtNickname.text.toString()
            invalidateAll()
            binding.edtNickname.visibility = gone()
            view.visibility = gone()
            binding.tvNickname.visibility = visible()
        }

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
