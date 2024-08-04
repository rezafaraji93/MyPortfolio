package experience_detaills.data.di

import experience_detaills.data.repository.ExperienceDetailsRepositoryImpl
import experience_detaills.domain.repository.ExperienceDetailsRepository
import home.data.repository.HomeRepositoryImpl
import home.domain.repository.HomeRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val experienceDataModule = module {
    singleOf(::ExperienceDetailsRepositoryImpl).bind<ExperienceDetailsRepository>()
}