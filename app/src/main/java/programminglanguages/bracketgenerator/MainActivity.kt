package programminglanguages.bracketgenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //The add name button
        val addNameButton = findViewById<Button>(R.id.AddName)

        //The layout containing the button and textfields
        val linear = findViewById<LinearLayout>(R.id.Linear)



        //a list to keep track of the textfields
        val nameList = mutableListOf<EditText>()

        //adds the first textfield when constructed
        val firstText = EditText(this)
        firstText.setText("Name")
        linear.addView(firstText)
        nameList.add(firstText)

        //The method for the addNameButton
        //Adds a new textfield underneath the previous textfield
        addNameButton.setOnClickListener {
            val newText = EditText(this)
            newText.setText("Name")
            linear.addView(newText)
            nameList.add(newText)
        }
    }
}
