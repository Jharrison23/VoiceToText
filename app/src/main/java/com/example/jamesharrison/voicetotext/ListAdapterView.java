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

    private ArrayList<Note> notes;

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
        convertView = inflater.inflate(mViewResourceId, null);

        Note note = notes.get(position);

        if(note != null)
        {
            TextView noteTitle = (TextView) convertView.findViewById(R.id.noteTitle);
            TextView noteDate = (TextView) convertView.findViewById(R.id.noteDate);

            if (noteTitle != null)
            {
                noteTitle.setText(note.getNoteTitle());
            }

            if(noteDate != null)
            {
                noteDate.setText(note.getNoteDate());
            }

        }

        return convertView;
    }

}
