package com.sm.bankappui.presentation.ui.components.sections

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sm.bankappui.domain.model.Finance
import com.sm.bankappui.presentation.theme.AppTheme
import com.sm.bankappui.presentation.theme.BlueStart
import com.sm.bankappui.presentation.theme.GreenStart
import com.sm.bankappui.presentation.theme.OrangeStart
import com.sm.bankappui.presentation.theme.PurpleStart

private val financeItems = listOf(
    Finance(
        icon = Icons.AutoMirrored.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.Analytics,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    )
)

@Composable
fun FinanceSection() {
    Column {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Finance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        LazyRow {

            items(count = financeItems.size,
                key = { index -> financeItems[index].name }) { index ->
                FinanceItem(index = index)
            }

        }
    }
}

@Composable
private fun FinanceItem(index: Int) {

    val financeItem = financeItems[index]

    var lastItemPaddingEnd = 0.dp

    if (index == financeItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    val interactionSource = remember { MutableInteractionSource() }
    val ripple =
        rememberRipple(
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.50f),
        )

    val roundedCornerShape = RoundedCornerShape(25.dp)

    Surface(
        modifier =
        Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
            .clip(roundedCornerShape)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple,
                onClick = {},
            ),
        shape = roundedCornerShape,
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(financeItem.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = financeItem.icon,
                    contentDescription = "",
                    tint = Color.White
                )
            }

            Text(
                text = financeItem.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }


}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun P_1() {
    AppTheme {
        FinanceSection()
    }
}

