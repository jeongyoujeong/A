package com.example.study1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.study1.R
import com.example.study1.databinding.FragmentTalkBinding
import com.example.study1.databinding.FragmentTipBinding

class TalkFragment : Fragment() {

    private lateinit var binding : FragmentTalkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk, container, false)

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }

        binding.bookMarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_bookFragment)
        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }

        return binding.root
    }
}