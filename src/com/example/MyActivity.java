package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alternate);
    }

    public void buttonClicked(View sender)
    {
        if (sender.getId() == R.id.clock_button)
        {
            setContentView(R.layout.main);
        }
        else if (sender.getId() == R.id.my_button)
        {
            setContentView(R.layout.alternate);
        }
        else if (sender.getId() == R.id.text_field_button)
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
