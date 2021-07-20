package com.example.contactmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContactCallBack {

    private lateinit var adapter: ContactAdapter
    var contactList = ArrayList<Contact>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val acontact = Contact(null,"Петя","Федор","лавы")
        contactList.add(acontact)

        val arguments = intent.extras
        if(arguments?.get("list")!=null ){
         contactList = arguments.get("list") as ArrayList<Contact>
        } else if(arguments?.get("listEdit")!= null) {
            contactList = arguments?.get("listEdit") as ArrayList<Contact>
        }

        adapter = ContactAdapter(contactList, this, this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        btAddContact.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.frameAdd, FragmentAddContact.newInstance(contactList))
                .addToBackStack(null).commit()
        }
    }

    override fun itemContactSelected(index: Int) {
        supportFragmentManager.beginTransaction()
            .add(R.id.frameEdit,FragmentEdit.newInstance(contactList,index)).addToBackStack(null).commit()

    }


}