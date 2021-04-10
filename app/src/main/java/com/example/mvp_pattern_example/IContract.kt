package com.example.mvp_pattern_example

interface IContract {

    interface IView {
        fun doLogin()
        fun errorLogin()
    }

    interface IPresenter {
        fun startLogin(username: String?, password: String?)
    }
}