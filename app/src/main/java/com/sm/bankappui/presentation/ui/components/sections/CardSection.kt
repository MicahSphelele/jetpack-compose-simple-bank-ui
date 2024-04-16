package com.sm.bankappui.presentation.ui.components.sections

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sm.bankappui.R
import com.sm.bankappui.domain.model.Card
import com.sm.bankappui.presentation.theme.AppTheme
import com.sm.bankappui.presentation.theme.BlueEnd
import com.sm.bankappui.presentation.theme.BlueStart
import com.sm.bankappui.presentation.theme.GreenEnd
import com.sm.bankappui.presentation.theme.GreenStart
import com.sm.bankappui.presentation.theme.OrangeEnd
import com.sm.bankappui.presentation.theme.OrangeStart
import com.sm.bankappui.presentation.theme.PurpleEnd
import com.sm.bankappui.presentation.theme.PurpleStart
import com.sm.bankappui.util.Constants
import com.sm.bankappui.util.Utils.getGradient

private val cardItems = listOf(
    Card(
        cardType = Constants.TYPE_VISA,
        cardNumber = "1234 5678 9012 3456",
        cardName = "Business",
        balance = 23.573,
        color = getGradient(PurpleStart, PurpleEnd),
    ), Card(
        cardType = Constants.TYPE_MASTERCARD,
        cardNumber = "3365 5678 9012 1956",
        cardName = "Savings",
        balance = 55.770,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = Constants.TYPE_VISA,
        cardNumber = "0756 5478 0012 1956",
        cardName = "School",
        balance = 8.770,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = Constants.TYPE_MASTERCARD,
        cardNumber = "0876 5478 0812 1956",
        cardName = "Travel",
        balance = 50.379,
        color = getGradient(GreenStart, GreenEnd)
    )


)

@Composable
fun CardSection() {
    LazyRow {
        items(count = cardItems.size,
            key = { index -> cardItems[index].cardNumber }) { index ->
            CardItem(index = index)
        }

    }
}

@Composable
private fun CardItem(index: Int) {

    val card = cardItems[index]

    var lastItemPaddingEnd = 0.dp

    if (index == cardItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)

    if (card.cardType == Constants.TYPE_MASTERCARD) {
        image = painterResource(id = R.drawable.ic_mastercard)
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
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier =
                Modifier
                    .background(brush = card.color)
                    .width(250.dp)
                    .height(160.dp)
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    modifier = Modifier.width(60.dp),
                    painter = image,
                    contentDescription = card.cardName
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = card.cardName,
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "R ${card.balance}",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = card.cardNumber,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun P_1() {
    AppTheme {
        CardSection()
    }
}
