package com.example.pizzaorderapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.bumptech.glide.Glide
import com.example.pizzaorderapp.databinding.ActivityViewStoreDetailBinding
import com.example.pizzaorderapp.datas.Store

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData : Store

    private lateinit var binding: ActivityViewStoreDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewStoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupEvents()
        setValues()


    }




    override fun setupEvents() {

        binding.callPhoneBtn.setOnClickListener {
            val myUri = Uri.parse("tel:${mStoreData.phoneNumber}")
            val myIntent = Intent(Intent.ACTION_CALL,myUri)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

        mStoreData = intent.getSerializableExtra("storeData") as Store

        Glide.with(mContext).load(mStoreData.logoUrl).into(binding.storeLogoImg)
        binding.storePhoneNumTxt.text = mStoreData.phoneNumber
        binding.storeName.text = mStoreData.name




    }


}