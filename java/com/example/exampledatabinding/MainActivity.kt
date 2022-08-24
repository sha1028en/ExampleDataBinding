package com.example.exampledatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.exampledatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.bind = DataBindingUtil.setContentView( this, R.layout.activity_main)
        this.bind.state =
            if ( this.bind.ActivityMainCntTxtview.text.isNullOrBlank()) { State( "0") }
            else { State( this.bind.state!!.cnt) }
    }

    fun onClick( v: View){
        when( v.id) {

            R.id.ActivityMain_addCntBtn -> { this.bind.state = State( this.bind.state!!.getAddedStringCnt()) }
        }
    }
}