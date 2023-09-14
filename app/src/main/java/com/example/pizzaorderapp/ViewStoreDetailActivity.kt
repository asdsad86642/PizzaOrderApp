package com.example.pizzaorderapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pizzaorderapp.databinding.ActivityViewStoreDetailBinding
import com.example.pizzaorderapp.datas.Store
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import android.Manifest

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData: Store
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
            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${mStoreData.phoneNumber}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화 연결 권한이 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.create() // 변경된 부분
                .setPermissionListener(permissionListener)
                .setDeniedMessage("[설정] 에서 전화 권한을 켜주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }

    override fun setValues() {
        mStoreData = intent.getSerializableExtra("storeData") as Store
        Glide.with(this).load(mStoreData.logoUrl).into(binding.storeLogoImg)
        binding.storePhoneNumTxt.text = mStoreData.phoneNumber
        binding.storeName.text = mStoreData.name
    }
}
