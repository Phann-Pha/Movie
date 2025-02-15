package com.domain.demo.example.moduls.home.domain.repo

import com.domain.demo.example.R
import com.domain.demo.example.moduls.home.domain.model.CarouselModel
import com.domain.demo.example.moduls.home.domain.service.HomeService

class HomeRepository : HomeService
{
    override fun onGetCarouselData(): ArrayList<CarouselModel>
    {
        return arrayListOf(
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.carousel_1),
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.carousel_2),
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.carousel_1),
        )
    }
}