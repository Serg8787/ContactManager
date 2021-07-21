package com.example.contactmanager

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_all_view.*
import java.lang.ref.PhantomReference


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAllView.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAllView : Fragment() {
    lateinit var name:String
    lateinit var lastName:String
    lateinit var email:String
    lateinit var phone:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvNameAllView.text = name
        tvLastNameAllView.text = lastName
        tvEmailAllView.text = email
        tvPhoneAlliew.text = phone
    }

    companion object {
        @JvmStatic
        fun newInstance(contact: Contact) =
            FragmentAllView().apply {
                name = contact.name.toString()
                lastName = contact.lastName.toString()
                email = contact.email.toString()
                phone = contact.phone.toString()
            }

    }
}