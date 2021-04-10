package com.example.mvp_pattern_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mvp_pattern_example.databinding.ActivityMainBinding
import com.example.mvp_pattern_example.presenter.Presenter

class MainActivity : AppCompatActivity(), IContract.IView {

    var binding: ActivityMainBinding? = null
    val presenter: IContract.IPresenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setEventListeners()
    }

    override fun doLogin() {
        binding?.textLoginStatus?.text = "Login Success"
        binding?.textLoginStatus?.setTextColor(ContextCompat.getColor(this, R.color.green))
    }

    override fun errorLogin() {
        binding?.textLoginStatus?.text = "Login Error"
        binding?.textLoginStatus?.setTextColor(ContextCompat.getColor(this, R.color.red))
    }

    fun setEventListeners() {
        binding?.buttonLogin?.setOnClickListener {
            presenter.startLogin(
                binding?.editTextUsername?.text?.toString(),
                binding?.editTextPassword?.text?.toString()
            )
        }
    }
}
