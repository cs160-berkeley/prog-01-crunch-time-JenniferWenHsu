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

        EditText pushupText = (EditText)findViewById(R.id.editText2);
        EditText situpText = (EditText)findViewById(R.id.editText);
        EditText jumpingjackText = (EditText)findViewById(R.id.editText4);
        EditText joggingText = (EditText)findViewById(R.id.editText3);

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
            calorieText.setText(String.format("%.1f",pushupNum * 100 / 350));
            situpText.setText(String.format("%.1f Reps",pushupNum*200/350));
            jumpingjackText.setText(String.format("%.1f Mins",pushupNum*10/350));
            joggingText.setText(String.format("%.1f Mins",pushupNum*12/350));
        }

        //only situp input
        else if (pushupString.matches("")&&!situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")
                &&calorieString.matches("")){
            situpNum=Double.parseDouble(situpString);
            calorieText.setText(String.format("%.1f",situpNum*100/200));
            pushupText.setText(String.format("%.1f Reps",situpNum*350/200));
            jumpingjackText.setText(String.format("%.1f Mins", situpNum*10/200));
            joggingText.setText(String.format("%.1f Mins", situpNum*12/200));
        }
        //only jumpingjack input
        else if (pushupString.matches("")&&situpString.matches("")&&!jumpingjackString.matches("")&&joggingString.matches("")
                &&calorieString.matches("")){
            jumpingjackMin=Double.parseDouble(jumpingjackString);
            calorieText.setText(String.format("%.1f",jumpingjackMin*10));
            pushupText.setText(String.format("%.1f Reps",jumpingjackMin*35));
            situpText.setText(String.format("%.1f Reps",jumpingjackMin*20));
            joggingText.setText(String.format("%.1f Mins", jumpingjackMin * 1.2));

        }
        //only jogging input
        else if (pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&!joggingString.matches("")
                &&calorieString.matches("")){
            joggingMin=Double.parseDouble(joggingString);
            calorieText.setText(String.format("%.1f",joggingMin*100/12));
            pushupText.setText(String.format("%.1f Reps",joggingMin*350/12));
            situpText.setText(String.format("%.1f Reps",joggingMin*200/12));
            jumpingjackText.setText(String.format("%.1f Mins",joggingMin*10/12));

        }
        //only the calorie input
        else if(pushupString.matches("")&&situpString.matches("")&&jumpingjackString.matches("")&&joggingString.matches("")
                &&!calorieString.matches("")){
            totalCalorie = Double.parseDouble(calorieString);
            pushupText.setText(String.format("%.1f Reps",totalCalorie*3.5));
            situpText.setText(String.format("%.1f Reps",totalCalorie*2));
            jumpingjackText.setText(String.format("%.1f Mins",totalCalorie / 10));
            joggingText.setText(String.format("%.1f Mins",totalCalorie * 0.12));
        }

        else{
            Toast.makeText(this, "Only fill in one field. Click on the RESET button to continue.", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void onButtonClick2(View view){
        EditText pushupText = (EditText)findViewById(R.id.editText);
        EditText situpText = (EditText)findViewById(R.id.editText2);
        EditText jumpingjackText = (EditText)findViewById(R.id.editText3);
        EditText joggingText = (EditText)findViewById(R.id.editText4);
        EditText calorieText = (EditText)findViewById(R.id.calorieEditText);

        pushupText.setText(null);
        situpText.setText(null);
        jumpingjackText.setText(null);
        joggingText.setText(null);
        calorieText.setText(null);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
