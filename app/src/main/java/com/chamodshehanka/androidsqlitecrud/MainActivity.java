package com.chamodshehanka.androidsqlitecrud;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.chamodshehanka.androidsqlitecrud.db.DatabaseHelper;
import com.chamodshehanka.androidsqlitecrud.model.Student;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText txtName;
    EditText txtAddress;
    EditText txtMarks;
    Button btnAddData;
    Button btnViewAll;


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

        btnViewAll = findViewById(R.id.btnViewAll);
        viewAllStudents();
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

    public void viewAllStudents() {
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = databaseHelper.getAllData();

                if (res.getCount() > 0) {
                    StringBuilder buffer = new StringBuilder();
                    while (res.moveToNext()) {
                        buffer.append("ID : ").append(res.getString(0)).append("\n");
                        buffer.append("Name : ").append(res.getString(1)).append("\n");
                        buffer.append("Address : ").append(res.getString(2)).append("\n");
                        buffer.append("Marks : ").append(res.getString(3)).append("\n");
                    }
                }
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);

    }
}
