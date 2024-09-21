package com.example.prac2kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.prac2kotlin.databinding.FragmentFirstBinding

class FirstFragment : Fragment()
{
    // Объявление переменной для привязки к разметке
    private var _binding: FragmentFirstBinding? = null

    // Свойство для безопасного доступа к привязке
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация привязки к разметке
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        // Возвращение корневого представления
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        // Установка слушателя кликов на кнопку

        binding.buttonToSecond.setOnClickListener {
            // Навигация ко второму фрагменту с использованием Navigation Component
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка привязки для предотвращения утечек памяти
        _binding = null
    }
}