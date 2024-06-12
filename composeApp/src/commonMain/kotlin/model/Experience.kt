package model

import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.android_developer
import myportfolio.composeapp.generated.resources.bit24
import myportfolio.composeapp.generated.resources.bit24_1
import myportfolio.composeapp.generated.resources.bit24_description
import myportfolio.composeapp.generated.resources.bit24_duration
import myportfolio.composeapp.generated.resources.bit24_info
import myportfolio.composeapp.generated.resources.hopesky
import myportfolio.composeapp.generated.resources.hopesky1
import myportfolio.composeapp.generated.resources.hopesky_duration
import myportfolio.composeapp.generated.resources.hopesky_info
import myportfolio.composeapp.generated.resources.hopesky_info_description
import myportfolio.composeapp.generated.resources.junior_android_developer
import myportfolio.composeapp.generated.resources.raybit
import myportfolio.composeapp.generated.resources.raybit1
import myportfolio.composeapp.generated.resources.raybit_description
import myportfolio.composeapp.generated.resources.raybit_duration
import myportfolio.composeapp.generated.resources.raybit_info
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class Experience(
    val logo: DrawableResource,
    val title: StringResource,
    val companyNameAndLocation: StringResource,
    val duration: StringResource,
    val description: StringResource,
    val image: DrawableResource
) {

    data object Bit24: Experience(
        logo = Res.drawable.bit24,
        title = Res.string.android_developer,
        companyNameAndLocation = Res.string.bit24_info,
        duration = Res.string.bit24_duration,
        description = Res.string.bit24_description,
        image = Res.drawable.bit24_1
    )

    data object Raybit: Experience(
        logo = Res.drawable.raybit,
        title = Res.string.android_developer,
        companyNameAndLocation = Res.string.raybit_info,
        duration = Res.string.raybit_duration,
        description = Res.string.raybit_description,
        image = Res.drawable.raybit1
    )

    data object HopeSky: Experience(
        logo = Res.drawable.hopesky,
        title = Res.string.junior_android_developer,
        companyNameAndLocation = Res.string.hopesky_info,
        duration = Res.string.hopesky_duration,
        description = Res.string.hopesky_info_description,
        image = Res.drawable.hopesky1
    )

}