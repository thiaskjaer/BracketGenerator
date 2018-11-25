package programminglanguages.bracketgenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class BracketView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bracket_view)
        
        //receiving the intent containing the names as a StringArrayList
        val names = intent.getStringArrayListExtra("Names")
        //Test toast to test if the names have been transferred correctly
        Toast.makeText(this, names.last(), Toast.LENGTH_SHORT).show()
    }
}
