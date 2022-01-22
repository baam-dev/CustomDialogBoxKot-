package dev.baam.customalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingBtn.setOnClickListener {
            setupPickers()

            // inflate the created layout
            val dialogView = LayoutInflater.from(this).inflate(R.layout.alert_view, null)

            // AlertDialogBuilder
            val builder = AlertDialog.Builder(this).setView(dialogView).setTitle("Add new item")

            // Show the dialog
            val alertDialog = builder.show()

        }

    }

    private fun setupPickers () {
        val grades = arrayOf("A", "B", "C", "D", "E", "F")
        val credits = arrayOf("50", "100", "150", "200", "300")
        gradePicker.minValue = 0
        gradePicker.maxValue = grades.size - 1
        gradePicker.displayedValues = grades

        creditPicker.minValue = 0
        creditPicker.maxValue = credits.size - 1
        creditPicker.displayedValues = credits

        gradePicker.setOnValueChangedListener { numberPicker, oldValue, newValue -> gradeValue.text = "$newValue" }
        creditPicker.setOnValueChangedListener { numberPicker, oldValue, newValue -> creditValue.text = "$newValue" }
    }
}


