package com.example.starwars.starwarslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.starwars.R
import com.example.starwars.data.models.StarwarsListEntry
import com.example.starwars.ui.theme.RobotoCondensed

@Composable
fun StarwarsListScreen(
    navController: NavController
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(R. mipmap.ic_launcher_starwars_foreground),
                contentDescription = "Starwars",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)

            )
            SearchBar (
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

            }
            Spacer(modifier = Modifier.height(16.dp))
            StarwarsList(navController = navController)
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = it != FocusState.Active
                }
        )
        if(isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun StarwarsList(
    navController: NavController,
    viewModel: StarwarsListViewModel = hiltNavGraphViewModel()
) {
    val starwarsList by remember { viewModel.starwarsCategory }
    val loadError by remember { viewModel.loadError}
    val isLoading by remember { viewModel.isLoading }

    Column(modifier = Modifier.padding(16.dp)) {
        val itemCount = if (starwarsList.size % 2 == 0 ){
            starwarsList.size / 2
        } else {
           starwarsList.size / 2 + 1
        }
        viewModel.loadStarwarsPaginated()

        for (i in 1..itemCount) {
            StarwarsRow(rowIndex = i, entries = starwarsList, navController = navController)
        }

    }
}

@Composable
fun StarwarsEntry(
    entry: StarwarsListEntry,
    navController: NavController,
    modifier: Modifier = Modifier,
//    viewModel: StarwarsListViewModel = hiltNavGraphViewModel()
) {
    Box(
        contentAlignment = Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .clickable {
                navController.navigate(
                    "category_list_screen/${entry.categoryName}"
                )
            }
    ) {
        Column {
            Text(
                text = entry.categoryName,
                fontFamily = RobotoCondensed,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()

            )
        }
    }
}

@Composable
fun StarwarsRow(
    rowIndex: Int,
    entries: List<StarwarsListEntry>,
    navController: NavController
) {
    Column {
        Row {
            StarwarsEntry(
                entry = entries[rowIndex * 2],
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if(entries.size >= rowIndex * 2+2) {
                StarwarsEntry(
                    entry = entries[rowIndex * 2+1],
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}



