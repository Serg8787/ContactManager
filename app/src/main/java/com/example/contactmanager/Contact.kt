package com.example.contactmanager

import android.graphics.Bitmap
import java.io.Serializable

class Contact(
    var avatar: Bitmap?,
    var name: String?,
    var lastName: String?,
    var email: String?,
    var phone:String?
    ) :Serializable
