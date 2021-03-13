/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {

    val navController = rememberNavController()
    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { Welcome(navController) }
        composable("login") { Login(navController) }
        composable("home") { Home() }

    }
}

@Composable
fun Welcome(navController: NavController) {
    Surface(color = MaterialTheme.colors.primary) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),imageVector = ImageVector.vectorResource(id = R.drawable.ic_welcome_bg)
                ,contentDescription = null,contentScale = ContentScale.Crop)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {

            Image(modifier = Modifier
                .padding(top = 72.dp)
                .offset(x = 88.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_welcome_illos)
                ,contentDescription = null,contentScale = ContentScale.Crop)

            Image(modifier = Modifier
                .padding(top = 48.dp)
                .align(Alignment.CenterHorizontally),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo)
                ,contentDescription = null,contentScale = ContentScale.Crop)

            Text(modifier = Modifier
                .paddingFromBaseline(top = 32.dp, bottom = 40.dp)
                .align(Alignment.CenterHorizontally),text = "Beautiful home garden solutions",style = MaterialTheme.typography.subtitle1,color = MaterialTheme.colors.onPrimary)
            Button(onClick = {  }, modifier = Modifier
                .padding(top = 0.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .requiredHeight(height = 48.dp),colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),shape = MaterialTheme.shapes.medium) {
                Text(text = "Create account",style = MaterialTheme.typography.button,color= MaterialTheme.colors.onSecondary)
                
            }

            Button(onClick = { navController.navigate("login") }, modifier = Modifier
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .requiredHeight(height = 48.dp),elevation = ButtonDefaults.elevation(defaultElevation = 0.dp,pressedElevation = 0.dp),colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),shape = MaterialTheme.shapes.medium) {
                // requested text color is pink-900 in light theme and white in dark theme, but there is no provided material theme color attribute which corresponds to said colors so we use primaryVariant for this job as it has no other use case through the app
                Text(text = "Log in",style = MaterialTheme.typography.button,color= MaterialTheme.colors.primaryVariant)

            }

        }

    }
}

@Composable
fun Login(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Text(modifier = Modifier
                .paddingFromBaseline(top = 184.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),text = "Log in with email",textAlign = TextAlign.Center,color = MaterialTheme.colors.onBackground,style = MaterialTheme.typography.h1)

            OutlinedTextField(modifier= Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .requiredHeight(height = 56.dp)
                .fillMaxWidth(),value = "Email address", onValueChange = {}, textStyle = MaterialTheme.typography.body1)
            OutlinedTextField(modifier= Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                .requiredHeight(height = 56.dp)
                .fillMaxWidth(),value = "Password (8+ characters)", onValueChange = {}, textStyle = MaterialTheme.typography.body1)
            val annotatedString= AnnotatedString.Builder("By clicking below, you agree to our Terms of Use and consent to our Privacy Policy")
                .apply {
                    addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline), 35, 48)
                    addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline), 68, 82)
                }
            Text(text = annotatedString.toAnnotatedString(), modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),textAlign = TextAlign.Center,color = MaterialTheme.colors.onBackground,style = MaterialTheme.typography.body2)

            Button(onClick = { navController.navigate("home") }, modifier = Modifier
                .padding(top = 0.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .requiredHeight(height = 48.dp),colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),shape = MaterialTheme.shapes.medium) {
                Text(text = "Log in",style = MaterialTheme.typography.button,color= MaterialTheme.colors.onSecondary)

            }
        }




    }
}

