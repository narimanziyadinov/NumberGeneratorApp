package com.number_generator.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.number_generator.presentation.adapters.NumberListAdapter
import com.number_generator.presentation.ui.MainViewModel
import com.numbergenerator.databinding.FibonacciFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FibonacciNumbersFragment : Fragment() {

    private var _binding: FibonacciFragmentBinding? = null
    private val binding: FibonacciFragmentBinding
        get() = _binding!!

    private var adapter: NumberListAdapter? = null

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FibonacciFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NumberListAdapter()
        binding.rvFib.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getFibNumbers().collectLatest {
                adapter?.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        adapter = null
    }
}
