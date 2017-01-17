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

    String NoteName, NoteDate, NoteContent;
    TextView noteName, noteDate, noteContent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);


        Bundle extrasBundle = getIntent().getExtras();

        if(!extrasBundle.isEmpty())
        {
            String NoteName = extrasBundle.getString("NoteName");
            String NoteDate = extrasBundle.getString("NoteDate");

            Toast.makeText(this, "note name = " + NoteName, Toast.LENGTH_SHORT).show();

            setNoteName(NoteName);
            setNoteDate(NoteDate);


//            noteName.setText(NoteName);
//            noteDate.setText(NoteDate);

        }


        init();
    }

//    @Override
//    public void startActivity(Intent intent) {
//        super.startActivity(intent);
//
//
//        Bundle extrasBundle = intent.getExtras();
//
//        if(!extrasBundle.isEmpty())
//        {
//            String NoteName = extrasBundle.getString("NoteName");
//            String NoteDate = extrasBundle.getString("NoteDate");
//
//
//            noteName.setText(NoteName);
//            noteDate.setText(NoteDate);
//
//        }
//
//        Toast.makeText(this, "startintent", Toast.LENGTH_SHORT).show();
//
//        noteName.setText(getNoteName());
//        noteDate.setText(getNoteDate());
//
//
//
//    }

    public void init()
    {

        Toast.makeText(this, "init", Toast.LENGTH_SHORT).show();


        String name = getNoteName();

        String date = getNoteDate();

        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        noteName = (TextView) findViewById(R.id.noteName);

        noteName.setText(name);

        noteDate = (TextView) findViewById(R.id.noteDate);
        noteDate.setText(date);
        noteContent = (TextView) findViewById(R.id.noteContent);

    }


    public void showNoteContents(String NoteName, String NoteDate, String NoteContent)
    {
        noteName.setText(NoteName);

        noteDate.setText(NoteDate);

        noteContent.setText(NoteContent);
    }


    public void setNoteContent(String noteContent) {
        NoteContent = noteContent;
    }

    public void setNoteName(String noteName) {
        this.NoteName = noteName;
       // Toast.makeText(this, "in here", Toast.LENGTH_SHORT).show();
    }

    public void setNoteDate(String noteDate)
    {
        this.NoteDate = noteDate;

        //Toast.makeText(this, "in here too", Toast.LENGTH_SHORT).show();
    }

    public String getNoteContent()
    {
        return NoteContent;
    }

    public String getNoteDate() {
        return NoteDate;
    }

    public String getNoteName() {
        return NoteName;
    }
}


