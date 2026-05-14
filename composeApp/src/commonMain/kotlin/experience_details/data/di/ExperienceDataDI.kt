package experience_details.data.di

import experience_details.data.repository.ExperienceDetailsRepositoryImpl
import experience_details.domain.repository.ExperienceDetailsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val experienceDataModule = module {
    singleOf(::ExperienceDetailsRepositoryImpl).bind<ExperienceDetailsRepository>()
}