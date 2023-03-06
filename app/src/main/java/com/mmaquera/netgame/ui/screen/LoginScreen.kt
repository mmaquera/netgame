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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.mmaquera.netgame.R
import com.mmaquera.netgame.ui.theme.PineGreen
import com.mmaquera.netgame.ui.theme.StrongCyan
import com.mmaquera.netgame.ui.theme.WhiteSmoke

@Composable
//@Preview(showBackground = true)
fun LoginScreen(logInOnClick: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteSmoke)
    ) {
        val (image, box, signInText, signUpText, divider, userTextField, passwordTextField, signInButton) = createRefs()
        val guideline = createGuidelineFromTop(0.6f)
        Image(
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(guideline)
                }
                .height(180.dp)
                .width(180.dp),
            painter = painterResource(id = R.drawable.logo_netgame),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )

        Box(modifier = Modifier
            .constrainAs(box) {
                top.linkTo(guideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
            .background(StrongCyan)) {

            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val verticalMiddleGuideLine = createGuidelineFromEnd(0.5f)
                Text(
                    modifier = Modifier
                        .constrainAs(signInText) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(verticalMiddleGuideLine)
                        }
                        .height(45.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = stringResource(id = R.string.sign_in),
                    color = Color.White,

                    )
                Text(
                    modifier = Modifier
                        .constrainAs(signUpText) {
                            start.linkTo(verticalMiddleGuideLine)
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        }
                        .height(45.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = stringResource(id = R.string.sign_up), color = Color.White
                )
                Divider(
                    modifier = Modifier.constrainAs(divider) {
                        top.linkTo(signUpText.bottom)
                        start.linkTo(verticalMiddleGuideLine)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                    color = Color.White,
                    thickness = 1.dp
                )
                val barrier = createBottomBarrier(signInText, divider)
                val buttonBarrier = createBottomBarrier(passwordTextField)
                OutlinedTextField(
                    modifier = Modifier
                        .constrainAs(userTextField) {
                            top.linkTo(barrier)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(passwordTextField.top)
                        }
                        .padding(top = 15.dp, end = 20.dp, start = 20.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White
                    ),
                    value = "",
                    label = { Text(text = stringResource(id = R.string.username), color = Color.White) },
                    onValueChange = {}
                )
                OutlinedTextField(
                    modifier = Modifier
                        .constrainAs(passwordTextField) {
                            top.linkTo(userTextField.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(buttonBarrier)
                        }
                        .padding(top = 15.dp, end = 20.dp, start = 20.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White
                    ),
                    value = "",
                    label = { Text(text = stringResource(id = R.string.password), color = Color.White) },
                    onValueChange = {}
                )
                Button(modifier = Modifier
                    .constrainAs(signInButton) {
                        top.linkTo(buttonBarrier)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(top = 20.dp)
                    .width(300.dp)
                    .height(65.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = PineGreen),
                    onClick = logInOnClick) {
                    Text(color = Color.White, text = stringResource(id = R.string.log_in))
                }
            }
        }
    }
}