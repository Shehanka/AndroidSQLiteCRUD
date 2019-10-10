package com.chamodshehanka.androidsqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.chamodshehanka.androidsqlitecrud.model.Student;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "studentDB";
    private static final String TABLE_NAME = "student";
    public static final String COL_1 = "ID";
    private static final String COL_2 = "Name";
    private static final String COL_3 = "Address";
    private static final String COL_4 = "Marks";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " +
                        TABLE_NAME +
                        "(ID INTERGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Address TEXT, Marks TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, student.getName());
        contentValues.put(COL_3, student.getAddress());
        contentValues.put(COL_4, student.getMarks());
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
}
