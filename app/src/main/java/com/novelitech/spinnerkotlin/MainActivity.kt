package com.novelitech.spinnerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.novelitech.spinnerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // The function attribute that handles the selected item needs to be a object class extending OnItemSelectedListener
        binding.spMonths.onItemSelectedListener = object : OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // If I put just "this" it will get the reference from the object class
                Toast.makeText(
                    this@MainActivity,
                    "You selected ${parent?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }

        // If I needed to fetch data lately in a Spinner, I'll do as below
        val customList = listOf("First", "Second", "Third", "Fourth")
        val adapter = ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, customList)
        binding.spFetchLater.adapter = adapter

        binding.spFetchLater.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "You selected ${parent?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) { }

        }
    }
}