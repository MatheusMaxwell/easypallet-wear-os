package br.com.easypallet.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.easypallet.data.ApiService
import br.com.easypallet.data.models.Load
import br.com.easypallet.data.models.ResponseLoads
import br.com.easypallet.presentation.models.SessionModel
import com.google.android.gms.wearable.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppViewModel: ViewModel(){

    var sessionModel: SessionModel? = null

    var loadListResponse: List<Load> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getLoads() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                ApiService.getInstance().getPagedUserLoads(
                    sessionModel?.userId,
                    sessionModel?.localityId,
                    "Bearer ${sessionModel?.token}"
                ).enqueue(object : Callback<ResponseLoads>{
                    override fun onResponse(
                        call: Call<ResponseLoads>,
                        response: Response<ResponseLoads>
                    ) {
                        if(response.code() == 200){
                            response.body()?.let {
                                loadListResponse = it.loads
                            }
                        }
                        else{
                            loadListResponse = emptyList()
                        }
                    }

                    override fun onFailure(call: Call<ResponseLoads>, t: Throwable) {
                        errorMessage = t.message.toString()
                    }

                })
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}