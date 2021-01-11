package com.example.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(private val repo: UserRepository): ViewModel() {
    val users: Flow<List<User>> = repo.getUsers()
    val usersSortedByFirstName: Flow<List<User>> = users.map { it -> it.sortedBy { it.firstName } }
    val usersSortedByLastName: Flow<List<User>> = users.map { it -> it.sortedBy { it.lastName } }
    val usersSortedByAge: Flow<List<User>> = users.map { it -> it.sortedBy{ it.lastName } }

    init {
        viewModelScope.launch { repo.fetchData() }
    }
}