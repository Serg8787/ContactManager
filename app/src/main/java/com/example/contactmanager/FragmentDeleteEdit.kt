package com.example.contactmanager

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_delete_edit.*
import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDeleteEdit.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDeleteEdit() : Fragment() {
    // TODO: Rename and change types of parameters
    var position by Delegates.notNull<Int>()
    lateinit var name: String
    lateinit var lastName: String
    lateinit var email: String
    lateinit var avatar: Bitmap
    lateinit var contctFarg:Contact
    lateinit var listContact: ArrayList<Contact>


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
        Log.i("postion", position.toString())
        tvCountFragment.text = position.toString()






        btDeleteFragment.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete contact")
            builder.setMessage("Deleting a contact will delete important information! \nBe careful!")
            builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
//             MainActivity().deleteItem(contctFarg)
                MainActivity().contactList.removeAt(position)
                MainActivity().recycler.adapter




            })
            builder.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which -> })
            builder.show()
        }

        btEditFragment.setOnClickListener {


        }

    }

    companion object {
        @JvmStatic
        fun newInstance(contact: Contact, indexAdapter: Int) =
            FragmentDeleteEdit().apply {

            }

    }

}