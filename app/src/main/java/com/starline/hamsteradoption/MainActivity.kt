package com.starline.hamsteradoption

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.starline.hamsteradoption.ui.theme.HamsterAdoptionTheme

val hamsterPreviewPic = intArrayOf(
    R.mipmap.hamster_preview_1,
    R.mipmap.hamster_preview_2,
    R.mipmap.hamster_preview_3,
    R.mipmap.hamster_preview_4,
    R.mipmap.hamster_preview_5,
    R.mipmap.hamster_preview_6,
    R.mipmap.hamster_preview_7,
    R.mipmap.hamster_preview_8,
    R.mipmap.hamster_preview_9,
    R.mipmap.hamster_preview_10,
    R.mipmap.hamster_preview_11,
    R.mipmap.hamster_preview_12,
)

val hamsterNames = arrayOf(
    "Sussy",
    "Jack",
    "David",
    "Stephen",
    "Pinkie",
    "Kiro",
    "Love",
    "Warden",
    "Cookie",
    "Hamster007",
    "SweetHamster",
    "Lam",
)

val hamsterType = arrayOf(
    "White/Grey",
    "Yellow/White",
    "White",
    "Grey/White",
    "White",
    "Yellow",
    "Yellow",
    "White/Grey",
    "Grey",
    "White",
    "Yellow",
    "Grey/Yellow",
)


val hamsterDescShort = arrayOf(
    "she’s really light ...",
    "Ruffles is the ener...",
    "Evidently a speed d...",
    "Mazuri is an easygo...",
    "she’s really light ...",
    "Ruffles is the ener...",
    "Evidently a speed d...",
    "Mazuri is an easygo...",
    "she’s really light ...",
    "Ruffles is the ener...",
    "Evidently a speed d...",
    "Mazuri is an easygo..."
)



val postTime = arrayOf(
    "493m , 3 minutes ago",
    "1.4km , 14 minutes ago",
    "5km , 54 minutes ago",
    "6.7km , 8 hours ago",
    "114km , 16 hours ago",
    "12km , 18 hours ago",
    "984m , 1 days ago",
    "57km , 4 days ago",
    "1590km , 22 days ago",
    "68km , 3 months ago",
    "359km , 7 months ago",
    "9km , 1 years ago",
)


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HamsterAdoptionTheme {
                MyApp { imageResId, name -> jumpHamsterDetail(name) }
            }
        }
    }

    private fun jumpHamsterDetail(name: String) {
        startActivity(
            Intent(this, HamsterDetailActivity::class.java)
                .putExtra("HAMSTER_NAME", name)
        )
    }
}


@Composable
fun MyApp(onClick: (imageResId: Int, name: String) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = "Hamster Adoption",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
            LazyColumn(state = rememberLazyListState()) {
                items(hamsterPreviewPic.size) {
                    ListItem(it, onClick)
                }
            }
        }
    }
}

@Composable
fun ListItem(index: Int, onClick: (imageResId: Int, name: String) -> Unit) {
    Row(
        Modifier
            .height(120.dp)
            .padding(top = 5.dp)
            .fillMaxWidth(1f)
            .background(color = androidx.compose.ui.graphics.Color.White)
            .clickable { onClick(hamsterPreviewPic[index], hamsterNames[index]) }
    ) {
        Surface(
            modifier = Modifier
                .size(80.dp)
                .offset(20.dp)
                .align(Alignment.CenterVertically),
            shape = RoundedCornerShape(30),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(
                painter = painterResource(id = hamsterPreviewPic[index]),
                contentDescription = ("" + hamsterPreviewPic[index]),
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 40.dp)
                .padding(end = 30.dp)
                .align(Alignment.CenterVertically)
        ) {
            Row {
                Text(
                    hamsterNames[index],
                    Modifier.padding(top = 3.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    hamsterType[index],
                    Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 3.dp),
                    textAlign = TextAlign.End
                )
            }
            Row {
                Text(
                    hamsterDescShort[index], Modifier.padding(top = 5.dp),maxLines = 1,
                )
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Row(
                    Modifier.padding(top = 7.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
                        contentDescription = ("location")
                    )
                    Text(
                        postTime[index],
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    HamsterAdoptionTheme {
        MyApp { _, _ -> }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    HamsterAdoptionTheme(darkTheme = true) {
        MyApp { _, _ -> }
    }
}
