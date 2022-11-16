package com.example.drivingschool.screens.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drivingschool.domain.repositories.AuthRepository
import com.example.drivingschool.models.LoginRequest
import com.example.drivingschool.models.RegisterRequest
import com.example.drivingschool.screens.authentication.states.BaseState
import com.example.drivingschool.screens.authentication.states.LoginState
import com.example.drivingschool.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _sharedFlowRegister = MutableSharedFlow<BaseState>()
    val sharedFlowRegister = _sharedFlowRegister.asSharedFlow()

     private val _sharedFlowLogin = MutableSharedFlow<LoginState>()
    val sharedFlowLogin = _sharedFlowLogin.asSharedFlow()

    fun register(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            _sharedFlowRegister.emit(BaseState(isLoading = true))

            authRepository.register(registerRequest = registerRequest).collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _sharedFlowRegister.emit(BaseState(isLoading = true))
                    }
                    is Resource.Success -> {
                        _sharedFlowRegister.emit(
                            BaseState(
                                isLoading = false,
                                baseCommonResponse = response.data
                            )
                        )
                    }
                    is Resource.Error -> {
                        _sharedFlowRegister.emit(
                            BaseState(
                                isLoading = false,
                                baseCommonResponse = response.data,
                                errors = response.data?.errors
                            )
                        )
                    }
                }

            }

        }
    }

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _sharedFlowLogin.emit(LoginState(isLoading = true))

            authRepository.login(loginRequest = loginRequest).collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _sharedFlowLogin.emit(LoginState(isLoading = true))
                    }
                    is Resource.Success -> {
                        _sharedFlowLogin.emit(
                            LoginState(
                                isLoading = false,
                                loginResponse = response.data
                            )
                        )
                    }
                    is Resource.Error -> {
                        _sharedFlowLogin.emit(
                            LoginState(
                                isLoading = false,
                                loginResponse = response.data,
                                errors = response.data?.errors
                            )
                        )
                    }
                }

            }

        }
    }

}