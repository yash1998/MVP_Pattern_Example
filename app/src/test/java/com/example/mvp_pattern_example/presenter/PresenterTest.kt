package com.example.mvp_pattern_example.presenter

import com.example.mvp_pattern_example.IContract
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PresenterTest {

    lateinit var presenter: Presenter

    @Mock
    lateinit var view: IContract.IView

    @Before
    fun setUp() {
        presenter = Presenter(view)
    }

    @Test
    fun testPresenter_error() {
        presenter.startLogin("", "")
        verify(view, times(1)).errorLogin()
    }

    @Test
    fun testPresenter_success() {
        presenter.startLogin("abcde", "12345")
        verify(view, times(1)).doLogin()
    }

}