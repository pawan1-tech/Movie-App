package com.example.movieapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import com.example.movieapp.presentation.utils.ContentType

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeTopBar(
    selectedType: ContentType,
    onTypeSelected: (ContentType) -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ContentType.values().forEach { type ->
            Button(
                onClick = { onTypeSelected(type) },
                colors =
                    ButtonDefaults.buttonColors(
                        backgroundColor =
                            if (selectedType == type) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.surfaceVariant
                            },
                        contentColor =
                            if (selectedType == type) {
                                MaterialTheme.colorScheme.onPrimary
                            } else {
                                MaterialTheme.colorScheme.onSurface
                            },
                    ),
                modifier = Modifier.weight(1f), // Ensures equal button width
            ) {
                Text(
                    text = type.name.uppercase(),
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }
    }
}
