package de.jensklingenberg.jetpackcomposeplayground.ui.samples.mysamples.other

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.material.AlertDialog
import androidx.ui.material.AlertDialogButtonLayout
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme

@Composable
fun AlertDialogSample() {
    MaterialTheme {
        Column {
            val openDialog = +state { false }

            Button("Click me", onClick = {
                openDialog.value = true
            })

            if (openDialog.value) {
                AlertDialog(
                    onCloseRequest = {
                        // In this example we allow the dialog to be closed by other actions
                        // such as taping outside or pressing the back button.
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Dialog Title")
                    },
                    text = {
                        Text("Here is a text ")
                    },
                    confirmButton = {
                        Button(
                            "This is the Confirm Button",
                            onClick = {
                                openDialog.value = false
                            })
                    },
                    dismissButton = {
                        Button(
                            "This is the dismiss Button",
                            onClick = {
                                openDialog.value = false
                            })
                    },
                    buttonLayout = AlertDialogButtonLayout.Stacked
                )
            }
        }

    }
}