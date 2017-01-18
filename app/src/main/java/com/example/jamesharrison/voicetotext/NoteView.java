package com.example.jamesharrison.voicetotext;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.jamesharrison.voicetotext.DatabaseHelper.TABLE_NAME;


// Class which will display the contents of the notes in the database
public class NoteView extends AppCompatActivity
{
    DatabaseHelper db;

    String StringName, StringDate, StringContent, NoteID;

    Button deleteButton;

    TextView noteName, noteDate, noteContent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_note_view);

        Bundle extrasBundle = getIntent().getExtras();

        if(!extrasBundle.isEmpty())
        {
            String id = extrasBundle.getString("ID");
            String StringName = extrasBundle.getString("NoteName");
            String StringDate = extrasBundle.getString("NoteDate");
            String StringContent = extrasBundle.getString("NoteContent");

            setNoteID(id);
            setNoteName(StringName);
            setNoteDate(StringDate);
            setNoteContent(StringContent);

        }


        init();
    }


    public void init()
    {
        db = new DatabaseHelper(this);
        String name = getNoteName();

        String date = getNoteDate();

        String content = getNoteContent();

        noteName = (TextView) findViewById(R.id.noteName);

        noteName.setText(name);

        noteDate = (TextView) findViewById(R.id.noteDate);
        noteDate.setText(date);

        noteContent = (TextView) findViewById(R.id.noteContent);
        noteContent.setText(content);

        deleteButton = (Button) findViewById(R.id.deleteNote);

        deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer deletedRows = db.deleteData(NoteID);

                if (deletedRows > 0)
                {
                    Toast.makeText(NoteView.this, "Note deleted", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(NoteView.this, HomePage.class);

                    startActivity(intent);

                }

                else
                {
                    Toast.makeText(NoteView.this, "Note not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    public void showNoteContents(String NoteName, String NoteDate, String NoteContent)
    {
        noteName.setText(NoteName);

        noteDate.setText(NoteDate);

        noteContent.setText(NoteContent);
    }

    public void setNoteID(String noteID)
    {
        NoteID = noteID;
    }

    public String getNoteID()
    {
        return NoteID;
    }

    public void setNoteContent(String noteContent) {
        StringContent = noteContent;
    }

    public void setNoteName(String noteName) {
        StringName = noteName;
    }

    public void setNoteDate(String noteDate)
    {
        StringDate = noteDate;
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

    public void delete(String id)
    {
        DatabaseHelper handler = new DatabaseHelper(this);

        SQLiteDatabase db = handler.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME + "WHERE ");

    }
}


