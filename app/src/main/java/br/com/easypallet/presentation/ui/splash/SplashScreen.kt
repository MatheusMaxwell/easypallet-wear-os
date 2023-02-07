package br.com.easypallet.presentation.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.MaterialTheme
import br.com.easypallet.R
import br.com.easypallet.presentation.theme.EasypalletwearosTheme
import androidx.navigation.compose.rememberNavController
import br.com.easypallet.presentation.utils.Route

@Composable
fun SplashScreen(navController: NavController) {
    Handler(Looper.getMainLooper()).postDelayed({
        navController.navigate(Route.Login.route)
    }, 3000)

    EasypalletwearosTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center
        ) {
            AppIcon()

        }
    }
}

@Composable
fun AppIcon() {
    val image: Painter = painterResource(id = R.drawable.logo_red)
    Image(painter = image, contentDescription = "", modifier = Modifier.padding(40.dp))
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    SplashScreen(rememberNavController())
}