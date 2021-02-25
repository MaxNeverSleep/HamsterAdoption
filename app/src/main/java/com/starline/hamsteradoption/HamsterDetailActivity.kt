package com.starline.hamsteradoption

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.scaleMatrix
import com.starline.hamsteradoption.ui.theme.HamsterAdoptionTheme

val hamsterAae = arrayOf(
    "3 months",
    "4 months",
    "1 year 4 months",
    "2 years",
    "3 months",
    "5 months",
    "7 months",
    "1 1moneths",
    "1 months",
    "3 months",
    "8 months",
    "1 months",
)

class HamsterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra("HAMSTER_NAME")
        val desc = intent.getStringExtra("HAMSTER_DESC")
        var detailImage1: Int = 0
        var detailImage2: Int = 0
        var age: String = "1 months"
        when (name) {
            "Sussy" -> {
                detailImage1 = R.mipmap.hamster_preview_1
                detailImage2 = R.mipmap.hamster_1_1
                age = "1 months"
            }
            "Jack" -> {
                detailImage1 = R.mipmap.hamster_preview_2
                detailImage2 = R.mipmap.hamster_2_1
                age = "3 months"
            }
            "David" -> {
                detailImage1 = R.mipmap.hamster_preview_3
                detailImage2 = R.mipmap.hamster_3_1
                age = "6 months"
            }
            "Stephen" -> {
                detailImage1 = R.mipmap.hamster_preview_4
                detailImage2 = R.mipmap.hamster_4_1
                age = "4 months"
            }
            "Kiro" -> {
                detailImage1 = R.mipmap.hamster_preview_5
                detailImage2 = R.mipmap.hamster_5_1
                age = "2 months"
            }
            "Warden" -> {
                detailImage1 = R.mipmap.hamster_preview_6
                detailImage2 = R.mipmap.hamster_6_1
                age = "4 months"
            }
            "Love" -> {
                detailImage1 = R.mipmap.hamster_preview_7
                detailImage2 = R.mipmap.hamster_7_1
                age = "2 months"
            }
            "Cookie" -> {
                detailImage1 = R.mipmap.hamster_preview_8
                detailImage2 = R.mipmap.hamster_8_1
                age = "5 months"
            }
            "Hamster007" -> {
                detailImage1 = R.mipmap.hamster_preview_9
                detailImage2 = R.mipmap.hamster_5_1
                age = "4 months"
            }
            "SweetHamster" -> {
                detailImage1 = R.mipmap.hamster_preview_10
                detailImage2 = R.mipmap.hamster_4_1
                age = "6 months"
            }
            "Lam" -> {
                detailImage1 = R.mipmap.hamster_preview_11
                detailImage2 = R.mipmap.hamster_1_1
                age = "7 months"
            }
            "Pinkie" -> {
                detailImage1 = R.mipmap.hamster_preview_12
                detailImage2 = R.mipmap.hamster_6_1
                age = "12 months"
            }
        }
        setContent {
            HamsterAdoptionTheme {
                MyDetail(name, age, detailImage1, detailImage2, { back() })
            }
        }

    }
    private fun back() {
        Log.i("test", "finish  activity结束")
        super.finish()
    }
}

@Composable
fun MyDetail(
    name: String?,
    age: String?,
    detailImage1: Int,
    detailImage2: Int,
    onClick: () -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onClick }) {
                        Icon(Icons.Filled.ArrowBack, "back")
                    }
                },
                title = {
                    Text(
                        text = "$name's Detail",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
            Row {
                Image(
                    painter = painterResource(id = detailImage1),
                    contentDescription = name,
                    Modifier
                        .width(180.dp)
                        .height(180.dp)
                        .padding(30.dp, 30.dp),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Name : $name\r\n\nAge : $age\r\n\nDistance : 4.5km",
                    Modifier.padding(top = 40.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            Text(
                text = "$name ,she’s really light for a dwarf, do not mistake her weight for her looks as when she arrived, she looks a lil preggie ...Turns out after 4 weeks, she just has a food baby and big hips (yes #bodygoals) Therefore, pls give Wheelington a chance even if you’re looking for a round hammy, light hams can be chonky too!",
                Modifier.padding(horizontal = 30.dp, vertical = 10.dp),
                style = MaterialTheme.typography.body2
            )
            Image(
                painter = painterResource(id = detailImage2),
                contentDescription = name,
                Modifier
                    .width(400.dp)
                    .height(280.dp)
                    .padding(30.dp, 30.dp),
                contentScale = ContentScale.FillBounds

            )
        }
    }
}


