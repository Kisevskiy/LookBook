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
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.noto.userbook.R
import com.noto.userbook.data.UserViewModel
import com.noto.userbook.databinding.FragmentUpdateBinding
import com.noto.userbook.model.User
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private var _binding:FragmentUpdateBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentUpdateBinding.inflate(inflater,container,false)
        init()
        return binding.root
    }

    private fun init() {
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding.updateAge.setText(args.custonUp.age.toString())
        binding.updateFirstName.setText(args.custonUp.firstName)
        binding.updateLastName.setText(args.custonUp.lastName)

        binding.updateButtonAdd.setOnClickListener {
            updateItem()
        }
    }

    private fun updateItem() {
        val firstName = binding.updateFirstName.text.toString()
        val lastName = binding.updateLastName.text.toString()
        val age = Integer.parseInt(binding.updateAge.text.toString())

        if(inputCheck(firstName,lastName,binding.updateAge.text)){
            val updateUser = User(args.custonUp.id,0 ,firstName,lastName)
            mUserViewModel.updateUser(updateUser)
            findNavController().navigate(R.id.listFragment)
            Toast.makeText(context,"Update Successfully",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Something Wrong",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName:String,lastName:String,age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}
