package experience_details.presentation.di

import experience_details.presentation.ExperienceDetailsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val experienceDetailsPresentationDi = module {
    viewModelOf(::ExperienceDetailsViewModel)
}