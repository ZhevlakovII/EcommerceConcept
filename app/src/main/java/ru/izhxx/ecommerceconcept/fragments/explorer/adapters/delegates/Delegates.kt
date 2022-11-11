package ru.izhxx.ecommerceconcept.fragments.explorer.adapters.delegates

import android.content.res.ColorStateList
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import coil.load
import coil.transform.RoundedCornersTransformation
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.izhxx.domain.impl.entities.ProductHot
import ru.izhxx.domain.impl.entities.ProductSeller
import ru.izhxx.domain.impl.entities.delegate.CategoryDelegate
import ru.izhxx.domain.impl.entities.delegate.Delegate
import ru.izhxx.domain.impl.entities.delegate.HotDelegate
import ru.izhxx.domain.impl.entities.delegate.SellerDelegate
import ru.izhxx.domain.impl.entities.delegate.data.CategoryDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.HotDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.SearchDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.SellerDelegateImpl
import ru.izhxx.ecommerceconcept.R
import ru.izhxx.ecommerceconcept.databinding.*
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.CategoryAdapter
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.ItemHotAdapter
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.SellerItemsAdapter
import ru.izhxx.ecommerceconcept.model.categories.Category


object Delegates {
    fun categoryDelegate(
        onClick: (Int) -> Unit
    ) = adapterDelegateViewBinding<CategoryDelegateImpl, Delegate, LayoutCategoriesBinding>(
        { inflater, parent -> LayoutCategoriesBinding.inflate(inflater, parent, false) }
    ) {
        val categoryAdapter = CategoryAdapter { onClick(it) }

        binding.recyclerCategories.adapter = categoryAdapter

        bind {
            categoryAdapter.items = item.categoryData
        }
    }

    fun categoryButtonsDelegate(
        onClick: (Int) -> Unit
    ) = adapterDelegateViewBinding<Category, Delegate, ExplorerRecyclerCategoryBinding>(
        { inflater, parent -> ExplorerRecyclerCategoryBinding.inflate(inflater, parent, false) }
    ) {
        binding.categoryButton.setOnClickListener { onClick(layoutPosition) }

        bind {
            binding.categoryText.text = item.name
            binding.categoryButton.setIconResource(item.iconId)

            if (item.isClicked) {
                binding.categoryButton.icon
                    .setTint(ContextCompat.getColor(context, R.color.buttons_background))
                binding.categoryButton.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(context, R.color.primaryColor))
                binding.categoryText
                    .setTextColor(ContextCompat.getColor(context, R.color.primaryColor))
            } else {
                binding.categoryButton.icon
                    .setTint(ContextCompat.getColor(context, R.color.buttons_icon_tint))
                binding.categoryButton.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(context, R.color.buttons_background))
                binding.categoryText
                    .setTextColor(ContextCompat.getColor(context, R.color.secondaryColor))
            }
        }
    }

    val searchDelegate = adapterDelegateViewBinding<SearchDelegateImpl, Delegate, LayoutSearchBinding>(
        { inflater, parent -> LayoutSearchBinding.inflate(inflater, parent, false) }
    ) {
        binding.searchButtonQr.setOnClickListener {
            Toast.makeText(context, "Scanning...", Toast.LENGTH_SHORT).show()
        }
    }

    fun hotDelegate() = adapterDelegateViewBinding<HotDelegateImpl, Delegate, LayoutHotBinding>(
        { inflater, parent -> LayoutHotBinding.inflate(inflater, parent, false) }
    ) {
        val itemHotAdapter = ItemHotAdapter()

        binding.hotRecycler.adapter = itemHotAdapter

        bind {
            itemHotAdapter.items = item.hotData
        }
    }

    val itemHotDelegate = adapterDelegateViewBinding<ProductHot, Delegate, ExplorerRecyclerHotBinding>(
        { inflater, parent -> ExplorerRecyclerHotBinding.inflate(inflater, parent, false) }
    ) {
        bind {
            binding.hotIcon.visibility = if (item.isNew) View.VISIBLE else View.GONE
            binding.hotItemName.text = item.name
            binding.hotItemDescription.text = item.description
            binding.hotPictureItem.load(item.pictureUrl) {
                transformations(RoundedCornersTransformation(radius = 20f))
                placeholder(R.drawable.picture_iphone)
            }
        }
    }

    fun sellersDelegate(
        onFavoriteClick: (Int) -> Unit,
        onItemClick: (Int) -> Unit
    ) = adapterDelegateViewBinding<SellerDelegateImpl, Delegate, LayoutBestSellerBinding>(
        { inflater, parent -> LayoutBestSellerBinding.inflate(inflater, parent, false) }
    ) {
        val adapter = SellerItemsAdapter(
            onFavoriteClick = { onFavoriteClick(it) },
            onItemClick = { onItemClick(it) }
        )

        binding.sellerGrid.adapter = adapter

        bind {
            adapter.items = item.sellerData
        }
    }

    fun sellerItemsAdapter(
        onFavoriteClick: (Int) -> Unit,
        onItemClick: (Int) -> Unit
    ) = adapterDelegateViewBinding<ProductSeller, Delegate, ExplorerRecyclerSellerBinding>(
        { inflater, parent -> ExplorerRecyclerSellerBinding.inflate(inflater, parent, false) }
    ) {
        binding.sellerItemCard.setOnClickListener { onItemClick(layoutPosition) }
        binding.sellerButtonFavorite.setOnClickListener { onFavoriteClick(layoutPosition) }

        bind {
            binding.sellerItemName.text = item.name
            binding.sellerItemDiscount.text =
                getString(R.string.seller_discount, item.discountPrice!!)
            binding.sellerPictureItem.load(item.pictureUrl) {
                transformations(RoundedCornersTransformation(radius = 10f))
                placeholder(R.drawable.icon_trash)
            }

            val string = SpannableString(getString(R.string.seller_price, item.price))
            string.setSpan(StrikethroughSpan(), 0, string.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            binding.sellerItemPrice.text = string

            if (item.isFavorite)
                binding.sellerButtonFavorite.setIconResource(R.drawable.icon_favorite_fill)
            else
                binding.sellerButtonFavorite.setIconResource(R.drawable.icon_favorite)
        }
    }
}