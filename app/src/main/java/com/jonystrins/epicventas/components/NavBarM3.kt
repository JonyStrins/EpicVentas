package com.jonystrins.epicventas.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.navigation.BottomNavigationItem

@Composable
fun NavBarM3(navController: NavHostController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination =  navBackStackEntry?.destination

        val listOfNavItems = listOf(
            BottomNavigationItem(
                title = "Ventas",
                selectedIcon = ImageVector.vectorResource(R.drawable.shopping_bag),
                unselectedIcon = ImageVector.vectorResource(R.drawable.outline_shopping_bag),
            ),
            BottomNavigationItem(
                title = "Carrito",
                selectedIcon = Icons.Filled.ShoppingCart,
                unselectedIcon = Icons.Outlined.ShoppingCart,
            ),
            BottomNavigationItem(
                title = "Almacen",
                selectedIcon = ImageVector.vectorResource(R.drawable.inventory_selected),
                unselectedIcon = ImageVector.vectorResource(R.drawable.inventory_unselected),
            ),
            BottomNavigationItem(
                title = "Ajustes",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
            )
        )

        listOfNavItems.forEach{ navItem ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == navItem.title } == true,
                onClick = {
                    navController.navigate(navItem.title){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                label = {
                        Text(navItem.title)
                },
                alwaysShowLabel = false,
                icon = {
                    Icon(
                        imageVector =
                            if (currentDestination?.hierarchy?.any { it.route == navItem.title } == true)
                                navItem.selectedIcon
                            else navItem.unselectedIcon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}