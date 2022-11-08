package ru.izhxx.ecommerceconcept.fragments.explorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.izhxx.ecommerceconcept.databinding.FragmentExplorerBinding

class ExplorerFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExplorerBinding.inflate(inflater, container, false)


        return binding.root
    }
}