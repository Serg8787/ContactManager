package com.example.contactmanager

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add_contact.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAddContact.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAddContact : Fragment() {
lateinit var list:ArrayList<Contact>
    val GALLERY_REQUEST = 1
    val PICK_IMAGE = 100
    val PICK_IMAGE2 = 101
    lateinit var bitmap:Bitmap



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
        ivAvatarAdd.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, PICK_IMAGE)

            Toast.makeText(context,"Зашли в галерию",Toast.LENGTH_LONG).show()
        }


        btAddContactAdd.setOnClickListener {

            val bitmap:Bitmap = BitmapFactory.decodeResource(resources,R.drawable.icons8_two_points_48dp_green)
            val name = etNameAdd.text.toString()
            val lastName = etLastNameAdd.text.toString()
            val email = etEmailAdd.text.toString()
            val phone = etPhoneAdd.text.toString()

            list.add(Contact(avatar = null, name = name,lastName,email,phone))
            val intent = Intent(context,MainActivity::class.java)
            intent.putExtra("list",list)
            startActivity(intent)

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(contactList: ArrayList<Contact>) =
            FragmentAddContact().apply {
                list = contactList

            }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== PICK_IMAGE && resultCode== AppCompatActivity.RESULT_OK){
            val imageUri = data?.data
            bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver,imageUri)
            ivAvatarAdd.setImageBitmap(bitmap)

        }
    }

    }
