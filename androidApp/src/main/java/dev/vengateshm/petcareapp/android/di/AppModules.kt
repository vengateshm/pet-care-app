package dev.vengateshm.petcareapp.android.di

import dev.vengateshm.petcareapp.AndroidPreferenceProviderImpl
import dev.vengateshm.petcareapp.android.presentation.screens.auth.LoginViewModel
import dev.vengateshm.petcareapp.android.presentation.screens.auth.SignupLandingViewModel
import dev.vengateshm.petcareapp.android.presentation.screens.auth.SignupViewModel
import dev.vengateshm.petcareapp.android.presentation.screens.home.HomeViewModel
import dev.vengateshm.petcareapp.data.remote.AuthRemoteDataSourceImpl
import dev.vengateshm.petcareapp.data.remote.KtorApiClient
import dev.vengateshm.petcareapp.data.remote.ServicesOfferedRemoteDataSourceImpl
import dev.vengateshm.petcareapp.data.repository.AuthDataSource
import dev.vengateshm.petcareapp.data.repository.AuthRepositoryImpl
import dev.vengateshm.petcareapp.data.repository.ServicesOfferedDataSource
import dev.vengateshm.petcareapp.data.repository.ServicesOfferedRepositoryImpl
import dev.vengateshm.petcareapp.domain.repository.AuthRepository
import dev.vengateshm.petcareapp.domain.repository.ServicesOfferedRepository
import dev.vengateshm.petcareapp.domain.usecase.LoginUseCase
import dev.vengateshm.petcareapp.domain.usecase.ServicesOfferedUseCase
import dev.vengateshm.petcareapp.domain.usecase.SignupUseCase
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { SignupViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { SignupLandingViewModel(get()) }
}

val useCaseModule = module {
    factory { ServicesOfferedUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { SignupUseCase(get()) }
}

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<ServicesOfferedRepository> { ServicesOfferedRepositoryImpl(get()) }
}

val dataSourceModule = module {
    single<AuthDataSource> { AuthRemoteDataSourceImpl(get(), get()) }
    single<ServicesOfferedDataSource> { ServicesOfferedRemoteDataSourceImpl(get()) }
}

val platformModule = module {
    single<PreferenceProvider> { AndroidPreferenceProviderImpl(get()) }
}

val apiClientModule = module {
    single { KtorApiClient(get()) }
}