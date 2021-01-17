package com.example.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val repo: UserRepository): ViewModel() {
    private val _users: MutableStateFlow<List<User>> = MutableStateFlow(listOf())
    val users: StateFlow<List<User>> = _users

    init {
        viewModelScope.launch {
            repo.fetchData()
            repo.users.collect { data -> _users.value = data }
        }
    }
}