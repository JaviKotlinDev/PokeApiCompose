package es.javiKotlinDev.pokeapicompose.ui.customs.buttoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import es.javiKotlinDev.pokeapicompose.ui.theme.dark
import es.javiKotlinDev.pokeapicompose.ui.theme.darkGray

@Composable
fun MenuButton(
    modifier: Modifier,
    text: String,
    imageResId: Int,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = darkGray,
        ),
        border = BorderStroke(1.dp, dark),
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
            .aspectRatio(1f) // Se ajusta al espacio posible
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally),
            )
        }
    }
}