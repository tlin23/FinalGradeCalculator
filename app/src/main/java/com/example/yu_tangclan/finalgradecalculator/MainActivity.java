package com.example.yu_tangclan.finalgradecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void calculate(View view) {
        EditText r1c1 = (EditText) findViewById(R.id.r1c1);
        EditText r2c1 = (EditText) findViewById(R.id.r2c1);
        EditText r3c1 = (EditText) findViewById(R.id.r3c1);
        EditText r4c1 = (EditText) findViewById(R.id.r4c1);
        EditText r5c1 = (EditText) findViewById(R.id.r5c1);
        double recieved1 = Double.parseDouble(r1c1.getText().toString());
        double recieved2 = Double.parseDouble(r2c1.getText().toString());
        double recieved3 = Double.parseDouble(r3c1.getText().toString());
        double recieved4 = Double.parseDouble(r4c1.getText().toString());
        double recieved5 = Double.parseDouble(r5c1.getText().toString());

        EditText r1c2 = (EditText) findViewById(R.id.r1c2);
        EditText r2c2 = (EditText) findViewById(R.id.r2c2);
        EditText r3c2 = (EditText) findViewById(R.id.r3c2);
        EditText r4c2 = (EditText) findViewById(R.id.r4c2);
        EditText r5c2 = (EditText) findViewById(R.id.r5c2);
        double worth1 = Double.parseDouble(r1c2.getText().toString()) / 100;
        double worth2 = Double.parseDouble(r2c2.getText().toString()) / 100;
        double worth3 = Double.parseDouble(r3c2.getText().toString()) / 100;
        double worth4 = Double.parseDouble(r4c2.getText().toString()) / 100;
        double worth5 = Double.parseDouble(r5c2.getText().toString()) / 100;


        double gradeSoFar = recieved1 * worth1 +
                            recieved2 * worth2 +
                            recieved3 * worth3 +
                            recieved4 * worth4 +
                            recieved5 * worth5;

        EditText fw = (EditText) findViewById(R.id.final_worth);
        double finalWorth = Double.parseDouble(fw.getText().toString()) / 100;

        double anAPlus = (90 - gradeSoFar) / finalWorth;
        double anA = (85 - gradeSoFar) / finalWorth;
        double anAMinus = (80 - gradeSoFar) / finalWorth;
        double aBPlus = (76 - gradeSoFar) / finalWorth;
        double aB = (72 - gradeSoFar) / finalWorth;
        double aBMinus = (68 - gradeSoFar) / finalWorth;

        Log.d("85 - gradeSoFar", Double.toString(85 - gradeSoFar));

        String gradeNeedForAPlus = Double.toString(Math.floor(anAPlus));
        String gradeNeedForAnA = Double.toString(Math.floor(anA));
        String gradeNeedForAMinus = Double.toString(Math.floor(anAMinus));
        String gradeNeedForBPlus = Double.toString(Math.floor(aBPlus));
        String gradeNeedForB = Double.toString(Math.floor(aB));
        String gradeNeedForBMinus = Double.toString(Math.floor(aBMinus));

        final TextView you_need = (TextView) findViewById(R.id.you_need);

        you_need.setText("You need: \n"
                + gradeNeedForAPlus + "% to get an A+ (90%) \n"
                + gradeNeedForAnA + "% to get an A (85%) \n"
                + gradeNeedForAMinus + "% to get an A- (80%) \n"
                + gradeNeedForBPlus + "% to get an B+ (76%) \n"
                + gradeNeedForB + "% to get an B (72%) \n"
                + gradeNeedForBMinus + "% to get an B- (68%) \n");
    }
}
