package com.example.cpc_teste

import Product

class GlobalList {
    companion object {
       private var listaDeProdutos: MutableList<Product> = mutableListOf()


        fun saveProduct(product: Product) {
            listaDeProdutos.add(product)
        }

        fun getList(): MutableList<Product> {
            return listaDeProdutos
        }

    }
}