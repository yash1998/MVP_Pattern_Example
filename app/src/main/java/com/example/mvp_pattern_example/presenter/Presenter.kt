package com.example.mvp_pattern_example.presenter

import com.example.mvp_pattern_example.IContract
import com.example.mvp_pattern_example.model.LoginDataModel

class Presenter(val view: IContract.IView?) : IContract.IPresenter {

    private val loginModel by lazy { LoginDataModel() }

    override fun startLogin(username: String?, password: String?) {
        val result = loginModel.validateLoginDetails(username, password)
        if (result) {
            view?.doLogin()
        } else {
            view?.errorLogin()
        }
    }
}