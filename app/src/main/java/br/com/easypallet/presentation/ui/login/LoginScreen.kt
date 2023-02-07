package br.com.easypallet.presentation.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import br.com.easypallet.R
import br.com.easypallet.presentation.AppViewModel
import br.com.easypallet.presentation.models.SessionModel
import br.com.easypallet.presentation.theme.EasypalletwearosTheme
import br.com.easypallet.presentation.utils.Route
import com.google.android.gms.wearable.DataClient
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataMapItem
import com.google.android.gms.wearable.Wearable
import com.google.gson.Gson
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController, viewModel: AppViewModel) {
    EasypalletwearosTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon()
            ButtonEnter(navController, viewModel)
        }
    }
}

@Composable
fun ButtonEnter(navController: NavController, viewModel: AppViewModel){
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            Toast.makeText(navController.context, "Recuperando dados do celular...", Toast.LENGTH_SHORT).show()
            scope.launch {
                val dataClient: DataClient = Wearable.getDataClient(navController.context)
                dataClient.dataItems.addOnCompleteListener {
                    if(it.result.count > 0){
                        val sessionModelJson = DataMapItem.fromDataItem(it.result.get(0)).dataMap.get("session") ?: ""
                        viewModel.sessionModel = Gson().fromJson(sessionModelJson, SessionModel::class.java)
                        viewModel.getLoads()
                    }
                    else{
                        navController.navigate(Route.LoginDialog.route)
                    }
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "ENTRAR",
            color = MaterialTheme.colors.secondary
        )
    }
}

@Composable
fun Icon() {
    val image: Painter = painterResource(id = R.drawable.logo_red)
    Image(painter = image, contentDescription = "", modifier = Modifier.fillMaxSize(0.6f))
}



//@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    LoginScreen(rememberNavController())
//}