package br.com.easypallet.presentation.ui.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.dialog.Alert

@Composable
fun LoginDialogScreen(navController: NavController){
    Alert(
        title = { Text("Login", textAlign = TextAlign.Center) },
        negativeButton = { },
        positiveButton = { Button(onClick = {
            navController.popBackStack()
        }) { Text("Ok") } },
        contentPadding =
        PaddingValues(start = 10.dp, end = 10.dp, top = 24.dp, bottom = 32.dp),
    ) {
        Text(
            text = "Faça login no app do smartphone, acesse o menu superior e clique em Sincronizar.",
            textAlign = TextAlign.Center
        )
    }
}