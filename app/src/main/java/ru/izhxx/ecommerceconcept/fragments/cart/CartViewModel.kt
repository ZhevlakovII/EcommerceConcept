package ru.izhxx.ecommerceconcept.fragments.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.izhxx.domain.api.usecases.GetUserBasketUseCase
import ru.izhxx.domain.impl.entities.UserBasket

class CartViewModel(
    private val getCartUseCase: GetUserBasketUseCase
): ViewModel() {
    private val _loading = MutableLiveData<Boolean>().apply { value = true }
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>().apply { value = null }
    val error: LiveData<String> = _error

    private val _data = MutableLiveData<UserBasket>().apply { value = null }
    val data: LiveData<UserBasket> = _data

    fun loadingData(userId: Int) {
        viewModelScope.launch {
            _loading.postValue(true)

            withContext(Dispatchers.IO) {
                val cartData = getCartUseCase.invoke(userId)

                if (cartData == null) {
                    withContext(Dispatchers.Main) {
                        _loading.postValue(false)
                        _error.postValue("Data not found")
                    }
                }

                withContext(Dispatchers.Main) {
                    _data.postValue(cartData)
                    _loading.postValue(false)
                }
            }
        }
    }

    fun addProduct(position: Int) {
        viewModelScope.launch {
            val basket = _data.value!!

            basket.products[position].count++

            _data.postValue(basket)
        }
    }

    fun deleteProduct(position: Int) {
        viewModelScope.launch {
            var basket = _data.value!!

            withContext(Dispatchers.Default) {
                basket.products[position].count--

                if (basket.products[position].count == 0) {
                    val editProducts = basket.products.toMutableList()
                    editProducts.removeAt(position)

                    basket = basket.copy(products = editProducts)
                }
            }

            _data.postValue(basket)
        }
    }

    fun removeProduct(position: Int) {
        viewModelScope.launch {
            var basket = _data.value!!
            val editProducts = basket.products.toMutableList()
            editProducts.removeAt(position)
            _data.postValue(basket.copy(products = editProducts))
        }
    }

    companion object {
        const val fakeUserId = 0
    }
}