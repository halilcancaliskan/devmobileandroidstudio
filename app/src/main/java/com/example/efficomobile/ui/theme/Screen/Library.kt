package com.example.efficomobile.ui.theme.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.efficomobile.MainActivity
import com.example.efficomobile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Library(){
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = "Icône de profil"
                        )
                    }
                    Text(text = "Bibliothèque")
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_loupe),
                        contentDescription = "zoom"
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = "plus"
                    )
                }
            }
        )

    }, ) {
        val genre = listOf("Playlist", "Albums", "Artistes")

        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .background(Color.Black)
        ) {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                for (g in genre) {

                    items(1) {
                        FilterChip(
                            selected = false,
                            onClick = { /*TODO*/ },
                            label = { Text(
                                text = "$g",
                                color = Color.White
                            ) },
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start // Aligner les autres éléments à gauche
            ) {
                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lister),
                        contentDescription = "Trier",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Récents",
                    color = Color.White
                )
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.End // Aligner l'icône "lister" à droite
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_trier),
                            contentDescription = "Mode de la liste",
                            tint = Color.White
                        )
                    }
                }
            }

            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                repeat(6) { index ->
                    Row(modifier = Modifier.fillMaxSize()) {
                        // Image
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://m.media-amazon.com/images/I/71dFTmV2jgL._SL1440_.jpg")
                                .build(),
                            contentDescription = "Poursuivre l'écoute",
                            modifier = Modifier
                                .size(120.dp)
                                .padding(8.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(
                                text = "PNL $index",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White, // Couleur du texte
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Album . Dans la légende $index",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White, // Couleur du texte
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                    }
                }
            }

        }
    }
}