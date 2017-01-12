package com.example.jamesharrison.voicetotext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewNote extends AppCompatActivity
{
    Button save;

    EditText noteTitle, noteDate, noteText;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        initialize();
    }

    public void initialize()
    {

        db = new DatabaseHelper(this);

        noteTitle = (EditText) findViewById(R.id.noteTitleEdit);
        noteDate = (EditText) findViewById(R.id.noteDateEdit);

        save = (Button) findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean insert = db.addData(noteTitle.getText().toString(), noteDate.getText().toString());

                if (insert)
                {
                    Toast.makeText(NewNote.this, "Note has been inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NewNote.this, HomePage.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(NewNote.this, "Note not inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
