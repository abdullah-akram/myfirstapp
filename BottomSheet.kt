package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)


        val btnbs = findViewById<Button>(R.id.idBtnShowBottomSheet)
        btnbs.setOnClickListener(){
            val dialog = BottomSheetDialog(this)
            val view= layoutInflater.inflate(R.layout.bottom_sheet_dialog,null)
            val btnclose  = view.findViewById<Button>(R.id.idBtnDismiss)
            btnclose.setOnClickListener(){
                dialog.dismiss()
            }
            dialog.setCancelable(true)
            dialog.setContentView(view)
            dialog.show()
        }
    }
}