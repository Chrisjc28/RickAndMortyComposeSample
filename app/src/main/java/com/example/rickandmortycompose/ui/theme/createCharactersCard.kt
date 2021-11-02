package com.example.rickandmortycompose.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.example.rickandmortycompose.models.Result
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CreateCharactersCard(
    result: Result,
    onClick: () -> Unit
) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable(
                onClick = onClick
            ),
        shape = RoundedCornerShape(8.dp),
        content = {
            Column {
                Row(modifier = Modifier.fillMaxWidth()) {
                    CoilImage(
                        data = result.image,
                        contentDescription = "Image of ${result.name} character from rick and morty",
                        Modifier
                            .fillMaxWidth()
                            .size(0.dp, 300.dp)
                            .padding(8.dp),
                        requestBuilder = {
                            transformations(RoundedCornersTransformation(8f))
                        }
                    )
                }

                Text(text = "Name - ${result.name}", modifier = Modifier.padding(8.dp))
                Text(
                    text = "Gender - ${result.gender}",
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Episode - ${result.episode}",
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Species - ${result.species}",
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Date created - ${result.created}",
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Origin - ${result.origin.name}",
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Current location - ${result.location.name}",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    )

}