package dev.baam.customalertdialog

import android.app.Dialog
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingBtn.setOnClickListener {

          val dialog = Dialog(this)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.alert_view)
            setupPickers(dialog)

            dialog.show()
        }
    }

    private fun setupPickers (dialog: Dialog) {
        val grades = arrayOf("A", "B", "C", "D", "E", "F")
        val credits = arrayOf("100", "150", "200", "300", "50")

        var selectedGrade = grades[0]
        var selectedCredit = credits[0]

        dialog.apply {
            gradePicker.minValue = 0
            gradePicker.maxValue = grades.size - 1
            gradePicker.displayedValues = grades

            creditPicker.minValue = 0
            creditPicker.maxValue = credits.size - 1
            creditPicker.displayedValues = credits

            gradePicker.setOnValueChangedListener { numberPicker, oldValue, newValue -> selectedGrade = "${grades[newValue]}" }
            creditPicker.setOnValueChangedListener { numberPicker, oldValue, newValue -> selectedCredit = "${credits[newValue]}" }

            btnCancel.setOnClickListener {
                dismiss()
            }
        }
        dialog.btnAdd.setOnClickListener {
            var name = dialog.courseName.text.toString()
            if (name != "") {
                courseDisplayTitle.text = name
                gradeValue.text = selectedGrade
                creditValue.text = selectedCredit
                dialog.dismiss()
            }
        }
    }

}


