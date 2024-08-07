package com.dtoanng.jetpack_compose_instagram.core.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dtoanng.jetpack_compose_instagram.core.presentation.ui.theme.AccentColor
import com.dtoanng.jetpack_compose_instagram.core.presentation.ui.theme.IconDark

@Composable
fun CustomOutlinedButton(
    modifier: Modifier,
    text: String,
    isLoading: Boolean = false,
    resId: Int = 0,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = AccentColor),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) Color.Transparent else Color.White,
            contentColor = AccentColor
        ),
        shape = RoundedCornerShape(25.dp),
        onClick = onClick
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = IconDark)
        } else {
            if (resId != 0)
                Image(
                    painter = painterResource(id = resId),
                    contentDescription = "",
                    modifier = Modifier
                        .size(25.dp)
                        .padding(horizontal = 5.dp)
                )
            Text(
                text = text,
                style = TextStyle(
                    color = AccentColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}