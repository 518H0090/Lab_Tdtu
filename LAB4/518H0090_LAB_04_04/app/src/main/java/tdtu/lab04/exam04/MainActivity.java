package tdtu.lab04.exam04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    private ListView listViewBasic, listViewCustom;
    private RecyclerView recyclerView;
    private List<String> listBasic;
    private List<User> listUser;
    private List<Employee> listEmployee;
    private ArrayAdapter arrayAdapter;
    private UserAdapter userAdapter;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Declare();
        BasicAdapterInstall();
        CustomAdapterListInstall();
        RecyclerViewAdapterInstall();
    }

    private void Declare() {
        listViewBasic = (ListView) findViewById(R.id.listViewBasic);
        listViewCustom = (ListView) findViewById(R.id.listViewCustom);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        listBasic = new ArrayList<String>(Arrays.asList(arrayString()));
        listUser = new ArrayList<User>(addListUser());
        listEmployee = new ArrayList<Employee>(addListEmployee());
    }

    private void BasicAdapterInstall() {
        arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                listBasic
        );

        listViewBasic.setAdapter(arrayAdapter);
    }

    private void CustomAdapterListInstall() {
        userAdapter = new UserAdapter(
                MainActivity.this,
                R.layout.custom_listview,
                listUser
        );

        listViewCustom.setAdapter(userAdapter);
    }

    private void RecyclerViewAdapterInstall() {
        employeeAdapter = new EmployeeAdapter(
                this,
                R.layout.custom_recyclerview
        );

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        employeeAdapter.setEmployeeList(listEmployee);
        recyclerView.setAdapter(employeeAdapter);
    }

    private String[] arrayString() {
        String[] array = new String[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = "Item" + (i + 1);
        }

        return array;
    }

    private List<User> addListUser() {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            userList.add(new User("User" + (i + 1), "Password" + (i + 1)));
        }
        return userList;
    }

    private List<Employee> addListEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Mot", "Hai", R.drawable.ic_launcher_background));
        employeeList.add(new Employee("Ba", "Bon", R.drawable.ic_launcher_background));
        return employeeList;
    }
}