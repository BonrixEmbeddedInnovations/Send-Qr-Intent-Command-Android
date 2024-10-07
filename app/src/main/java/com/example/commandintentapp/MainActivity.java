package com.example.commandintentapp;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int[] images = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    private String[] names = {"Select App", "Customer Facing QR Code Display", "Dynamic QR Code Display", "3.5 inch Dynamic QR Code Display"};
    private String[] values = {"", "com.easovation.customerfacingqrdisplay_bt", "com.easovation.dynamicqrdisplay", "com.easovation.dynamicqrpaydisplay"};
    private String package_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        // Set the Toolbar as the ActionBar
        setSupportActionBar(toolbar);

        // Optionally, set the title and other properties
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dynamic QR Code");
        }

        EditText edt_amount = findViewById(R.id.edt_amount);
        EditText edt_note = findViewById(R.id.edt_note);

        Spinner spinner = findViewById(R.id.spin_app);
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, images, names, values);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    // Default prompt selected, do nothing
                } else {
                    // Handle the selected item
                    String selectedValue = values[position];
                    Toast.makeText(MainActivity.this, "Selected: " + selectedValue, Toast.LENGTH_SHORT).show();
                    package_name = selectedValue;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

        // Programmatically select an item (e.g., the first item)
        spinner.setSelection(0);


        Button button1 = findViewById(R.id.button1);
        button1.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent();
                intent.setAction("com.example.RECEIVE_DATA_ACTION");
                intent.setPackage(package_name);
                intent.putExtra("key", "WelcomeScreen**bonrix");
                intent.putExtra("flag", "1");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 1);
                } else {
                    // Handle the case where no activity is available to handle the intent
                    Toast.makeText(MainActivity.this, "No app found to handle the action.", Toast.LENGTH_SHORT).show();
                }*/

                Intent customIntent = new Intent();
                customIntent.setAction("com.example.RECEIVE_DATA_ACTION");
                customIntent.setPackage(package_name);
                customIntent.putExtra("key", "WelcomeScreen**bonrix");
                customIntent.putExtra("flag", "1");
                Intent chooser = Intent.createChooser(customIntent, "Choose an app");
                startActivity(chooser);

                // SendingAppActivity.java (from App A)
                /*Intent customIntent = new Intent();
                customIntent.setAction("com.example.RECEIVE_DATA_ACTION");
                customIntent.putExtra("key", "WelcomeScreen**bonrix");

// Check if there's an app that can handle the action
                if (customIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(customIntent);
                } else {
                    // Handle the case where no app is available to handle the intent
                    Toast.makeText(MainActivity.this, "No app found to handle this action.", Toast.LENGTH_SHORT).show();
                }*/

            }
        });

        Button btn_send_amount = findViewById(R.id.btn_send_amount);
        btn_send_amount.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
        btn_send_amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCustomDialog();
            }
        });

        // Button 2 - Blue
        Button button2 = findViewById(R.id.button2);
        button2.setBackgroundColor(ContextCompat.getColor(this, R.color.lightBlue));
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = edt_amount.getText().toString().trim();
                String note = edt_note.getText().toString().trim();

                Intent intent = new Intent();
                intent.setAction("com.example.RECEIVE_DATA_ACTION");
                intent.setPackage(package_name);
                intent.putExtra("key", "DisplayQRCodeScreen**upi://pay?pa=63270083167.payswiff@indus&pn=Bonrix&cu=INR&am=" + amount + "&pn=Bonrix%20Software%20Systems**10**7418529631@icici");
                intent.putExtra("flag", "1");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 1);
                } else {
                    // Handle the case where no activity is available to handle the intent
                    Toast.makeText(MainActivity.this, "No app found to handle the action.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Button 3 - Green
        Button button3 = findViewById(R.id.button3);
        button3.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntent = new Intent();
                customIntent.setAction("com.example.RECEIVE_DATA_ACTION");
                customIntent.setPackage(package_name);
                customIntent.putExtra("key", "DisplaySuccessQRCodeScreen**1234567890**ORD10594565**29-03-2023");
                customIntent.putExtra("flag", "1");
                Intent chooser = Intent.createChooser(customIntent, "Choose an app");
                startActivity(chooser);
            }
        });

        // Button 4 - Yellow
        Button button4 = findViewById(R.id.button4);
        button4.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntent = new Intent();
                customIntent.setAction("com.example.RECEIVE_DATA_ACTION");
                customIntent.setPackage(package_name);
                customIntent.putExtra("key", "DisplayFailQRCodeScreen**1234567890**ORD10594565**29-03-2023");
                customIntent.putExtra("flag", "1");
                Intent chooser = Intent.createChooser(customIntent, "Choose an app");
                startActivity(chooser);
            }
        });

        // Button 5 - Cyan
        Button button5 = findViewById(R.id.button5);
        button5.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntent = new Intent();
                customIntent.setAction("com.example.RECEIVE_DATA_ACTION");
                customIntent.setPackage(package_name);
                customIntent.putExtra("key", "DisplayCancelQRCodeScreen**1234567890**ORD10594565**29-03-2023");
                customIntent.putExtra("flag", "1");
                Intent chooser = Intent.createChooser(customIntent, "Choose an app");
                startActivity(chooser);
            }
        });

        // Button 6 - Magenta
        Button button6 = findViewById(R.id.button6);
        button6.setBackgroundColor(ContextCompat.getColor(this, R.color.purple));
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntent = new Intent();
                customIntent.setAction("com.example.RECEIVE_DATA_ACTION");
                customIntent.setPackage(package_name);
                customIntent.putExtra("key", "DisplayTotalScreen**2390.32**50**50**2390.32");
                customIntent.putExtra("flag", "1");
                Intent chooser = Intent.createChooser(customIntent, "Choose an app");
                startActivity(chooser);
            }
        });

        // Button 7 - Gray
        Button button7 = findViewById(R.id.button7);
        button7.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntent = new Intent();
                customIntent.setAction("com.example.RECEIVE_DATA_ACTION");
                customIntent.setPackage(package_name);
                customIntent.putExtra("key", "DisplayItemScreen**Dell Laptop**dell123454**34550**1**34550");
                customIntent.putExtra("flag", "1");
                Intent chooser = Intent.createChooser(customIntent, "Choose an app");
                startActivity(chooser);
            }
        });
    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_send_amount);
        dialog.setCancelable(false);

        dialog.getWindow().setLayout(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        EditText editTextAmount = dialog.findViewById(R.id.editTextAmount);
        CheckBox checkBoxFlag = dialog.findViewById(R.id.checkBoxFlag);
        Button buttonCancel = dialog.findViewById(R.id.buttonCancel);
        Button buttonSend = dialog.findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = editTextAmount.getText().toString().trim();
                String flagvalue = "1";
                if (checkBoxFlag.isChecked()) {
                    flagvalue = "1";
                } else {
                    flagvalue = "0";
                }
                Intent customIntent = new Intent();
                customIntent.setAction("com.example.RECEIVE_DATA_ACTION");
                customIntent.setPackage(package_name);
                customIntent.putExtra("key", "SendAmount");
                customIntent.putExtra("amount", amount);
                customIntent.putExtra("flag", flagvalue);
                Intent chooser = Intent.createChooser(customIntent, "Choose an app");
                startActivity(chooser);
                dialog.dismiss();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("resultKey")) {
                String resultData = data.getStringExtra("resultKey");
                Log.e("TAG5", "Exception5");
                // Use the result data as needed
                Toast.makeText(this, "Received result: " + resultData, Toast.LENGTH_SHORT).show();
            }
        }
    }
}