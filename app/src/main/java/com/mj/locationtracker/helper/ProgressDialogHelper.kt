package com.mj.locationtracker.helperr

import android.app.ProgressDialog
import android.content.Context

class ProgressDialogHelper(val context: Context) {

    var progressDialog = ProgressDialog(context)

    fun showDialog(messageResId: Int) {
        with(progressDialog) {
            setTitle(context.getString(messageResId))
            if (isShowing) {
                dismiss()
            }
            show()
        }
    }

    fun dismissDialog() {
        with(progressDialog) {
            if(isShowing) {
                dismiss()
            }
        }
    }
}