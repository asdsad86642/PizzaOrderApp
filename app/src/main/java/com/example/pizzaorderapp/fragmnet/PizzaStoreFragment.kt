package com.example.pizzaorderapp.fragmnet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.adapter.PizzaStoreAdapter
import com.example.pizzaorderapp.databinding.FragmentPizzaStoreListBinding
import com.example.pizzaorderapp.datas.Store

class PizzaStoreFragment : Fragment() {

    val mPizzaStoreDataList = ArrayList<Store>()

    lateinit var mPizzaStoreAdapter: PizzaStoreAdapter
    private var _binding: FragmentPizzaStoreListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPizzaStoreListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //동작 관련 코드


        mPizzaStoreDataList.add(Store("피자스쿨","010-1456-8756","www.naver.com"))
        mPizzaStoreDataList.add(Store("파파존스","010-1456-8756","www.daum.net"))
        mPizzaStoreDataList.add(Store("김명숙피자","010-1456-8756","www.google.com"))
        mPizzaStoreDataList.add(Store("치킨나라 피자공주","010-1456-8756","www.facebook.com"))

        mPizzaStoreAdapter = PizzaStoreAdapter(requireContext(),R.layout.pizza_store_list_item,mPizzaStoreDataList)

        binding.pizzaStoreListView.adapter = mPizzaStoreAdapter


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null


    }

}