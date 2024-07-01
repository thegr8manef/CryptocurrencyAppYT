package com.plcoding.cryptocurrencyappyt.presentation.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun tagCoin(tag: String) {
    Box(
        modifier = Modifier
            .border(1.dp, Color.Green, RoundedCornerShape(100.dp))
            .padding(10.dp)
    ) {
        Text(
            text = tag,
            color = Color.Green,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
@Preview(showBackground = true)
fun tagPreview() {
    repeat(10) {
        tagCoin("manef")
    }
}