package com.example.jenni_000.crunchtime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onButtonClick1(View view){

        EditText pushupText = (EditText)findViewById(R.id.editText);
        EditText situpText = (EditText)findViewById(R.id.editText2);
        EditText jumpingjackText = (EditText)findViewById(R.id.editText3);
        EditText joggingText = (EditText)findViewById(R.id.editText4);

        TextView calorieText = (TextView)findViewById(R.id.calorieEditText);

        double pushupNum = 0;
        double situpNum = 0;
        double jumpingjackMin = 0;
        double joggingMin = 0;

        String pushupString = pushupText.getText().toString();
        String situpString = situpText.getText().toString();
        String jumpingjackString = jumpingjackText.getText().toString();
        String joggingString = joggingText.getText().toString();

        //if the user didn't place any inputs
        if (pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")){
            Toast.makeText(this, "Please enter at least one field to calculate", Toast.LENGTH_SHORT).show();
            return;
        }

        //only pushup input
        if (!pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")){
            pushupNum=Double.parseDouble(pushupString);
            calorieText.setText(Double.toString(pushupNum));

            //need to write to forbid users to write to the other textfields
        }

        //only situp input
        if (pushupString.matches("")&&!situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")){
            situpNum=Double.parseDouble(situpString);
            calorieText.setText(Double.toString(situpNum));

            //need to write to forbid users to write to the other textfields
        }
        //only jumpingjack input
        if (pushupString.matches("")&&situpString.matches("")&&!jumpingjackString.matches("")&&joggingString.matches("")){
            jumpingjackMin=Double.parseDouble(jumpingjackString);
            calorieText.setText(Double.toString(jumpingjackMin));

            //need to write to forbid users to write to the other textfields
        }
        //only jogging input
        if (pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&!joggingString.matches("")){
            joggingMin=Double.parseDouble(joggingString);
            calorieText.setText(Double.toString(joggingMin));

            //need to write to forbid users to write to the other textfields
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
