package com.example.pizzaorderapp.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.datas.Store

class ChikenStoreAdapter(val mContext : Context,
                         val resId : Int,
                         val mList : List<Store>): ArrayAdapter<Store>(mContext,resId,mList) {

    private  val inflater = LayoutInflater.from(mContext)

    private  class ViewHolder(row:View?) {
        val storeNameTxt : TextView = row?.findViewById(R.id.storeNameTxt) ?: throw NullPointerException("No view with specified ID found.")
        val logoImg: ImageView = row?.findViewById(R.id.logoImg)
            ?: throw NullPointerException("No view with specified ID found.")
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder:ViewHolder
        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.pizza_store_list_item,parent,false)
            viewHolder = ViewHolder(tempRow)
            tempRow.tag = viewHolder
        }
        else{
            viewHolder=tempRow.tag as ViewHolder
        }

        val data = mList[position]

        Glide.with(mContext).load(data.logoUrl).into(viewHolder.logoImg)
        viewHolder.storeNameTxt.text = data.name

        return tempRow!!
    }
}