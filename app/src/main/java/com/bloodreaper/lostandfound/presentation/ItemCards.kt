package com.bloodreaper.lostandfound.presentation

import android.media.Image
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.ExperimentalCoroutinesApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bloodreaper.lostandfound.R
import com.bloodreaper.lostandfound.models.PostData
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalCoroutinesApi
@Composable
fun ItemCards(
    post: PostData,
){
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if(expandedState) 180f else 0f)
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Image(
                    painterResource(R.drawable.empty_plate),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    contentScale = ContentScale.Fit
                )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = post.where!!,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(DefaultAlpha)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop down")
                    
                }
            }
            if(expandedState){
                Column(modifier = Modifier
                    .fillMaxWidth()) {
                    Text(
                        text = "Owner's message",
                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                        modifier = Modifier.padding(bottom = 4.dp),
                    textDecoration = TextDecoration.Underline)
                    Text(
                        text = post.message!!,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        modifier = Modifier.padding(bottom = 8.dp),
                        textAlign = TextAlign.Justify
                        )
                    Text(
                        text = "Contact Details",
                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                        modifier = Modifier.padding(bottom = 4.dp),
                        textDecoration = TextDecoration.Underline)
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = post.name!!,
                            modifier = Modifier.weight(6f),
                            fontSize = MaterialTheme.typography.labelLarge.fontSize,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(text = post.phone!!,
                            modifier = Modifier.weight(1f),
                            fontSize = MaterialTheme.typography.labelLarge.fontSize,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                        )
                    }
                }
            }
        }
        
    }
}

@ExperimentalMaterial3Api
@Composable
@Preview
fun ItemCardsPreview(){
    ItemCards(PostData("Lost"
        ,"sdf",
        "PM",
        "89xxxxxxx56"
        ,"Libaray"
        ,"agar mile to please batana mughe bahut zauruart hai",null))
}





//fun ItemCards(
//    post: PostData,
////    onClick: () -> Unit,
//){
//    ElevatedCard(
//        shape = CardDefaults.elevatedShape,
//        colors = CardDefaults.elevatedCardColors(),
//        elevation = CardDefaults.elevatedCardElevation(),
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()
//    ) {Image(
//                    painterResource(R.drawable.empty_plate),
//                    contentDescription = "",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(225.dp),
//                    contentScale = ContentScale.Crop
//                )
//        Column {
//            post.message?.let {
//                Image(
//                    painterResource(R.drawable.empty_plate),
//                    contentDescription = "",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(225.dp),
//                    contentScale = ContentScale.Crop
//                )
//            }
//            post.where?.let { title ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp),
//                ) {
//                    Text(
//                        text = title,
//                        modifier = Modifier
//                            .fillMaxWidth(fraction = 1.0f)
//                            .wrapContentWidth(Alignment.Start),
//                        style = MaterialTheme.typography.labelMedium
//
//                    )
//                }
//            }
//            post.message?.let{
//                Text(
//                    text = it,
//                    modifier = Modifier
//                        .padding(8.dp),
//                    style = MaterialTheme.typography.bodyMedium)
//
//            }
//        }
//    }
//}


//
//@Composable
//fun ListItem(item: LauncherActivity.ListItem) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(4.dp)
//            .height(60.dp)
//            .background(color = Color.Gray)
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(horizontal = 8.dp)
//                .fillMaxWidth()
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                contentDescription = "user icon",
//                modifier = Modifier
//                    .padding(horizontal = 8.dp)
//                    .align(CenterVertically)
//            )
//            Text(
//                modifier = Modifier
//                    .padding(horizontal = 16.dp)
//                    .align(CenterVertically),
//                text = item.name,
//                color = Color.White,
//                fontSize = 16.sp
//            )
//        }
//    }
//}