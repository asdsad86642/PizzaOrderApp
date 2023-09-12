package com.example.pizzaorderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizzaorderapp.adapter.MainViewPagerAdapter
import com.example.pizzaorderapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var mvpa : MainViewPagerAdapter


    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(view)
        setupEvents()
        setValues()
    }




    override fun setupEvents() {

    }

    //버튼 클릭등의 이벤트 관련 코드 모음.

    override fun setValues() {

        mvpa = MainViewPagerAdapter(supportFragmentManager)
        binding.mainViewPager.adapter = mvpa

        binding.mainTapLayout.setupWithViewPager(binding.mainViewPager)



    }




}