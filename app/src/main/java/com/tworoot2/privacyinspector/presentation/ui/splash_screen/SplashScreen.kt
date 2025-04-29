package com.tworoot2.privacyinspector.presentation.ui.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tworoot2.privacyinspector.R
import com.tworoot2.privacyinspector.navigation.AppRoutes
import com.tworoot2.privacyinspector.utils.privacy
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {

    LaunchedEffect(key1 = Unit) {
        delay(1000)
        navHostController.navigate(AppRoutes.ROUTE_ALL_APPLICATION_SCREEN.route)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painterResource(R.drawable.app_icon_one),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )

        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = stringResource(R.string.app_description),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}