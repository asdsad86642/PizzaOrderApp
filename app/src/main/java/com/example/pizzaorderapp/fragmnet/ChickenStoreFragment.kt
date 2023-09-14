package com.example.pizzaorderapp.fragmnet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.ViewStoreDetailActivity
import com.example.pizzaorderapp.adapter.ChikenStoreAdapter
import com.example.pizzaorderapp.databinding.FragmentChickenStoreListBinding
import com.example.pizzaorderapp.datas.Store

class ChickenStoreFragment : Fragment() {

    private val mChickenStoreDataList = ArrayList<Store>()

    lateinit var mChickenStoreAdapter: ChikenStoreAdapter
    private var _binding: FragmentChickenStoreListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChickenStoreListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //동작 관련 코드


        mChickenStoreDataList.add(Store("교촌 치킨","010-5423-1256","https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mChickenStoreDataList.add(Store("치킨 마루","010-7892-8456","https://cdn1.iconfinder.com/data/icons/cartoon-snack/128/pizza-128.png"))
        mChickenStoreDataList.add(Store("지영 치킨","010-4556-5756","https://cdn3.iconfinder.com/data/icons/food-set-3/91/Food_C219-128.png"))
        mChickenStoreDataList.add(Store("치킨나라 피자공주","010-2346-6556","https://cdn0.iconfinder.com/data/icons/fastfood-31/64/pizza-italian-food-fast-fastfood-cheese-piece-128.png"))

        mChickenStoreAdapter = ChikenStoreAdapter(requireContext(),R.layout.pizza_store_list_item,mChickenStoreDataList)

        binding.chikenStoreListView.adapter = mChickenStoreAdapter
        binding.chikenStoreListView.setOnItemClickListener { parent, view, position, id ->

            val clickedStore = mChickenStoreDataList[position]

            val myIntent = Intent(requireContext(),ViewStoreDetailActivity:: class.java)
            myIntent.putExtra("storeData" , clickedStore )
            startActivity(myIntent)
        }



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null


    }

}