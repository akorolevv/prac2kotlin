package com.example.prac2kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.prac2kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    // Объявление переменной для привязки к разметке
    private lateinit var binding: ActivityMainBinding

    // Объявление переменной для контроллера навигации
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Инициализация привязки к разметке
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Установка корневого представления в качестве содержимого активности
        setContentView(binding.root)

        // Получение NavHostFragment из FragmentContainerView
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Получение NavController из NavHostFragment
        navController = navHostFragment.navController

        // NavHostFragment - это специальный фрагмент, который служит контейнером для других фрагментов и управляет их заменой при навигации.
        // NavController - это объект, который управляет навигацией в приложении с использованием Navigation Component.

        // Он отвечает за переключение между различными фрагментами или активностями в соответствии с определенными правилами навигации.
    }
}