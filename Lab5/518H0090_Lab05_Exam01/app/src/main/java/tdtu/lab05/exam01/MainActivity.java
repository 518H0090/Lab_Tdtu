package tdtu.lab05.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    ListView listViewN;
    List<String> list;
    PhoneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewN = findViewById(R.id.listViewN);
        list = new ArrayList<String>(addnewList());

        adapter = new PhoneAdapter(
                this,
                R.layout.custom_listview,
                list
        );

        listViewN.setAdapter(adapter);

    }

    private List<String> addnewList() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add("Phone" + (i + 1));
        }

        return list;
    }

}