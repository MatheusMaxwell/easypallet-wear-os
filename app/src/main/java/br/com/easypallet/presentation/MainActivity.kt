/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package br.com.easypallet.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.easypallet.presentation.ui.login.LoginDialogScreen
import br.com.easypallet.presentation.ui.login.LoginScreen
import br.com.easypallet.presentation.ui.splash.SplashScreen
import br.com.easypallet.presentation.utils.Route
import com.google.android.gms.wearable.Wearable

class MainActivity : ComponentActivity() {

    private val dataClient by lazy { Wearable.getDataClient(this) }
    private val viewModel by viewModels<AppViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Route.Splash.route){
                composable(Route.Splash.route){ SplashScreen(navController) }
                composable(Route.Login.route){ LoginScreen(navController, viewModel)}
                composable(Route.LoginDialog.route){ LoginDialogScreen(navController)}
            }
        }
    }

}
