package com.example.prac2kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.prac2kotlin.databinding.FragmentSecondBinding

class SecondFragment : Fragment()
{
    // Объявление переменной для привязки к разметке
    private var _binding: FragmentSecondBinding? = null

    // Свойство для безопасного доступа к привязке
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация привязки к разметке
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        // Возвращение корневого представления
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка слушателя кликов на кнопку перехода к третьему фрагменту
        binding.buttonToThird.setOnClickListener {
            // Создание экземпляра третьего фрагмента
            val thirdFragment = ThirdFragment()

            // Ручная навигация к третьему фрагменту
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, thirdFragment)
                .addToBackStack(null) // Добавление транзакции в стек возврата
                .commit()
        }

        // Установка слушателя кликов на кнопку возврата к первому фрагменту
        binding.buttonBackToFirst.setOnClickListener {
            // Возврат к предыдущему фрагменту с использованием Navigation Component
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка привязки для предотвращения утечек памяти
        _binding = null
    }
}