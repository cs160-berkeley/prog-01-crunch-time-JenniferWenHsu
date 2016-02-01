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

        EditText calorieText = (EditText)findViewById(R.id.calorieEditText);

        double pushupNum = 0;
        double situpNum = 0;
        double jumpingjackMin = 0;
        double joggingMin = 0;
        double totalCalorie = 0;

        String pushupString = pushupText.getText().toString();
        String situpString = situpText.getText().toString();
        String jumpingjackString = jumpingjackText.getText().toString();
        String joggingString = joggingText.getText().toString();
        String calorieString = calorieText.getText().toString();

        //if the user didn't place any inputs
        if (pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")
                &&calorieString.matches("")){
            Toast.makeText(this, "Please enter at least one field to calculate", Toast.LENGTH_SHORT).show();
            return;
        }

        //only pushup input
        if (!pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")
                &&calorieString.matches("")){
            pushupNum=Double.parseDouble(pushupString);
            calorieText.setText(Double.toString(pushupNum*100/350));
            situpText.setText(Double.toString(pushupNum*200/350));
            jumpingjackText.setText(Double.toString(pushupNum*10/350));
            joggingText.setText(Double.toString(pushupNum*12/350));
        }

        //only situp input
        else if (pushupString.matches("")&&!situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")
                &&calorieString.matches("")){
            situpNum=Double.parseDouble(situpString);
            calorieText.setText(Double.toString(situpNum*100/200));
            pushupText.setText(Double.toString(situpNum*350/200));
            jumpingjackText.setText(Double.toString(situpNum*10/200));
            joggingText.setText(Double.toString(situpNum*12/200));
        }
        //only jumpingjack input
        else if (pushupString.matches("")&&situpString.matches("")&&!jumpingjackString.matches("")&&joggingString.matches("")
                &&calorieString.matches("")){
            jumpingjackMin=Double.parseDouble(jumpingjackString);
            calorieText.setText(Double.toString(jumpingjackMin*10));
            pushupText.setText(Double.toString(jumpingjackMin*35));
            situpText.setText(Double.toString(jumpingjackMin*20));
            joggingText.setText(Double.toString(jumpingjackMin*1.2));

        }
        //only jogging input
        else if (pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&!joggingString.matches("")
                &&calorieString.matches("")){
            joggingMin=Double.parseDouble(joggingString);
            calorieText.setText(Double.toString(joggingMin*100/12));
            pushupText.setText(Double.toString(joggingMin*350/12));
            situpText.setText(Double.toString(joggingMin*200/12));
            jumpingjackText.setText(Double.toString(joggingMin*10/12));

        }
        //only the calorie input
        else if(pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")
                &&!calorieString.matches("")){
            totalCalorie = Double.parseDouble(calorieString);
            pushupText.setText(Double.toString(totalCalorie*3.5));
            situpText.setText(Double.toString(totalCalorie*2));
            jumpingjackText.setText(Double.toString(totalCalorie/10));
            joggingText.setText(Double.toString(totalCalorie*0.12));
        }

        else{
            Toast.makeText(this, "Only fill in one field", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void onButtonClick2(View view){
        EditText pushupText = (EditText)findViewById(R.id.editText);
        EditText situpText = (EditText)findViewById(R.id.editText2);
        EditText jumpingjackText = (EditText)findViewById(R.id.editText3);
        EditText joggingText = (EditText)findViewById(R.id.editText4);

        pushupText.setText(null);
        situpText.setText(null);
        jumpingjackText.setText(null);
        joggingText.setText(null);

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
