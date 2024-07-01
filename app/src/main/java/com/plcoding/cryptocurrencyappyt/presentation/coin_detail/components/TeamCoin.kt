package com.plcoding.cryptocurrencyappyt.presentation.coin_detail.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun teamCoin(name: String, position: String) {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body1
        )
        Text(
            text = position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
        )
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun teamCoinPreview() {
    teamCoin(name = "Mohamed Manef DJEDIDI", position = "Android Developer")
}