package com.chamodshehanka.androidsqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText txtName;
    ExtraData txtAddress;
    ExtraData txtMarks;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        txtName = (EditText)findViewById(R.id.txtName);
    }
}
