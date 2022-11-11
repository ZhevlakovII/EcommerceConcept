package ru.izhxx.ecommerceconcept.fragments.explorer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.izhxx.domain.api.usecases.GetExplorerDataUseCase
import ru.izhxx.domain.impl.entities.ProductSeller
import ru.izhxx.domain.impl.entities.delegate.*
import ru.izhxx.domain.impl.entities.delegate.data.CategoryDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.HotDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.SearchDelegateImpl
import ru.izhxx.domain.impl.entities.delegate.data.SellerDelegateImpl
import ru.izhxx.ecommerceconcept.model.categories.Category
import ru.izhxx.ecommerceconcept.model.categories.getCategories
import kotlin.random.Random

class ExplorerViewModel(
    private val getExplorerDataUseCase: GetExplorerDataUseCase
): ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _data = MutableLiveData<List<Delegate>>(emptyList())
    val data: LiveData<List<Delegate>> = _data

    fun loadingData() {
        viewModelScope.launch {
            _loading.postValue(true)

            withContext(Dispatchers.IO) {
                val explorerData = getExplorerDataUseCase.invoke()
                val categoryData = getCategories()

                if (explorerData == null) {
                    withContext(Dispatchers.Main) {
                        _loading.postValue(false)
                        _error.postValue("Data not found")
                    }
                } else {
                    val data = listOf(
                        CategoryDelegateImpl(
                            id = categoryData.hashCode(),
                            categoryData = categoryData
                        ),
                        SearchDelegateImpl(id = _error.hashCode()),
                        HotDelegateImpl(
                            id = explorerData.productsHot.hashCode(),
                            hotData = explorerData.productsHot
                        ),
                        SellerDelegateImpl(
                            id = explorerData.productSellers.hashCode(),
                            sellerData = explorerData.productSellers
                        )
                    )

                    withContext(Dispatchers.Main) {
                        _data.postValue(data)
                        _loading.postValue(false)
                    }
                }
            }
        }
    }

    fun setFavorite(position: Int) {
        viewModelScope.launch {
            val dataList = _data.value!!.toMutableList()

            ((dataList[3] as SellerDelegateImpl).sellerData[position] as ProductSeller).isFavorite =
                !((dataList[3] as SellerDelegateImpl).sellerData[position] as ProductSeller).isFavorite

            _data.postValue(dataList)
        }
    }

    fun changeCategory(position: Int) {
        viewModelScope.launch {
            val dataList = _data.value!!.toMutableList()

            (_data.value!![0] as CategoryDelegateImpl).categoryData.forEachIndexed { index, data ->
                ((dataList[0] as CategoryDelegateImpl).
                categoryData[index] as Category).isClicked = index == position
            }

            _data.postValue(dataList)
        }
    }
}