@file:Suppress("KDocUnresolvedReference")

package de.jensklingenberg.jetpackcomposeplayground.ui.samples.mysamples.layout

import androidx.compose.Composable
import androidx.compose.unaryPlus

import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.FlexColumn

import androidx.ui.material.MaterialTheme

@Composable
        /**
         * @see wiki [https://github.com/Foso/Jetpack-Compose-Playground/wiki/VerticalScroller]
         */
fun VerticalScrollerDemo() {

    MaterialTheme {
        FlexColumn {
            VerticalScrollerExample()
        }
    }

}

@Composable
fun VerticalScrollerExample() {
    VerticalScroller {
        //Only one child is allowed in a VerticalScroller
        Column {
            for (i in 0..100) {
                Text(text = "$i Hello World!", style =(+MaterialTheme.typography()).body1)
            }
        }
    }
}