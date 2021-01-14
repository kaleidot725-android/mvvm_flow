package com.example.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(private val repo: UserRepository): ViewModel() {
    val users: Flow<List<User>> = repo.getUsers()
    val usersSortedByFirstName: Flow<List<User>> = repo.getUserSortedByFirstName()
    val usersSortedByLastName: Flow<List<User>> = repo.getUserSortedByLastName()
    val usersSortedByAge: Flow<List<User>> = repo.getUserSortedByAge()

    init {
        viewModelScope.launch { repo.fetchData() }
    }
}