@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.requiredHeight(height=40.dp))
            OutlinedTextField(modifier= Modifier
                .padding(start = 16.dp, end = 16.dp, top = 0.dp)
                .requiredHeight(height = 56.dp)
                .fillMaxWidth(),value = "Search", onValueChange = {}, textStyle = MaterialTheme.typography.body1,leadingIcon = {Icon( modifier = Modifier.requiredSize(18.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_search_24),
                contentDescription = null)})
            Text(text = "Browse themes", modifier = Modifier
                .paddingFromBaseline(top = 32.dp, bottom = 0.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),textAlign = TextAlign.Start,color = MaterialTheme.colors.onBackground,style = MaterialTheme.typography.h1)

            Spacer(modifier = Modifier.requiredHeight(16.dp))
            LazyRow(modifier= Modifier
                .requiredHeight(136.dp)
                .fillMaxWidth(), contentPadding = PaddingValues(start = 16.dp,bottom = 1.dp),horizontalArrangement = Arrangement.spacedBy(8.dp),content = {
                for (data in horizontalItems) {
                    item {
                        Surface(
                            modifier = Modifier.requiredSize(136.dp),
                            shape = MaterialTheme.shapes.small,
                            color = MaterialTheme.colors.secondaryVariant,elevation = 1.dp
                        ) {
                            Column() {
                                Image(
                                    modifier = Modifier
                                        .requiredHeight(height = 96.dp)
                                        .requiredWidth(136.dp)
                                    ,
                                    painter = painterResource(id = data.imgres),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop)

                                Box(modifier = Modifier
                                    .weight(1f, true)
                                    .padding(start = 16.dp)) {
                                    Text(modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.CenterStart), text = data.title,color = MaterialTheme.colors.onBackground,style = MaterialTheme.typography.h2)
                                }

                            }
                        }
                    }
                }
            })

            Row(modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(56.dp),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Design your home garden", modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 0.dp)
                    .padding(start = 16.dp),textAlign = TextAlign.Start,color = MaterialTheme.colors.onBackground,style = MaterialTheme.typography.h1)
            
                Icon(modifier = Modifier
                    .padding(end = 16.dp)
                    .requiredSize(24.dp)
                    .align(Alignment.CenterVertically),imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter_list_24), contentDescription = null)
            }

            LazyColumn(contentPadding= PaddingValues(bottom = 56.dp,start = 16.dp,end = 16.dp),verticalArrangement = Arrangement.spacedBy(8.dp),content = {
                verticalItems.forEachIndexed  { index, item ->
                item {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .requiredHeight(56.dp),horizontalArrangement = Arrangement.SpaceBetween) {
                            Row() {
                                Image(
                                    modifier = Modifier
                                        .requiredHeight(height = 56.dp)
                                        .requiredWidth(56.dp)
                                        .clip(MaterialTheme.shapes.small)
                                    ,
                                    painter = painterResource(id = item.imgres),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop)

                                Column(verticalArrangement = Arrangement.SpaceBetween) {
                                    Text(text = item.title, modifier = Modifier
                                        .paddingFromBaseline(top = 24.dp, bottom = 0.dp)
                                        .padding(start = 16.dp),textAlign = TextAlign.Start,color = MaterialTheme.colors.onBackground,style = MaterialTheme.typography.h2)
                                    Text(text = "This is a description", modifier = Modifier
                                        .paddingFromBaseline(top = 0.dp, bottom = 24.dp)
                                        .padding(start = 16.dp),textAlign = TextAlign.Start,color = MaterialTheme.colors.onBackground,style = MaterialTheme.typography.body1)
                                }
                            }
                            
                            Checkbox(modifier = Modifier.align(Alignment.CenterVertically),checked = index == 0, colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.onSecondary),onCheckedChange = { },)

                        }
                    Divider(color = Color.Gray,thickness = 1.dp,startIndent = 72.dp)
                    }

                }
            })
        }
        
        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()){
            BottomNavigation(modifier = Modifier.align(Alignment.BottomCenter),elevation = 16.dp,backgroundColor = MaterialTheme.colors.primary) {
                BottomNavigationItem(selected = true, onClick = { } , icon = {Icon( modifier = Modifier.requiredSize(24.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_24),
                    contentDescription = null)} , label = { Text(text = "Home",style=MaterialTheme.typography.caption,color = MaterialTheme.colors.onPrimary)} )
                BottomNavigationItem(selected = false, onClick = { } , icon = {Icon( modifier = Modifier.requiredSize(24.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_favorite_border_24),
                    contentDescription = null)} , label = { Text(text = "Favorites",style=MaterialTheme.typography.caption,color = Color.Gray)} )
                BottomNavigationItem(selected = false, onClick = { } , icon = {Icon( modifier = Modifier.requiredSize(24.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24),
                    contentDescription = null)} , label = { Text(text = "Profile",style=MaterialTheme.typography.caption,color = Color.Gray)} )
                BottomNavigationItem(selected = false, onClick = { } , icon = {Icon( modifier = Modifier.requiredSize(24.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_shopping_cart_24),
                    contentDescription = null)} , label = { Text(text = "Cart",style=MaterialTheme.typography.caption,color = Color.Gray)} )
            }
        }

    }
}



@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()

    }
}

/* icon
* Icon(
imageVector = ImageVector.vectorResource(id = genderIconRes),
tint = genderIconTint,
contentDescription = "Gender Icon",
modifier = Modifier
.size(24.dp))
* */


/* image
Image(
modifier = Modifier
.size(size = 36.dp)
.border(
width = borderWidth.dp,
color = borderColor,
shape = RoundedCornerShape(4.dp))
.clip(RoundedCornerShape(4.dp)),
painter = painterResource(id = resId),
contentDescription = null,
contentScale = ContentScale.Crop)
*/

data class Item(val imgres : Int,val title : String)

val verticalItems = listOf<Item>(Item(R.drawable.img6,title = "Monstera")
,Item(R.drawable.img7,title = "Aglaonema"),Item(R.drawable.img8,title = "Peace lily"),Item(R.drawable.img9,title = "Fiddle leaf tree")
,Item(R.drawable.img10,title = "Snake plant"),Item(R.drawable.img11,title = "Pothos"))

val horizontalItems = listOf<Item>(Item(R.drawable.img1,title = "Desert chic")
    ,Item(R.drawable.img2,title = "Tiny terraiums"),Item(R.drawable.img3,title = "Jungle vibes"),Item(R.drawable.img4,title = "Easy care")
    ,Item(R.drawable.img5,title = "Statements"))