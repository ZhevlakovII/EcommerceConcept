package ru.izhxx.ecommerceconcept.fragments.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import ru.izhxx.ecommerceconcept.R
import ru.izhxx.ecommerceconcept.databinding.FragmentCartBinding
import ru.izhxx.ecommerceconcept.fragments.cart.adapters.PurchaseAdapter
import ru.izhxx.ecommerceconcept.fragments.cart.viewmodels.CartViewModel

class CartFragment: Fragment() {
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCartBinding.inflate(inflater, container, false)
        val purchaseAdapter = PurchaseAdapter()

        binding.cartButtonBack.setOnClickListener { backButtonClick() }
        binding.cartButtonLocation.setOnClickListener { locationButtonClick() }
        binding.cartButtonCheckout.setOnClickListener { checkoutButtonClick() }
        binding.cartRecyclerPurchase.adapter = purchaseAdapter

        return binding.root
    }

    private fun checkoutButtonClick() {
        Toast.makeText(context, getString(R.string.checkout), Toast.LENGTH_SHORT).show()
    }

    private fun locationButtonClick() {
        Toast.makeText(context, getString(R.string.location), Toast.LENGTH_SHORT).show()
    }

    private fun backButtonClick() {
        requireView().findNavController().navigateUp()
    }
}