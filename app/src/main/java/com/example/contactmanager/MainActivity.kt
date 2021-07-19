package com.example.contactmanager

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContactCallBack,FragmentDeleteEdit.CallbackContactDeleteEdit {

    private lateinit var recv: RecyclerView
    lateinit var contactList: ArrayList<Contact>
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contactList = ArrayList()
        recv = findViewById(R.id.recycler)
        adapter = ContactAdapter(contactList, this, this)
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = adapter





        btAddContact.setOnClickListener { (addContact()) }

    }

    private fun addContact() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_contact, null)

        val contactName = v.findViewById<EditText>(R.id.etContactName)
        val contactLastName = v.findViewById<EditText>(R.id.edLastName)
        val contactEmail = v.findViewById<EditText>(R.id.edEmail)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val name = contactName.text.toString()
            val avatar = BitmapFactory.decodeResource(resources, R.drawable.icons8_avatar_100)
            val lastName = contactLastName.text.toString()
            val email = contactEmail.text.toString()
            contactList.add(
                Contact(
                    avatar = avatar,
                    "Name. : $name",
                    "LastName : $lastName",
                    "Email : $email"
                )
            )
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Adding User Information Success", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()

    }

    override fun itemContactSelected(index: Int) {
        val contact = contactList[index]
        val indexAdapter = index
        supportFragmentManager.beginTransaction()
            .add(R.id.frame, FragmentDeleteEdit.newInstance(contact,indexAdapter))
            .addToBackStack(null).commit()
    }

    override fun deleteContact(index: Int) {
        TODO("Not yet implemented")
        contactList.removeAt(index)
    }
}