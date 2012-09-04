package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Activity {

    private Button _myButton = null;
    private Button _clockButton = null;
    private Button _textFieldButton = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alternate);
        initializeControls();
    }

    private void initializeControls()
    {
        _myButton = (Button) findViewById(R.id.my_button);
        _clockButton = (Button) findViewById(R.id.clock_button);
        _textFieldButton = (Button) findViewById(R.id.text_field_button);
    }

    public void buttonClicked(View sender)
    {
        if (sender == _clockButton)
        {
            setContentView(R.layout.main);
        }
        else if (sender == _myButton)
        {
            setContentView(R.layout.alternate);
        }
        else if (sender == _textFieldButton)
        {
            String crap = ((EditText)findViewById(R.id.text_field)).getText().toString();

            if (crap.isEmpty())
            {
                displayDialog("You set nothing! You naughty person.");

                return;
            }

            displayDialog("You entered: " + crap);
        }
    }

    private void displayDialog(String message)
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setMessage(message).setCancelable(false).setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        adb.show();
    }
}
