package ru.izhxx.ecommerceconcept.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.izhxx.ecommerceconcept.fragments.cart.CartViewModel
import ru.izhxx.ecommerceconcept.fragments.details.DetailsViewModel
import ru.izhxx.ecommerceconcept.fragments.explorer.ExplorerViewModel

val viewModelsModule = module {
    viewModel<CartViewModel> { CartViewModel(getCartUseCase = get()) }

    viewModel<DetailsViewModel> { DetailsViewModel(getProductDetailUseCase = get()) }

    viewModel<ExplorerViewModel> { ExplorerViewModel(getExplorerDataUseCase = get()) }
}