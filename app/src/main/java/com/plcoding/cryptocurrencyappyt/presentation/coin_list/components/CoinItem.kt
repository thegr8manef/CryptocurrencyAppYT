package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.domain.model.Coins

@Composable
fun coinItem(
    coins: Coins,
    onItemCLick: (Coins) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onItemCLick(coins) },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "${coins.rank}. ${coins.name} (${coins.symbol})",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = if (coins.is_active) "active" else "not active",
            style = MaterialTheme.typography.body2,
            color = if (coins.is_active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End
        )
    }
}

@Preview(showBackground = true)
@Composable
fun coinItemPreview() {
    coinItem(coins = Coins("1", false, "Bitcoin", 1, "BTC"), onItemCLick = {})
}