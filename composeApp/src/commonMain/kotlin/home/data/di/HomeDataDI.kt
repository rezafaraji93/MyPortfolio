package home.data.di

import home.data.repository.HomeRepositoryImpl
import home.domain.repository.HomeRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeDataModule = module {
    singleOf(::HomeRepositoryImpl).bind<HomeRepository>()
}