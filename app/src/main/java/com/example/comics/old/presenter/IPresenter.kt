package com.example.comics.old.presenter

import com.example.comics.old.repository.DataModel

interface IPresenter {

    fun setupList(list: DataModel)

    fun error()
}