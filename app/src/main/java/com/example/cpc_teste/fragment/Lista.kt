package com.example.cpc_teste.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cpc_teste.GlobalList
import com.example.cpc_teste.adapter.ProductAdapter
import com.example.cpc_teste.databinding.FragmentListaBinding

class Lista : Fragment() {
    private lateinit var binding: FragmentListaBinding
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configRv()
    }

    override fun onResume() {
        super.onResume()
        configRv()
    }

    private fun configRv() {
        val productList = GlobalList.getList().sortedBy { it.price }
        productAdapter = ProductAdapter(requireContext(), productList)

        binding.rv.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}

