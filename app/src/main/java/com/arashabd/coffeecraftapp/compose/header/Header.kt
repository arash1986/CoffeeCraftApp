package com.arashabd.coffeecraftapp.compose.header

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.arashabd.coffeecraftapp.R
import com.arashabd.coffeecraftapp.ui.theme.Light_500
import com.arashabd.coffeecraftapp.ui.theme.Light_800
import com.arashabd.coffeecraftapp.ui.theme.Typography


@Composable
fun Header(title: String, context: Context = LocalContext.current) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .size(size = 65.dp)
        ) {
            Text(
                text = title,
                style = Typography.bodyMedium,
                color = Light_800,
                modifier = Modifier.align(Alignment.Center),
                fontSize = TextUnit(22f, TextUnitType.Sp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                tint = Light_500,
                modifier = Modifier.align(Alignment.CenterStart).clickable {
                    //(context as DashboardActivity).navController?.popBackStack()
                }
            )
        }
    }
