package com.domain.demo.example.moduls.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.demo.example.moduls.home.domain.model.CarouselModel
import com.domain.demo.example.moduls.home.domain.repo.HomeRepository

class HomeViewModel : ViewModel()
{
    private val homeRepository = HomeRepository()
    
    private val _onGetCarouselData : MutableLiveData<ArrayList<CarouselModel>> = MutableLiveData()
    val onGetCarouselModel: LiveData<ArrayList<CarouselModel>> get() = _onGetCarouselData
    
    init
    {
        onGetCarouselData()
    }
    
    private fun onGetCarouselData()
    {
        _onGetCarouselData.value = homeRepository.onGetCarouselData()
    }
}