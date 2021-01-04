package com.example.conduit.ui.feed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.conduit.R
import com.example.conduit.databinding.FragmentGalleryBinding

class GlobalFeedFragment : Fragment() {

    private var _binding:FragmentGalleryBinding?= null
    private lateinit var viewMode:FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewMode = ViewModelProvider(this).get(FeedViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_global_feed,container,false)
        _binding = FragmentGalleryBinding.inflate(inflater,container,false)
        Log.d("frag","open")
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}