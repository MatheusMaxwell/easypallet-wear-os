package br.com.easypallet.presentation.utils

import br.com.easypallet.presentation.utils.RouteConst.LOGIN_DIALOG_SCREEN
import br.com.easypallet.presentation.utils.RouteConst.LOGIN_SCREEN
import br.com.easypallet.presentation.utils.RouteConst.SPLASH_SCREEN

object RouteConst {
    //Screens
    const val SPLASH_SCREEN = "splash"
    const val LOGIN_SCREEN = "login"
    const val LOGIN_DIALOG_SCREEN = "login_dialog"
}

sealed class Route(val route: String) {
    object Splash: Route(SPLASH_SCREEN)
    object Login: Route(LOGIN_SCREEN)
    object LoginDialog: Route(LOGIN_DIALOG_SCREEN)
//    object Detail: Route("$DETAIL_SCREEN/{$DETAIL_ARG_GAMES_ID}") {
//        fun createRoute(gamesId: Int) = "$DETAIL_SCREEN/$gamesId"
//    }
}