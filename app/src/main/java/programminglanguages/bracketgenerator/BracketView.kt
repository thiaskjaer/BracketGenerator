package programminglanguages.bracketgenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class BracketView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bracket_view)

        //The LinearLayout that allows buttons and such to be added
        val linear = findViewById<LinearLayout>(R.id.Linear)

        //receiving the intent containing the names as a StringArrayList
        val names = intent.getStringArrayListExtra("Names")

        //an ArrayList to contain buttons that will be used as the people's position in a bracket
        val buttons = ArrayList<Button>()

        //a loop for populating the screen and buttons ArrayList with buttons with the competitors names
        for(name in names){
            val newButton = Button(this)
            newButton.setText(name)
            linear.addView(newButton)
            buttons.add(newButton)
        }

        //Test toast to test if the names have been transferred correctly
        Toast.makeText(this, names.last(), Toast.LENGTH_SHORT).show()


    }
}
