package com.mmaquera.netgame.view.login.signin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mmaquera.netgame.R
import com.mmaquera.netgame.ui.theme.WhiteSmoke
import com.mmaquera.netgame.view.login.collectWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun LoginScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    goToMainScreen: () -> Unit
) {
    HandlerEvents(effect = viewModel.effect, goToMainScreen = goToMainScreen)
    val content = LocalContext.current
    val uiState: SignInUiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        SignInUiState.Render -> {
            RenderLogIn { userName, password ->
                viewModel.signInIntent(SignInIntent.SignIn(userName, password))
            }
        }
        SignInUiState.Authenticate -> {
            viewModel.goToMainEvent(SignInEffect.GoToMain)
        }
        is SignInUiState.Error -> {
            val message = (uiState as SignInUiState.Error).message
            Toast.makeText(content, message, Toast.LENGTH_SHORT).show()
        }
        SignInUiState.ShowLoading -> {
            Loading()
        }
        SignInUiState.UnAuthorized -> {
            RenderLogIn { userName, password ->
                viewModel.signInIntent(SignInIntent.SignIn(userName, password))
            }
            Toast.makeText(content, "UnAuthorized", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
private fun HandlerEvents(effect: Flow<SignInEffect>, goToMainScreen: () -> Unit) {
    effect.collectWithLifecycle {
        when (it) {
            SignInEffect.GoToMain -> goToMainScreen.invoke()
        }
    }
}

@Composable
private fun RenderLogIn(
    signInOnClick: (userName: String, password: String) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteSmoke)
    ) {
        val (image, box, signInText, signUpText, dividerTop, divider, userTextField, passwordTextField, signInButton) = createRefs()
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
        Divider(
            modifier = Modifier
                .constrainAs(dividerTop) {
                    bottom.linkTo(guideline)
                }
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topStartPercent = 100,
                        topEndPercent = 100,
                        bottomEndPercent = 0,
                        bottomStartPercent = 0
                    )
                ),
            color = MaterialTheme.colors.secondary,
            thickness = 8.dp
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
            .background(MaterialTheme.colors.primary)) {

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
                    color = WhiteSmoke)
                Text(
                    modifier = Modifier
                        .constrainAs(signUpText) {
                            start.linkTo(verticalMiddleGuideLine)
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        }
                        .height(45.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = stringResource(id = R.string.sign_up), color = WhiteSmoke
                )
                Divider(
                    modifier = Modifier
                        .constrainAs(divider) {
                            top.linkTo(signUpText.bottom)
                            start.linkTo(verticalMiddleGuideLine)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                        .clip(
                            RoundedCornerShape(
                                topStartPercent = 40,
                                topEndPercent = 0,
                                bottomEndPercent = 100,
                                bottomStartPercent = 40
                            )
                        ),
                    color = MaterialTheme.colors.secondary,
                    thickness = 8.dp,
                )
                val barrier = createBottomBarrier(signInText, divider)
                val buttonBarrier = createBottomBarrier(passwordTextField)

                var username by rememberSaveable { mutableStateOf("") }
                var password by rememberSaveable { mutableStateOf("") }
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
                        focusedBorderColor = WhiteSmoke,
                        unfocusedBorderColor = WhiteSmoke,
                        cursorColor = WhiteSmoke
                    ),
                    value = username,
                    label = {
                        Text(
                            text = stringResource(id = R.string.username),
                            color = WhiteSmoke
                        )
                    },
                    onValueChange = { username = it }
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
                        focusedBorderColor = WhiteSmoke,
                        unfocusedBorderColor = WhiteSmoke,
                        cursorColor = WhiteSmoke
                    ),
                    value = password,
                    label = {
                        Text(
                            text = stringResource(id = R.string.password),
                            color = WhiteSmoke
                        )
                    },
                    onValueChange = { password = it }
                )
                Button(modifier = Modifier
                    .constrainAs(signInButton) {
                        top.linkTo(buttonBarrier)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(top = 20.dp)
                    .width(300.dp)
                    .height(60.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    onClick = { signInOnClick(username, password) }
                ) {
                    Text(
                        color = Color.White,
                        style = MaterialTheme.typography.body1,
                        text = stringResource(id = R.string.log_in)
                    )
                }
            }
        }
    }
}

@Composable
private fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}