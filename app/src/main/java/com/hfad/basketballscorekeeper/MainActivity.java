package com.hfad.basketballscorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTeamOnePointsTv, mTeamTwoPointsTv;

    private int mTeamOnePoints = 0;
    private int mTeamTwoPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //setting screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mTeamOnePointsTv = findViewById(R.id.team_one_points_tv);
        mTeamTwoPointsTv = findViewById(R.id.team_two_points_tv);
    }

    public void onAddClick(View view) {
        //getting the ID of the add button that was clicked
        int AddViewID = view.getId();

        //if team_one_add button is clicked, add point to team one
        switch (AddViewID) {
            case R.id.team_one_add:
                mTeamOnePoints++;
                mTeamOnePointsTv.setText(String.valueOf(mTeamOnePoints));
                break;

            //if team_two_add button is clicked, add points to team two
            case R.id.team_two_add:
                mTeamTwoPoints++;
                mTeamTwoPointsTv.setText(String.valueOf(mTeamTwoPoints));
        }

    }

    public void onMinusClick(View view) {
        Toast toast = Toast.makeText(this, "Score is already at 0", Toast.LENGTH_SHORT);
        //getting the ID of the minus button that was clicked
        int minusViewID = view.getId();

        //if team_one_minus button is clicked, and if points are not equal to 0, subtract point to team one. If points = 0, show toast
        switch (minusViewID) {
            case R.id.team_one_minus:
                if (mTeamOnePointsTv.getText().toString().equals("0")) {
                    toast.show();
                } else {
                    mTeamOnePoints--;
                    mTeamOnePointsTv.setText(String.valueOf(mTeamOnePoints));
                }
                break;

            //if team_two_minus button is clicked, and if points are not equal to 0, subtract point to team two. If points = 0, show toast
            case R.id.team_two_minus:
                if (mTeamTwoPointsTv.getText().toString().equals("0")) {
                    toast.show();
                } else {
                    mTeamTwoPoints--;
                    mTeamTwoPointsTv.setText(String.valueOf(mTeamTwoPoints));
                }
        }
    }

    /**
     * inflating menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * logic for item selected in menu
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //set both scores to 0 if item is selected
        mTeamOnePointsTv.setText(String.valueOf(0));
        mTeamTwoPointsTv.setText(String.valueOf(0));
        mTeamOnePoints = 0;
        mTeamTwoPoints = 0;
        return true;
    }
}