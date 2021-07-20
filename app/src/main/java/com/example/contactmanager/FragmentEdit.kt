package com.example.contactmanager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_contact.*
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var list:ArrayList<Contact>
var position by Delegates.notNull<Int>()

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentEdit.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentEdit : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btAddContactEdit.setOnClickListener {
            val name = etNameEdit.text.toString()
            val lastName = etLastNameEdit.text.toString()
            val email = etEmailEdit.text.toString()
            list[position].name = name
            list[position].lastName = lastName
            list[position].email = email
            list[position].avatar = null
            val intent1 = Intent(context,MainActivity::class.java)
            intent1.putExtra("listEdit",list)
            startActivity(intent1)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(contactList: ArrayList<Contact>, index: Int) =
            FragmentEdit().apply {

                list = contactList
                position = index
            }
    }
}