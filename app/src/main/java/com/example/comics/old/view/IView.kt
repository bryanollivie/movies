package com.example.comics.old.view

import com.example.comics.old.repository.ResultModel

interface IView {

    fun viewList(list: List<ResultModel>)

    fun refrash()

    fun error()

}