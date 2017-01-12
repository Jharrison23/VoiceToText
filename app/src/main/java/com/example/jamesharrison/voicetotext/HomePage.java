package com.example.jamesharrison.voicetotext;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomePage extends AppCompatActivity
{

    FloatingActionButton addNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initialize();
    }

    public void initialize()
    {
        addNewNote = (FloatingActionButton) findViewById(R.id.addNewNote);
    }
}
