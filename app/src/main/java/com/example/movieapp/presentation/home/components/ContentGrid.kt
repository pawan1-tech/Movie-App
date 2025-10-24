package com.example.movieapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.movieapp.data.model.WatchContent

@Suppress("ktlint:standard:function-naming")
@Composable
fun ContentGrid(
    contents: List<WatchContent>,
    onItemClick: (String) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(contents) { content ->
            WatchContentCart(
                content = content,
                onClick = {
                    onItemClick(content.id)
                },
            )
        }
    }
}
