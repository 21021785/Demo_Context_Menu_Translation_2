package sg.edu.rp.c346.id21021785.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText1;
    TextView tvTranslatedText2;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText1 = findViewById(R.id.textViewTranslatedText1);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvTranslatedText1);
        registerForContextMenu(tvTranslatedText2);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvTranslatedText1) {
            wordClicked = "hello";
        } else if (v == tvTranslatedText2) {
            wordClicked = "bye";

        }

        getMenuInflater().inflate(R.menu.menu_main, menu);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (wordClicked.equalsIgnoreCase("hello")) {
            if (id == R.id.EnglishSelection) { //check whether the selected menu item is English
                //code for action
                tvTranslatedText1.setText("Hello");


                return true; //menu item successfully handled

            } else if (id == R.id.italianSelection) { //check if the selected menu item is Italian
                //code for action
                tvTranslatedText1.setText("Ciao");


                return true;  //menu item successfully handled
            }
        } else if (wordClicked.equalsIgnoreCase("bye")) {
            if (id == R.id.EnglishSelection) { //check whether the selected menu item is English
                //code for action
                tvTranslatedText2.setText("Bye");


                return true; //menu item successfully handled

            } else if (id == R.id.italianSelection) { //check if the selected menu item is Italian
                //code for action
                tvTranslatedText2.setText("Addio");


                return true;  //menu item successfully handled
            }
        }


        return super.onContextItemSelected(item);
    }

}