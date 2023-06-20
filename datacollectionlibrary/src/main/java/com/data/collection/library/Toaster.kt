package com.data.collection.library

import android.content.Context
import android.widget.Toast

 object Toaster {
     fun simpleToast(context: Context, message:String){
        Toast.makeText(context, "This is simple toast", Toast.LENGTH_SHORT).show()
    }
}