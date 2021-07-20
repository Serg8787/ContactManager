package com.example.contactmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add_contact.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAddContact.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAddContact : Fragment() {
lateinit var list:ArrayList<Contact>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btAddContactAdd.setOnClickListener {
            val name = etNameAdd.text.toString()
            val lastName = etLastNameAdd.text.toString()
            val email = etEmailAdd.text.toString()
            list.add(Contact(null,name,lastName,email))
            val intent = Intent(context,MainActivity::class.java)
            intent.putExtra("list",list)
            startActivity(intent)

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentAddContact.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(contactList: ArrayList<Contact>) =
            FragmentAddContact().apply {
                list = contactList
            }
    }
}