package tdtu.lab07.exam03;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteDatabase extends SQLiteOpenHelper {

    public SqliteDatabase(@Nullable Context context) {
        super(context, "SqliteStudent", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_student_table = "CREATE TABLE IF NOT EXISTS STUDENT (ID INTEGER PRIMARY KEY AUTOINCREMENT , STUDENTNAME VARCHAR(255), CLASS VARCHAR(255) )";
        db.execSQL(create_student_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STUDENT");
        onCreate(db);
    }

    public void QuerySql(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor selectSql(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public void addStudent(STUDENT student) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("STUDENTNAME", student.getSTUDENTNAME());
        contentValues.put("CLASS", student.getCLASS());

        sqLiteDatabase.insert("STUDENT", null, contentValues);

        sqLiteDatabase.close();
    }

    public void deleteStudent(STUDENT student) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("STUDENT", "ID = ?",new String[] {String.valueOf(student.getID())});
        sqLiteDatabase.close();
    }

}
