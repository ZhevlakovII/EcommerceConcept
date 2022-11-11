package ru.izhxx.ecommerceconcept.fragments.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.izhxx.ecommerceconcept.R
import ru.izhxx.ecommerceconcept.activities.MainActivity
import ru.izhxx.ecommerceconcept.databinding.FragmentCartBinding
import ru.izhxx.ecommerceconcept.fragments.cart.CartViewModel.Companion.fakeUserId
import ru.izhxx.ecommerceconcept.fragments.cart.adapters.PurchaseAdapter

class CartFragment: Fragment() {
    private val cartViewModel by viewModel<CartViewModel>()

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val purchaseAdapter = PurchaseAdapter(
        onAddClick = { cartViewModel.addProduct(position = it) },
        onDeleteClick = { cartViewModel.deleteProduct(position = it) },
        onRemoveClick = { cartViewModel.removeProduct(position = it) }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        cartViewModel.loadingData(fakeUserId)

        binding.cartButtonBack.setOnClickListener { backButtonClick() }
        binding.cartButtonLocation.setOnClickListener { locationButtonClick() }
        binding.cartButtonCheckout.setOnClickListener { checkoutButtonClick() }
        binding.cartRecyclerPurchase.adapter = purchaseAdapter

        observeData()
        observeError()
        observeLoading()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkoutButtonClick() {
        Toast.makeText(context, getString(R.string.checkout), Toast.LENGTH_SHORT).show()
    }

    private fun locationButtonClick() {
        Toast.makeText(context, getString(R.string.location), Toast.LENGTH_SHORT).show()
    }

    private fun backButtonClick() {
        requireView().findNavController().navigate(R.id.explorer_fragment)
    }

    private fun observeData() {
        cartViewModel.data.observe(viewLifecycleOwner) { cartData ->
            if (cartData != null) {
                purchaseAdapter.submitList(cartData.products)
                binding.cartTextDeliveryPrice.text = cartData.deliveryCost
                binding.cartTextTotalPrice.text = buildString {
                    append("$")
                    append(cartData.totalCost)
                }

                var productCount = 0
                cartData.products.forEach { productCount += it.count }
                (requireActivity() as MainActivity).changeCartProducts(productCount)
            }
        }
    }

    private fun observeError() {
        cartViewModel.error.observe(viewLifecycleOwner) {
            if (it != null)
                Toast.makeText(context, "$it!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeLoading() {
        cartViewModel.loading.observe(viewLifecycleOwner) {
            if (it) Toast.makeText(context, "Loading...", Toast.LENGTH_LONG).show()
        }
    }
}