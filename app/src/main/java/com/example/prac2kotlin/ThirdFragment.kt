package com.example.prac2kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prac2kotlin.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    // Объявление переменной для привязки к разметке
    private var _binding: FragmentThirdBinding? = null

    // Свойство для безопасного доступа к привязке
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация привязки к разметке
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        // Возвращение корневого представления
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonBackToSecond.setOnClickListener {
            // Возврат к предыдущему фрагменту (SecondFragment)
            // путем удаления текущего фрагмента из стека возврата
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка привязки для предотвращения утечек памяти
        _binding = null
    }
}