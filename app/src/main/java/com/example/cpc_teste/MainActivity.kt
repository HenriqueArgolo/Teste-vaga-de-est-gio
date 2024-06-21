package com.example.cpc_teste

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cpc_teste.fragment.CadastrarProdutos
import com.example.cpc_teste.fragment.Lista
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    val cadastrar = CadastrarProdutos()
    lateinit var menu: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        menu = findViewById(R.id.bottomAppBar)
        options()
        bottomBarNavigation(cadastrar)

    }

    fun options() {
        menu.setOnItemSelectedListener { item ->
            when (item.itemId) {

               R.id.cadastrar -> {
                   bottomBarNavigation(cadastrar)
                   true
               }R.id.lista ->{
                val lista = Lista()
                bottomBarNavigation(lista)
                true
               }
                else -> false

            }
        }
    }

    private fun bottomBarNavigation(fragment: Fragment) {
        val navigation = supportFragmentManager.beginTransaction()
        navigation.replace(R.id.container_main, fragment)
        navigation.commit()

    }
}