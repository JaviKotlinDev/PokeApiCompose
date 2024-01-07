package es.javiKotlinDev.pokeapicompose.ui.customs.buttoms

import android.util.Log
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
import es.javiKotlinDev.pokeapicompose.ui.theme.teal

@Composable
fun AcceptButton(onClick: () -> Unit) {
    CustomAcceptButton(
        title = "Aceptar",
        onClick = { onClick() }
    )
}

@Composable
private fun CustomAcceptButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {

    Button(
        onClick = { onClick() },
        colors = buttonColors(
            containerColor = teal,
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Green
        ),
        modifier = modifier
            .wrapContentSize()
            .padding(20.dp)
    ) {
        onClick()
        Text(
            text = title,
            color = Color.Black
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AcceptButtonPreview() {
    Box {
        AcceptButton(onClick = { clickExample() })
    }
}
private fun clickExample() {
    Log.e("onClickAceptButton", "Se ha realizado click en boton aceptar")
}