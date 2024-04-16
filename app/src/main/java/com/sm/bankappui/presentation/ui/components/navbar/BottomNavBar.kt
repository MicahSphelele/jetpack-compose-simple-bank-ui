package com.sm.bankappui.presentation.ui.components.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sm.bankappui.domain.model.BottomNavItem

private val bottomNavItems = listOf(
    BottomNavItem("Home", Icons.Rounded.Home),
    BottomNavItem("Wallet", Icons.Rounded.Wallet),
    BottomNavItem("Notification", Icons.Rounded.Notifications),
    BottomNavItem("Account", Icons.Rounded.AccountCircle)
)

@Composable
fun BottomNavBar() {

    NavigationBar {

        Row(modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)) {
            bottomNavItems.forEachIndexed { _, item ->
                NavigationBarItem(selected = false,
                    onClick = {

                }, icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title, tint = MaterialTheme.colorScheme.onBackground)
                }, label = {
                    Text(item.title, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.onBackground)
                })
            }
        }
    }

}