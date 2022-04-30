package com.example.vgeqapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vgeqapp.api.NetworkResult
import com.example.vgeqapp.data.EQData
import com.example.vgeqapp.model.EarthQuakeDataResponse
import com.example.vgeqapp.repository.EQRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class EQViewModel @Inject constructor(private val eqRepo:EQRepository) : ViewModel() {

   private val _getLatestEQData :  MutableLiveData<NetworkResult<List<EQData>?>> = MutableLiveData()
    val getLatestEQData : LiveData<NetworkResult<List<EQData>?>>
        get()  = _getLatestEQData

    private val _getSelectedEQData :  MutableLiveData<EQData?> = MutableLiveData()
    val getSelectedEQData : LiveData<EQData?>
        get()  = _getSelectedEQData

    fun getLatestEQData() {
        viewModelScope.launch {
            _getLatestEQData.value = NetworkResult.Loading()
            val response = eqRepo.getLatestEQData()
            try {
                _getLatestEQData.value = NetworkResult.Success(response)

            } catch (e: Exception) {
                _getLatestEQData.value = NetworkResult.Error(e.message)
            }
        }
    }

    fun setSelectedEQRecord(selectedID:String) {
        _getLatestEQData.value?.data?.forEach {
            if(it.id.equals(selectedID)) {
                _getSelectedEQData.value = it
                return@forEach
            }
        }
    }
}