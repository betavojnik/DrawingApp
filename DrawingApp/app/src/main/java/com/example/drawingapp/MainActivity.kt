package com.example.drawingapp

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.dialog_brush_size.*

class MainActivity : AppCompatActivity() {

    private var drawinView : DrawingView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawinView = findViewById(R.id.drawing_view)

        drawinView!!.setBrushSize(20.toFloat())


        val btnBrush : ImageButton = findViewById(R.id.id_brush)
        btnBrush.setOnClickListener {
            showBrushSizeChooserDialog()
        }
    }
    private fun showBrushSizeChooserDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size :")
        val smallBtn = brushDialog.ib_small
        smallBtn.setOnClickListener {
            drawinView?.setBrushSize(10.toFloat())
            brushDialog.dismiss()
        }
        val mediumBtn = brushDialog.ib_medium
        mediumBtn.setOnClickListener {
            drawinView?.setBrushSize(20.toFloat())
            brushDialog.dismiss()
        }

        val largeBtn = brushDialog.ib_large
        largeBtn.setOnClickListener  {
            drawinView?.setBrushSize(30.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }

}