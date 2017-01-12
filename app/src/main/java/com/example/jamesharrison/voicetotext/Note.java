package com.example.jamesharrison.voicetotext;

import java.util.Date;

/**
 * Created by jamesharrison on 1/12/17.
 */

public class Note
{
    private String NoteTitle;
    private Date NoteDate;

    public Note(String noteTitle, Date noteDate)
    {
        NoteTitle = noteTitle;
        NoteDate = noteDate;
    }

    public String getNoteTitle()
    {
        return NoteTitle;
    }

    public Date getNoteDate()
    {
        return NoteDate;
    }

}
