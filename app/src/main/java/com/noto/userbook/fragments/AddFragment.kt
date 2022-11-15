package com.noto.userbook.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.noto.userbook.R
import com.noto.userbook.model.User
import com.noto.userbook.data.UserViewModel
import com.noto.userbook.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private lateinit var mUserViewModel:UserViewModel
    private var _binding:FragmentAddBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater,container,false)
        init()
        return binding.root

    }
    private fun init() {
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding.buttonAdd.setOnClickListener {
            insertDataToDataBase()
        }
    }
    private fun insertDataToDataBase() {
        val age = binding.addAge.text
        val firstName = binding.addFirstName.text.toString()
        val lastName = binding.addLastName.text.toString()

        if(inputCheck(age,firstName,lastName)) {

            val user = User(0, Integer.parseInt(age.toString()), firstName, lastName)
            mUserViewModel.addUser(user)

            Toast.makeText(context, "Successfuly added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.listFragment)
        }else{
            Toast.makeText(context,"Something Wrong",Toast.LENGTH_SHORT).show()

        }
    }

    private fun inputCheck(age:Editable,firstName:String,lastName:String):Boolean{
        return  !(TextUtils.isEmpty(firstName)&&TextUtils.isEmpty(lastName)&&age.isEmpty())

    }


}