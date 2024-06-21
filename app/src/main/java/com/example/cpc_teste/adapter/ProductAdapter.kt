package com.example.cpc_teste.adapter

import Product
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cpc_teste.databinding.ProductBinding
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(
    private val context: Context,
    private val productList: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: ProductBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(product: Product){
            binding.productName.text = product.name
            val formattedPrice = formatPrice(product.price)
            binding.productPrice.text = formattedPrice
            binding.description.text = product.description
            binding.forSell.text = String.format("Disponível?: ${product.available}")

            var num = 0
            binding.productLayout.setOnClickListener {
                if (num == 0){
                    binding.moreInfoContainer.visibility = View.VISIBLE
                    num = 1
                }else {
                    binding.moreInfoContainer.visibility = View.GONE
                    num = 0
                }
            }
        }

        private fun formatPrice(price: Double): String {
            val locale = Locale("pt", "BR")
            val currencyFormatter = NumberFormat.getCurrencyInstance(locale)
            return currencyFormatter.format(price)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
