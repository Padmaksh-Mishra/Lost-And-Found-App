package com.bloodreaper.lostandfound

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.bloodreaper.lostandfound.main.lost.LostFragment
import com.bloodreaper.lostandfound.sealed.NavigationItem
//
//@Composable
//fun BottomNavGraph(navController: NavHostController){
//    NavHost(
//        navController = navController,
//        startDestination = NavigationItem.Mine.route
//    ){
//        composable(route = NavigationItem.Mine.route){
//            LostFragment()
//        }
//    }
//}