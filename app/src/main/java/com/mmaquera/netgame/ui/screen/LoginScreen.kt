package com.mmaquera.netgame.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmaquera.netgame.R
import com.mmaquera.netgame.ui.theme.PineGreen
import com.mmaquera.netgame.ui.theme.StrongCyan
import com.mmaquera.netgame.ui.theme.WhiteSmoke

@Composable
//@Preview(showBackground = true)
fun LoginScreen(loginClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = WhiteSmoke),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .height(180.dp)
                        .width(180.dp),
                    painter = painterResource(id = R.drawable.logo_netgame),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = StrongCyan)
            ) {
                Column() {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Ingresar", color = Color.White)
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Registrar", color = Color.White)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.weight(1f)) {

                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Divider(
                                color = Color.White,
                                thickness = 1.dp
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(top = 15.dp, end = 20.dp, start = 20.dp)
                                .fillMaxWidth(),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = Color.White
                            ),
                            value = "",
                            label = { Text(text = "Ususario", color = Color.White) },
                            onValueChange = {})
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(top = 15.dp, end = 20.dp, start = 20.dp)
                                .fillMaxWidth(),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = Color.White
                            ),
                            value = "",
                            label = { Text(text = "Contraseña", color = Color.White) },
                            onValueChange = {})
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(modifier = Modifier
                            .padding(top = 48.dp)
                            .width(300.dp)
                            .height(65.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = PineGreen),
                            onClick = loginClick) {
                            Text(color = Color.White, text = "Iniciar session")
                        }
                    }
                }
            }
        }
    }
}