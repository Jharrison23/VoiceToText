package com.example.jamesharrison.voicetotext;

import java.util.Date;

/**
 * Created by jamesharrison on 1/12/17.
 */

public class Note
{
    private String NoteID;

    // String to store the title of the note
    private String NoteTitle;

    // Date to store the date the note was created
    private String NoteDate;

    private String NoteContent;

    // constructor to set the title and date of the note
    public Note(String noteID, String noteTitle, String noteDate, String noteContent)
    {
        NoteID = noteID;
        NoteTitle = noteTitle;
        NoteDate = noteDate;
        NoteContent = noteContent;
    }

    public String getNoteID()
    {
        return NoteID;
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

    public String getNoteContent() {
        return NoteContent;
    }
}
