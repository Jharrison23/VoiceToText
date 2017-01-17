package com.example.jamesharrison.voicetotext;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


// Class which will display the contents of the notes in the database
public class NoteView extends AppCompatActivity
{

    String StringName, StringDate, StringContent;

    TextView noteName, noteDate, noteContent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);


        Bundle extrasBundle = getIntent().getExtras();

        if(!extrasBundle.isEmpty())
        {
            String StringName = extrasBundle.getString("NoteName");
            String StringDate = extrasBundle.getString("NoteDate");
            String StringContent = extrasBundle.getString("NoteContent");


            setNoteName(StringName);
            setNoteDate(StringDate);
            setNoteContent(StringContent);

        }


        init();
    }


    public void init()
    {
        String name = getNoteName();

        String date = getNoteDate();

        String content = getNoteContent();

        noteName = (TextView) findViewById(R.id.noteName);

        noteName.setText(name);

        noteDate = (TextView) findViewById(R.id.noteDate);
        noteDate.setText(date);

        noteContent = (TextView) findViewById(R.id.noteContent);
        noteContent.setText(content);

    }


    public void showNoteContents(String NoteName, String NoteDate, String NoteContent)
    {
        noteName.setText(NoteName);

        noteDate.setText(NoteDate);

        noteContent.setText(NoteContent);
    }


    public void setNoteContent(String noteContent) {
        StringContent = noteContent;
    }

    public void setNoteName(String noteName) {
        this.StringName = noteName;
    }

    public void setNoteDate(String noteDate)
    {
        this.StringDate = noteDate;
    }

    public String getNoteContent()
    {
        return StringContent;
    }

    public String getNoteDate() {
        return StringDate;
    }

    public String getNoteName() {
        return StringName;
    }
}


