/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.jensklingenberg.jetpackcomposeplayground.ui.samples.androidx.ui.text


import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.TextField
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.layout.Column
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.ExpandedHeight
import androidx.ui.text.TextStyle

val KEYBOARD_TYPES = listOf(
    Pair(KeyboardType.Text, "Text"),
    Pair(KeyboardType.Ascii, "Ascii"),
    Pair(KeyboardType.Number, "Number"),
    Pair(KeyboardType.Email, "Email"),
    Pair(KeyboardType.Phone, "Phone"),
    Pair(KeyboardType.Password, "Password"),
    Pair(KeyboardType.NumberPassword, "NumberPassword")
)

val IME_ACTIONS = listOf(
    Pair(ImeAction.Unspecified, "Unspecified"),
    Pair(ImeAction.NoAction, "NoAction"),
    Pair(ImeAction.Go, "Go"),
    Pair(ImeAction.Search, "Search"),
    Pair(ImeAction.Send, "Send"),
    Pair(ImeAction.Next, "Next"),
    Pair(ImeAction.Done, "Done"),
    Pair(ImeAction.Previous, "Previous")
)

@Composable
fun InputFieldDemo() {
    VerticalScroller {
        Column(ExpandedHeight) {
            TagLine(tag = "simple editing")
            EditLine()
            TagLine(tag = "simple editing2")
            EditLine()

            for ((type, name) in KEYBOARD_TYPES) {
                TagLine(tag = "Keyboard Type: $name")
                EditLine(keyboardType = type)
            }

            for ((action, name) in IME_ACTIONS) {
                TagLine(tag = "Ime Action: $name")
                EditLine(imeAction = action)
            }
        }
    }
}

@Composable
fun EditLine(
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Unspecified
) {
    val state = +state { "" }
    TextField(
        value = state.value,
        keyboardType = keyboardType,
        imeAction = imeAction,
        onValueChange = { state.value = it },
        textStyle = TextStyle(fontSize = fontSize8)
    )
}
