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
    // Variable for instance of database helper
    DatabaseHelper db;

    // Strings to store note information
    String StringName, StringDate, StringContent, NoteID;

    // Button to be linked to the buttons on layout
    Button deleteButton, editButton, saveButton;

    // Edit Text view which will display the data
    EditText noteName, noteDate, noteContent;

    // When the view is created
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Set the layout to be activity_note_view
        setContentView(R.layout.activity_note_view);

        // Create a bundle and get the bundle passed into the intent which moved to this class
        Bundle extrasBundle = getIntent().getExtras();

        // if the bundle is not empty
        if(!extrasBundle.isEmpty())
        {
            // Save the string with the tag "Id" into id
            String id = extrasBundle.getString("ID");

            // Retrieve the Note name from the bundle
            String StringName = extrasBundle.getString("NoteName");

            // Retrieve the note date from the bundle
            String StringDate = extrasBundle.getString("NoteDate");

            // Retrieve the note content from the bundle
            String StringContent = extrasBundle.getString("NoteContent");

            // set the note id, name, date and content
            setNoteID(id);
            setNoteName(StringName);
            setNoteDate(StringDate);
            setNoteContent(StringContent);

        }

        // Call the method to initialze the ui elements
        init();
    }


    // Method to initialize UI elements
    public void init()
    {
        // Create instance of database helper
        db = new DatabaseHelper(this);

        // get the note name and store inside variable note
        String name = getNoteName();

        // Store the note date
        String date = getNoteDate();

        // Store the note content
        String content = getNoteContent();

        // Text view to display note name
        noteName = (EditText) findViewById(R.id.noteName);

        // set the text of the note name text view to the contents of variable name
        noteName.setText(name);


        // Text view to display note date
        noteDate = (EditText) findViewById(R.id.noteDate);

        // set the text of the note date text view to the contents of variable date
        noteDate.setText(date);


        // Text view to display note content
        noteContent = (EditText) findViewById(R.id.noteContent);

        // set the text of the note content text view to the contents of variable content
        noteContent.setText(content);


        // Link the delete button
        deleteButton = (Button) findViewById(R.id.deleteNote);

        // When the delete button is pressed
        deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // Call the database method deleteData and pass in an ID
                Integer deletedRows = db.deleteData(getNoteID());

                // If the result of the deleteData is greater than 0 the delete was successful
                if (deletedRows > 0)
                {
                    Toast.makeText(NoteView.this, "Note deleted", Toast.LENGTH_SHORT).show();

                    // Create an intent to move to the class Homepage
                    Intent intent = new Intent(NoteView.this, HomePage.class);

                    // Move to class homepage
                    startActivity(intent);

                }

                // The delete was not successful
                else
                {
                    Toast.makeText(NoteView.this, "Note not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        editButton = (Button) findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveButton.setVisibility(View.VISIBLE);
                saveButton.setClickable(true);

                editButton.setVisibility(View.INVISIBLE);
                editButton.setClickable(false);

                noteContent.setFocusableInTouchMode(true);
                noteDate.setFocusableInTouchMode(true);
                noteName.setFocusableInTouchMode(true);

            }
        });

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setVisibility(View.INVISIBLE);
        saveButton.setClickable(false);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                saveButton.setVisibility(View.INVISIBLE);
                saveButton.setClickable(false);

                editButton.setVisibility(View.VISIBLE);
                editButton.setClickable(true);

                noteContent.setFocusable(false);
                noteDate.setFocusable(false);
                noteName.setFocusable(false);

                boolean updated = db.updateNote(getNoteID(), noteName.getText().toString(), noteDate.getText().toString(), noteContent.getText().toString());

                if (updated)
                {
                    Toast.makeText(NoteView.this, "Note updated", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(NoteView.this, HomePage.class);
                startActivity(intent);
            }
        });

        noteContent.setFocusable(false);
        noteDate.setFocusable(false);
        noteName.setFocusable(false);




    }


   // Getters and setters for the note information
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

}


