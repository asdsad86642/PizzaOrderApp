package com.example.pizzaorderapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pizzaorderapp.fragmnet.ChickenStoreFragment
import com.example.pizzaorderapp.fragmnet.PizzaStoreFragment

class MainViewPagerAdapter(fm : FragmentManager)  :  FragmentPagerAdapter(fm){


    override fun getCount(): Int {

        return 2

    }

    override fun getItem(position: Int): Fragment {

        return when(position) {

            0-> PizzaStoreFragment()
            else -> ChickenStoreFragment()

        }

    }
}