package com.example.conduit.ui.feed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.conduit.R
import com.example.conduit.databinding.FragmentGlobalFeedBinding

class GlobalFeedFragment : Fragment() {

    private var _binding:FragmentGlobalFeedBinding?= null
    private lateinit var viewMode:FeedViewModel
    private lateinit var feedAdapter: ArticleFeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewMode = ViewModelProvider(this).get(FeedViewModel::class.java)
        _binding = FragmentGlobalFeedBinding.inflate(inflater,container,false)
        feedAdapter = ArticleFeedAdapter()
        _binding?.feedRecylerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = feedAdapter
        }

        viewMode.getGolobalFeed()
        viewMode.feed.observe(viewLifecycleOwner, Observer {
            feedAdapter.submitList(it)
        })

        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}