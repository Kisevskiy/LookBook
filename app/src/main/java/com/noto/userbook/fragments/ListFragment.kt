package com.noto.userbook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.noto.userbook.R
import com.noto.userbook.data.ListAdapter
import com.noto.userbook.data.UserViewModel
import com.noto.userbook.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private var _binding:FragmentListBinding? = null
    private val binding get() = _binding!!

    lateinit var mUserViewModel: UserViewModel
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater,container,false)
        init()
        return binding.root
    }

    private fun init() {
        val adapter = ListAdapter()

        recyclerView = binding.rvNotes
        recyclerView.adapter = adapter

        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {user->
            adapter.setData(user)
        })

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }
    }


}
