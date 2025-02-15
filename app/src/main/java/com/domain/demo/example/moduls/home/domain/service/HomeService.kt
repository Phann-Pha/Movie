package com.domain.demo.example.moduls.home.domain.service

import com.domain.demo.example.moduls.home.domain.model.CarouselModel

interface HomeService
{
    fun onGetCarouselData(): ArrayList<CarouselModel>
}