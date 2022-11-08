package ru.izhxx.ecommerceconcept.fragments.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.izhxx.ecommerceconcept.databinding.FragmentCartBinding

class CartFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCartBinding.inflate(inflater, container, false)


        return binding.root
    }
}