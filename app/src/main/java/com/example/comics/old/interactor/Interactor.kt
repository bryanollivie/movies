package com.example.comics.old.interactor

import com.example.comics.old.presenter.IPresenter
import com.example.comics.old.repository.Repository

class Interactor(
    val iPresenter: IPresenter,
    val repository: Repository = Repository()
) : IInteractor {

    override suspend fun getMovies() {
        try {
            iPresenter.setupList(repository.getMovies())
        } catch (e: Exception) {
            e.printStackTrace()
            iPresenter.error()
        }
    }

}