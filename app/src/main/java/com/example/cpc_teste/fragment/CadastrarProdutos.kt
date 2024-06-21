package com.example.cpc_teste.fragment

import Product
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cpc_teste.GlobalList
import com.example.cpc_teste.MainActivity
import com.example.cpc_teste.R
import com.example.cpc_teste.databinding.FragmentCadastrarProdutosBinding

class CadastrarProdutos : Fragment() {
    lateinit var binding: FragmentCadastrarProdutosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCadastrarProdutosBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lista = Lista()
        binding.saveButto.setOnClickListener {
            createProdut()
            (activity as MainActivity).menu.selectedItemId = R.id.lista
            bottomBarNavigation(lista)
        }
    }


    private fun createProdut() {
        val price = binding.productPrice.text.toString()
        val product = Product(
            binding.productName.text.toString(),
            binding.productDescription.text.toString(),
            price.toDouble(),
            binding.forSell.selectedItem.toString()

        )

        if (product.name.isNotBlank() && product.price > 0 )  {
            GlobalList.saveProduct(product)
            Toast.makeText(requireContext(), "Produto cadastrado com sucesso.", Toast.LENGTH_LONG)
                .show()

        } else {
            Toast.makeText(requireContext(), "Preencha os dados corretamente.", Toast.LENGTH_LONG)
                .show()
        }
    }
    private fun bottomBarNavigation(fragment: Fragment) {
        val navigation = requireActivity().supportFragmentManager.beginTransaction()
        navigation.replace(R.id.container_main, fragment)
        navigation.commit()

    }

}
