package es.javiKotlinDev.pokeapicompose.ui.customs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.javiKotlinDev.pokeapicompose.ui.theme.Pink40
import es.javiKotlinDev.pokeapicompose.ui.theme.Purple80

@Composable
fun AcceptButton() {
    CustomAcceptButton(
        title = "Empecemos!",
        onClick = { /*TODO*/ }
    )
}

@Composable
private fun CustomAcceptButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
   Box(
       modifier = modifier
           .background(Pink40)
           .padding(20.dp)
           .wrapContentSize() // wrap content height and width
   ) {
       Button(
           onClick = { /*TODO*/ },
           colors = buttonColors(
               containerColor = Purple80,
               disabledContainerColor = Color.Red,
               disabledContentColor = Color.Green
           ),
           modifier = modifier
       ) {
           onClick()
           Text(
               text = title,
               color = Color.Black
           )

       }
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AcceptButtonPreview() {
    Box {
        AcceptButton()
    }

}