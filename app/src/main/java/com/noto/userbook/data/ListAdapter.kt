package com.noto.userbook.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.noto.userbook.R
import com.noto.userbook.fragments.ListFragmentDirections
import com.noto.userbook.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.item_id.text = currentItem.id.toString()
        holder.itemView.age.text = currentItem.age.toString()
        holder.itemView.first_name.text = currentItem.firstName

        holder.itemView.last_name.text = currentItem.lastName

        holder.itemView.item_lay.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment2(currentItem)
            holder.itemView.findNavController().navigate(action)

            }
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    fun setData(user:List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}