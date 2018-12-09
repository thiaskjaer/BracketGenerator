package programminglanguages.bracketgenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class BracketView : AppCompatActivity() {
    //an ArrayList of buttons for the winners of games
    private val winnerButtons = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bracket_view)

        //The LinearLayout that allows buttons and such to be added
        val linear = findViewById<LinearLayout>(R.id.Linear)

        //receiving the intent containing the names as a StringArrayList
        val names = intent.getStringArrayListExtra("Names")
        names.shuffle()

        //an ArrayList to contain buttons that will be used as the people's position in a bracket
        val buttons = ArrayList<Button>()

        //TODO add labels to indicate matches between buttons
        //a loop for populating the screen and buttons ArrayList with buttons with the competitors names
        //also adds textViews to indicate matches
        var counter = 0
        var matchNo = 1
        for(name in names){
            val newButton = Button(this)
            val newLabel = TextView(this)
            //adds a textView for every second button added
            if(counter.rem(2)==0){
                newLabel.text="Match " + matchNo
                linear.addView(newLabel)
                matchNo++
            }
            newButton.setText(name)
            linear.addView(newButton)
            buttons.add(newButton)
            counter+=1
        }

        //sets onClickListeners to buttons in order to get the names of the corresponding buttons and setting a winnerbutton
        for(button in buttons){
            button.setOnClickListener{
                val name = button.text.toString()
                setWinnerButtonName(name)
            }
        }



        //TODO add correct number of winnerbuttons
///////////////////////////////////////////////////////////////////TESTS///////////////////////////////////////////////
        val newButton = Button(this)
        val newButton2 = Button(this)
        linear.addView(newButton)
        linear.addView(newButton2)
        winnerButtons.add(newButton)
        winnerButtons.add(newButton2)

        //Test toast to test if the names have been transferred correctly
        //Toast.makeText(this, names.last(), Toast.LENGTH_SHORT).show()
///////////////////////////////////////////////////////////////////TESTS///////////////////////////////////////////////
    }

    //method for setting the first empty winner button to the clicked button's name
    //TODO don't infinitely loop if all winnerbuttons set
    private fun setWinnerButtonName(name: String){
        var nameNotSet = true
        var arrayIterator = 0
        while(nameNotSet){
            if(winnerButtons[arrayIterator].text==""){
                winnerButtons[arrayIterator].text=name
                nameNotSet=false
            }
            arrayIterator++
        }
    }
}
