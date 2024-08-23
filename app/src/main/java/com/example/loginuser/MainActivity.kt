
package com.example.loginuser

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginuser.ui.theme.LoginUserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginUserTheme {
                var currentLanguage by remember { mutableStateOf("en") }
                val context = LocalContext.current
                    LoginScreen()
                }
            }
        }
    }



@Composable
    fun LoginScreen() {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White),
        ) {


            Spacer(modifier = Modifier.height(32.dp))


            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bm_icon),
                    contentDescription = "Bank Logo",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(10.dp),
                )


                Text(
                    text = stringResource(R.string.language),
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.red),
                    modifier = Modifier
                        .padding(start = 120.dp , top = 60.dp)
                        .clickable { /* Change Language */ }

                )


            }


            Spacer(modifier = Modifier.height(18.dp))


            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(stringResource(R.string.username)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(6.dp)
            )


            Spacer(modifier = Modifier.height(20.dp))


            Row(horizontalArrangement = Arrangement.Start) {
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(stringResource(R.string.password )) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(6.dp)
                )
            }

            Text(
                text = stringResource(R.string.forgot_password),
                textDecoration = TextDecoration.Underline,
                color = Color(0xFF868585),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { /* TODO*/ }
                    .padding(20.dp)
            )


            Spacer(modifier = Modifier.height(24.dp))


            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(50.dp),
                colors = if (username.isBlank() || password.isBlank()) {
                    ButtonDefaults.buttonColors(colorResource(id = R.color.lightred))
                } else {
                    ButtonDefaults.buttonColors(Color.Red)
                },
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(text = stringResource(R.string.login), fontSize = 16.sp)
            }


            Spacer(modifier = Modifier.height(16.dp))


            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = stringResource(R.string.need),
                    textAlign = TextAlign.Start,
                )

                Text(
                    text = stringResource(R.string.contact_us),
                    color = colorResource(id = R.color.red),
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { /*TODO*/ }
                )
            }


            Spacer(modifier = Modifier.height(10.dp))


            Row(horizontalArrangement = Arrangement.SpaceBetween,) {

                Icon(icon = R.drawable.our_products, text = stringResource(R.string.our_products))
                Icon(icon = R.drawable.exchange_rate, text = stringResource(R.string.exchange_rate))
                Icon(icon = R.drawable.security_tips, text = stringResource(R.string.security_tips))
                Icon(icon = R.drawable.nearest_branch_or_atm, text = stringResource(R.string.nearest_atm))
            }

        }
    }


    @Composable
    fun Icon(icon: Int, text: String) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(8.dp)
                    .width(80.dp),
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }


@Preview
    @Composable
    private fun Try() {
        LoginScreen()



    }


