package com.Teslenochka.Production;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //TODO: add actions for saved instance:
            super.onCreate(savedInstanceState);
        }
        TrainingDataBase tdb = TrainingDataBase.init(this);


        Button btnTrList = (Button) findViewById(R.id.btnTrainingList); //shows list of all available trains
        Button btnTrStart = (Button) findViewById(R.id.btnStartTraining);
    }

    private void btnTrainingListClicked(){

    }

    private void btnStartTrainingClicked(){

    }


}
