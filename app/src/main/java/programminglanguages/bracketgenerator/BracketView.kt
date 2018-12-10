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

        //a loop for populating the screen and buttons ArrayList with buttons with the competitors names
        //also adds textViews to indicate matches
        var counter = 0
        var matchNo = 1
        var unevenWinner = 0
        for(name in names){
            val newButton = Button(this)
            val newLabel = TextView(this)
            //adds a textView for every second button added
            if(counter.rem(2)==0 && counter!=names.lastIndex){
                newLabel.text="Match " + matchNo
                linear.addView(newLabel)
                matchNo++
            }
            //if there is an uneven amount of players, a winner label is set
            else if(counter.rem(2)==0 && counter==names.lastIndex){
                newLabel.text="Winner Match "
                linear.addView(newLabel)
                unevenWinner++
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

        //setup winner buttons and labels depending on even or uneven amounts of players
        var winnerAmount = names.size-2
        if(names.size.rem(2)==0) {
            for (i in 1..winnerAmount) {
                if (i.rem(2) == 1) {
                    val newLabel = TextView(this)
                    newLabel.text = "Winner Match "
                    linear.addView(newLabel)
                }
                val newButton1 = Button(this)
                linear.addView(newButton1)
                winnerButtons.add(newButton1)
            }
        }else{
            for (i in 1..(winnerAmount-1)) {
                if(i==1){
                    val newButton1 = Button(this)
                    linear.addView(newButton1)
                    winnerButtons.add(newButton1)
                }
                if (i.rem(2) == 1) {
                    val newLabel = TextView(this)
                    newLabel.text = "Winner Match "
                    linear.addView(newLabel)
                }
                val newButton1 = Button(this)
                linear.addView(newButton1)
                winnerButtons.add(newButton1)
            }
        }

        //sets onclicklisteners for the winnerbuttons
        for(button in winnerButtons){
            button.setOnClickListener{
                val name = button.text.toString()
                setWinnerButtonName(name)
            }
        }

        //make a champion button and label
        val newLabel = TextView(this)
        newLabel.text="Champion "
        linear.addView(newLabel)
        val newButton1 = Button(this)
        linear.addView(newButton1)
        winnerButtons.add(newButton1)

    }

    //method for setting the first empty winner button to the clicked button's name
    private fun setWinnerButtonName(name: String){
        var nameNotSet = true
        var arrayIterator = 0
        while(nameNotSet){
            if(winnerButtons[arrayIterator].text==""){
                winnerButtons[arrayIterator].text=name
                //Make a toast for the champion
                if(winnerButtons.last().text!=""){
                    Toast.makeText(this, "Congratulations " + name, Toast.LENGTH_SHORT).show()
                }
                nameNotSet=false
            }else if(winnerButtons.last().text!=""){
                nameNotSet=false
            }
            arrayIterator++
        }
    }
}
