package com.example.miniproject.admin.userAdmin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.miniproject.components.SearchResultList
import com.example.miniproject.components.SearchScreen

@Composable
fun AdminStudentScreen(
    navController: NavController,
    viewModel: AdminStudentViewModel = viewModel()
) {
    val searchText by viewModel.searchText.collectAsState()
    val searchHistory by viewModel.searchHistory.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()

    SearchScreen(
        title = "Student",
        searchPlaceholder = "Enter student display ID...", // Updated placeholder
        searchText = searchText,
        onSearchTextChange = viewModel::onSearchTextChange,
        searchHistory = searchHistory,
        onClearHistoryItem = viewModel::onClearHistoryItem,
        onClearAllHistory = viewModel::clearAllHistory,
        onSearch = { 
            // Add the final search term to history when the user clicks the search icon
            viewModel.addSearchToHistory(searchText)
            // The search is already being performed as the user types.
        },
        onBackClick = { navController.popBackStack() },
        content = { 
            // Display the search results from the ViewModel.
            SearchResultList(
                results = searchResults,
                onEditItem = {
                    // TODO: Navigate to an edit screen for the user with this ID
                },
                onDeleteItem = {
                    // TODO: Implement user deletion logic
                }
            )
        }
    )
}
