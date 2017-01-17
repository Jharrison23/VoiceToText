package com.example.jamesharrison.voicetotext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// Class which will display the contents of the notes in the database
public class NoteView extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);
    }
}
