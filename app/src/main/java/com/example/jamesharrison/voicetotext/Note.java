package com.example.jamesharrison.voicetotext;

import java.util.Date;

/**
 * Created by jamesharrison on 1/12/17.
 */

public class Note
{
    // String to store the title of the note
    private String NoteTitle;

    // Date to store the date the note was created
    private String NoteDate;

    // constructor to set the title and date of the note
    public Note(String noteTitle, String noteDate)
    {
        NoteTitle = noteTitle;
        NoteDate = noteDate;
    }

    // get the title of the note
    public String getNoteTitle()
    {
        return NoteTitle;
    }

    // Get the date of the note
    public String getNoteDate()
    {
        return NoteDate;
    }

}
