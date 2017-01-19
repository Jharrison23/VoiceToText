package com.example.jamesharrison.voicetotext;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterView extends ArrayAdapter<Note>
{


    private LayoutInflater inflater;

    // Array list of type Note which store all of the notes in the database
    private ArrayList<Note> notes;

    // Integer to store the id of the layout to be inflated
    private int mViewResourceId;

    public ListAdapterView(Context context, int textViewResourceId, ArrayList<Note> notes)
    {
        super(context, textViewResourceId, notes);

        this.notes = notes;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mViewResourceId = textViewResourceId;
    }


    public View getView(int position, View convertView, ViewGroup parents)
    {
        // Inflate the view mViewResourceId
        convertView = inflater.inflate(mViewResourceId, null);

        // get the note at the index position
        Note note = notes.get(position);

        // If the note is not empty
        if(note != null)
        {
            // Initialize the text view to display the information
            TextView noteTitle = (TextView) convertView.findViewById(R.id.noteTitle);
            TextView noteDate = (TextView) convertView.findViewById(R.id.noteDate);


            // If the title of the note is not empty
            if (noteTitle != null)
            {
                // Set the text view text to the note title
                noteTitle.setText(note.getNoteTitle());
            }

            // If the date of the note is not empty
            if(noteDate != null)
            {
                // set the text view text to the note date
                noteDate.setText(note.getNoteDate());
            }

        }

        return convertView;
    }

}
