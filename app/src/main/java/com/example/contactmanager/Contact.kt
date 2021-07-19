package com.example.contactmanager

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.Serializable

class Contact(
    var avatar:Bitmap?,
    var contactName:String,
    var contactLastName:String,
    var contactEmail:String,
    ) :Serializable
