package tdtu.lab02.exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
// 518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    Spinner spinnerEmployee;
    List<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerEmployee = (Spinner) findViewById(R.id.spinnerEmployee);
        employees = new ArrayList<>();
        employees.add(new Employee("James", "Smith", "Receptionist", 1000));
        employees.add(new Employee("Michael", "Garcia", "CEO", 50000));
        employees.add(new Employee("Robert", "Johnson", "Professional staff", 2000));

        ArrayAdapter<Employee> adapter = new ArrayAdapter<Employee>(
          MainActivity.this,
                android.R.layout.simple_spinner_item,
                employees
        );

//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEmployee.setAdapter(adapter);

        spinnerEmployee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Employee employee = employees.get(position);
                Toast.makeText(getApplicationContext(), "Selected Employee: " + employee.getFullName() ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}