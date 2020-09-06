package ru.alexleru.brickseasy

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ErrorDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val build = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater

        build.setView(inflater?.inflate(R.layout.dialog_error, null))

            .setNegativeButton(
                "Закрыть"
            ) { dialogInterface, i -> dialogInterface.cancel() }

        return build.create()
    }
}