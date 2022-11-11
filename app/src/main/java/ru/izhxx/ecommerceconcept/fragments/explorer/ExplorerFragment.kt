package ru.izhxx.ecommerceconcept.fragments.explorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.izhxx.domain.impl.entities.delegate.data.CategoryDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.HotDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.SearchDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.SellerDelegateImpl
import ru.izhxx.ecommerceconcept.R
import ru.izhxx.ecommerceconcept.activities.MainActivity
import ru.izhxx.ecommerceconcept.model.categories.Category
import ru.izhxx.ecommerceconcept.databinding.FragmentExplorerBinding
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.ExplorerAdapter

class ExplorerFragment: Fragment() {
    private val explorerViewModel by viewModel<ExplorerViewModel>()

    private var _binding: FragmentExplorerBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy {
        ExplorerAdapter(
            onCategoryClick = { explorerViewModel.changeCategory(it) },
            onSellerFavoriteClick = { explorerViewModel.setFavorite(it) },
            onSellerItemClick = { onSellerItemClick(it) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExplorerBinding.inflate(inflater, container, false)

        binding.explorerButtonAccept.setOnClickListener { acceptButtonClick() }
        binding.explorerButtonCancel.setOnClickListener { cancelButtonClick() }
        binding.explorerButtonFilter.setOnClickListener { filterButtonClick() }
        binding.explorerButtonCityPicker.setOnClickListener { cityPickerButtonClick() }
        binding.explorerRecycler.adapter = adapter
        binding.explorerRecycler.itemAnimator = null

        explorerViewModel.loadingData()

        setFilters()
        observeData()
        observeError()
        observeLoading()

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onSellerItemClick(position: Int) {
        requireView().findNavController().navigate(R.id.details_fragment)
    }

    private fun setFilters() {
        val brands = listOf("Samsung", "Iphone", "Xiaomi")
        val price = listOf(
            "$0 - $500",
            "$500 - $1000",
            "$1000 - $1500",
            "$1500 - $2000",
            "$1500 - $2500",
            "$2500 - $3000",
            "$3000 - $3500",
            "$3500 - $4000",
            "$4000 - $4500",
            "$4500 - $5000",
            "$5000 - $10000",
        )

        val brandsAdapter = ArrayAdapter(requireContext(), R.layout.explorer_menu_item, brands)
        val priceAdapter = ArrayAdapter(requireContext(), R.layout.explorer_menu_item, price)

        (binding.explorerInputBrand.editText as? AutoCompleteTextView)?.setAdapter(brandsAdapter)
        (binding.explorerInputPrice.editText as? AutoCompleteTextView)?.setAdapter(priceAdapter)
    }

    private fun filterButtonClick() {
        if (binding.explorerCardCategories.visibility == View.GONE) {
            binding.explorerCardCategories.visibility = View.VISIBLE
            (requireActivity() as MainActivity).changeBottomMenuVisibility(View.GONE)
        } else {
            binding.explorerCardCategories.visibility = View.GONE
            (requireActivity() as MainActivity).changeBottomMenuVisibility(View.VISIBLE)
        }
    }

    private fun acceptButtonClick() {
        binding.explorerCardCategories.visibility = View.GONE
        (requireActivity() as MainActivity).changeBottomMenuVisibility(View.VISIBLE)
        Toast.makeText(context, "Accept!", Toast.LENGTH_SHORT).show()
    }

    private fun cancelButtonClick() {
        binding.explorerCardCategories.visibility = View.GONE
        (requireActivity() as MainActivity).changeBottomMenuVisibility(View.VISIBLE)
    }

    private fun cityPickerButtonClick() {
        Toast.makeText(context, "Pick city!", Toast.LENGTH_SHORT).show()
    }

    private fun observeData() {
        explorerViewModel.data.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.items = it
            }
        }
    }

    private fun observeError() {
        explorerViewModel.error.observe(viewLifecycleOwner) {
            if (it != null)
                Toast.makeText(context, "$it!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeLoading() {
        explorerViewModel.loading.observe(viewLifecycleOwner) {
            if (it) Toast.makeText(context, "Loading...", Toast.LENGTH_LONG).show()
        }
    }
}