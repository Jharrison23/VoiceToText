package com.example.jamesharrison.voicetotext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    // Initialize Ui elements to be used for this layout
    Button enterButton;


    // When the view is first created
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Set the content view for this class to the activity_main xml
        setContentView(R.layout.activity_main);

        // Call the initialize method
        initialize();
    }

    // Method used to initialize the UI elements of the layout
    public void initialize()
    {
        // Set the variable enter button to the button with the id enterApp
        enterButton = (Button) findViewById(R.id.enterApp);

        // Call the set on click listener and pass in the enterApp button
        enterButton.setOnClickListener(this);
    }


    // Once a button on the view is pressed
    @Override
    public void onClick(View v)
    {
        // Execute code based off of which button is pressed
        switch (v.getId())
        {
            // if the enterApp button is pressed
            case R.id.enterApp:
                Toast.makeText(this, "Enter Button Pressed", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
