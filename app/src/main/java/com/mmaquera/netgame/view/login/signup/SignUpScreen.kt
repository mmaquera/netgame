package com.mmaquera.netgame.view.login.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.mmaquera.netgame.R

@Composable
@Preview(showBackground = true)
fun SignUpScreen(goToBack: () -> Unit = {}) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {

        val (closeImage, logoImage, text, userName, passwordTextField, confirmPasswordTextField, button) = createRefs()

        var username by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var confirmPassword by rememberSaveable { mutableStateOf("") }

        Image(
            modifier = Modifier
                .constrainAs(closeImage) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .clickable {
                    goToBack.invoke()
                },
            painter = rememberVectorPainter(image = Icons.Default.Close),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .padding(top = 40.dp, bottom = 40.dp)
                .constrainAs(logoImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(text.top)
                }
                .height(180.dp)
                .width(180.dp),
            painter = painterResource(id = R.drawable.logo_netgame),
            contentDescription = null
        )
        Text(
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(logoImage.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(userName.top)
                },
            text = "Registro"
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .constrainAs(userName) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(passwordTextField.top)
                }
                .fillMaxWidth(),
            value = username,
            label = {
                Text(
                    text = stringResource(id = R.string.username)
                )
            },
            onValueChange = { username = it }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .constrainAs(passwordTextField) {
                    top.linkTo(userName.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(confirmPasswordTextField.top)
                }
                .fillMaxWidth(),
            value = password,
            label = {
                Text(
                    text = "Contraseña"
                )
            },
            onValueChange = { password = it }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .constrainAs(confirmPasswordTextField) {
                    top.linkTo(passwordTextField.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            value = confirmPassword,
            label = {
                Text(
                    text = "Confirmar contraseña"
                )
            },
            onValueChange = { confirmPassword = it }
        )
        Button(
            modifier = Modifier
                .constrainAs(button) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .width(300.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            onClick = {}) {
            Text(
                color = Color.White,
                style = MaterialTheme.typography.body1,
                text = "Crear cuenta"
            )
        }
    }
}