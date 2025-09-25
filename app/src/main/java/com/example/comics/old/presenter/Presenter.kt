package com.example.comics.old.presenter

import com.example.comics.old.repository.DataModel
import com.example.comics.old.view.IView

class Presenter(val iview: IView) : IPresenter {

    override fun setupList(list: DataModel) {
        iview.viewList(
            list = list.results
        )
    }

    override fun error() {
        iview.error()
    }
}