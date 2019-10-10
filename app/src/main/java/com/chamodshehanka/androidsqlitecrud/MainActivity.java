package com.chamodshehanka.androidsqlitecrud;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chamodshehanka.androidsqlitecrud.model.Student;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText txtName;
    EditText txtAddress;
    EditText txtMarks;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);

        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        txtMarks = findViewById(R.id.txtMarks);
        btnAddData = findViewById(R.id.btnAddData);

        addStudent();
    }

    public void addStudent() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAdded = databaseHelper.insertData(new Student("",
                        txtName.getText().toString(), txtAddress.getText().toString(),
                        txtMarks.getText().toString()));

                if (isAdded) {
                    Toast.makeText(MainActivity.this, "Student Added", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Student Adding failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
