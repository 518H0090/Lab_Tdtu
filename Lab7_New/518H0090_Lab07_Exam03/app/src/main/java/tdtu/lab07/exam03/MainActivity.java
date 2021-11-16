package tdtu.lab07.exam03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity implements IStudentOption{

    SqliteDatabase sqliteDatabase;
    ListView listView;
    List<STUDENT> studentList;
    StudentAdapter adapter;
    IStudentOption studentOption = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initUI();
        getStudentFromFirebase();
        adapter.setiStudentOption(studentOption);
    }

    private void initUI() {
        sqliteDatabase = new SqliteDatabase(this);
        listView = findViewById(R.id.listView);
        studentList = new ArrayList<>();

        adapter = new StudentAdapter(
                MainActivity.this,
                R.layout.recycler_view_student,
                studentList
        );

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menu_add_item) {
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.dialog_add_new_student);
            dialog.setCanceledOnTouchOutside(false);

            EditText editStudentName = dialog.findViewById(R.id.editStudentName);
            EditText editStudentClass = dialog.findViewById(R.id.editStudentClass);
            Button btnAdd = dialog.findViewById(R.id.btnAdd);
            Button btnCancel = dialog.findViewById(R.id.btnCancel);

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String studentName = editStudentName.getText().toString().trim();
                    String studentClass = editStudentClass.getText().toString().trim();

                    if (studentName.isEmpty() || studentClass.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Thiếu dữ liệu", Toast.LENGTH_SHORT).show();
                    } else {
                        STUDENT student = new STUDENT(studentName, studentClass);
                        sqliteDatabase.addStudent(student);
                        Toast.makeText(MainActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        getStudentFromFirebase();
                    }

                }
            });

            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getStudentFromFirebase() {
        if (studentList != null) {
            studentList.clear();
        }

        Cursor cursor = sqliteDatabase.selectSql("SELECT * FROM STUDENT");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String studentName = cursor.getString(1);
            String studentClass = cursor.getString(2);

            STUDENT student = new STUDENT(id , studentName, studentClass);

            studentList.add(student);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDeleteStudent(int position) {
        STUDENT student = studentList.get(position);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Xóa Phần tử");
        dialog.setMessage("Xác nhận xóa ?");
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sqliteDatabase.deleteStudent(student);
                getStudentFromFirebase();
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}