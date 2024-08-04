package experience_detaills.presentation.di

import experience_detaills.presentation.ExperienceDetailsViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val experienceDetailsPresentationDi = module {
    viewModelOf(::ExperienceDetailsViewModel)
}