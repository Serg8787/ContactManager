package com.example.contactmanager

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_delete_edit.*



/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDeleteEdit.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDeleteEdit(val callback:CallbackContactDeleteEdit) : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var name:String
    lateinit var lastName:String
    lateinit var email:String
    lateinit var avatar: Bitmap
     var position: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvNameFragment.text = name
        tvLastNameFragment.text = lastName
        tvEmailFragment.text = email
        ivAvatarFragment.setImageBitmap(avatar)






        btDeleteFragment.setOnClickListener{
                 val builder = AlertDialog.Builder(context)
                  builder.setTitle("Delete contact")
            builder.setMessage("Deleting a contact will delete important information! \nBe careful!")
            builder.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->

                val intent = Intent(context,MainActivity::class.java)
                in
                startActivity(intent)
            })
            builder.setNegativeButton("NO",DialogInterface.OnClickListener { dialog, which ->  })
            builder.show()
        }

        btEditFragment.setOnClickListener{


        }

    }

    companion object {
        @JvmStatic
        fun newInstance(contact: Contact, indexAdapter: Int) =
            FragmentDeleteEdit().apply {
                name = contact.contactName
                lastName = contact.contactLastName
                email = contact.contactEmail
                avatar = contact.avatar!!
             position = indexAdapter
            }

    }
    interface CallbackContactDeleteEdit{
      fun deleteContact(index:Int)
    }
}