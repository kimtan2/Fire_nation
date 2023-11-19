package com.example.firenation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firenation.data.Datasource
import com.example.firenation.model.Personen
import com.example.firenation.ui.theme.FireNationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FireNationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FireNationApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {

    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding (top = 50.dp)
            ) {

                Image (
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(1f)


                        .padding(dimensionResource(id = R.dimen.images))
                        .clip(MaterialTheme.shapes.small)

                        .weight(1f),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id = R.string.logo_name),
                    style = MaterialTheme.typography.titleLarge,


                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FireNationApp() {
    var personenListe = Datasource.getPersonenListe()
    Scaffold (
        topBar = { TopAppBar() }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(personenListe) { personen ->
                PersonItem(personen = personen, modifier = Modifier.padding(10.dp))
            }
        }

    }
}




@Composable
fun PersonItem(personen: Personen, modifier: Modifier = Modifier) {


    var expanded by remember { mutableStateOf(false) }


    Card(modifier = modifier) {

        Column(
             modifier = Modifier
                 .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                CustomIcon(
                    icon = personen.imageResourceId,
                    modifier = Modifier
                        .weight(1f)
                )
                Information(
                    name = personen.stringResourceId,
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                )

                ItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },


                    )

            }

            if (expanded) {
                PersonBeschreibung(
                    beschreibung = personen.beschreibungPerson,
                    modifier = Modifier
                        .padding(3.dp)

                )
            }


        }


    }
}


@Composable
fun CustomIcon(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(icon),
        contentDescription = null,
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp)
            .clip(MaterialTheme.shapes.small)
            .aspectRatio(1f),

        // Add this line ,

        contentScale = ContentScale.Crop
    )
}



@Composable
fun Information(
    @StringRes name: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = name),
            style = MaterialTheme.typography.titleLarge

        )
    }
}

 @Composable
fun ItemButton(
     expanded: Boolean,
     onClick: () -> Unit,
     modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier

    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }

}

@Composable
fun PersonBeschreibung(
    @StringRes beschreibung: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = beschreibung),
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    FireNationTheme {
        FireNationApp()
    }
}