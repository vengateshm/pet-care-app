package dev.vengateshm.petcareapp.android.di

import dev.vengateshm.petcareapp.AndroidPreferenceProviderImpl
import dev.vengateshm.petcareapp.android.presentation.screens.auth.LoginViewModel
import dev.vengateshm.petcareapp.android.presentation.screens.auth.SignupLandingViewModel
import dev.vengateshm.petcareapp.android.presentation.screens.auth.SignupViewModel
import dev.vengateshm.petcareapp.android.presentation.screens.home.HomeViewModel
import dev.vengateshm.petcareapp.android.presentation.screens.home.ProfileViewModel
import dev.vengateshm.petcareapp.android.presentation.screens.pet.MyPetsViewModel
import dev.vengateshm.petcareapp.data.remote.AppServiceRemoteDataSourceImpl
import dev.vengateshm.petcareapp.data.remote.AuthRemoteDataSourceImpl
import dev.vengateshm.petcareapp.data.remote.KtorApiClient
import dev.vengateshm.petcareapp.data.remote.PetRemoteDataSourceImpl
import dev.vengateshm.petcareapp.data.repository.AppServiceDataSource
import dev.vengateshm.petcareapp.data.repository.AppServiceRepositoryImpl
import dev.vengateshm.petcareapp.data.repository.AuthDataSource
import dev.vengateshm.petcareapp.data.repository.AuthRepositoryImpl
import dev.vengateshm.petcareapp.data.repository.PetDataSource
import dev.vengateshm.petcareapp.data.repository.PetRepositoryImpl
import dev.vengateshm.petcareapp.domain.repository.AppServiceRepository
import dev.vengateshm.petcareapp.domain.repository.AuthRepository
import dev.vengateshm.petcareapp.domain.repository.PetRepository
import dev.vengateshm.petcareapp.domain.usecase.AppServiceUseCase
import dev.vengateshm.petcareapp.domain.usecase.GetMyPetsUseCase
import dev.vengateshm.petcareapp.domain.usecase.LoginUseCase
import dev.vengateshm.petcareapp.domain.usecase.SignupUseCase
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { SignupViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { SignupLandingViewModel(get()) }
    viewModel { MyPetsViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
}

val useCaseModule = module {
    factory { LoginUseCase(get()) }
    factory { SignupUseCase(get()) }
    factory { AppServiceUseCase(get()) }
    factory { GetMyPetsUseCase(get()) }
}

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<AppServiceRepository> { AppServiceRepositoryImpl(get()) }
    single<PetRepository> { PetRepositoryImpl(get()) }
}

val dataSourceModule = module {
    single<AuthDataSource> { AuthRemoteDataSourceImpl(get(), get()) }
    single<AppServiceDataSource> { AppServiceRemoteDataSourceImpl(get()) }
    single<PetDataSource> { PetRemoteDataSourceImpl(get(), get()) }
}

val platformModule = module {
    single<PreferenceProvider> { AndroidPreferenceProviderImpl(get()) }
}

val apiClientModule = module {
    single { KtorApiClient(get()) }
}