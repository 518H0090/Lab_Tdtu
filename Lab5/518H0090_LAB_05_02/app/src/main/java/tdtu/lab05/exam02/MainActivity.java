package tdtu.lab05.exam02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    ListView listViewN;
    List<String> list;
    PhoneAdapter adapter;
    EditText addEdittext;
    Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewN = findViewById(R.id.listViewN);
        addEdittext = findViewById(R.id.addEdittext);
        btnThem = findViewById(R.id.btnThem);

        list = new ArrayList<String>(addnewList());

        adapter = new PhoneAdapter(
                this,
                R.layout.custom_listview,
                list
        );

        listViewN.setAdapter(adapter);


        adapter.notifyDataSetChanged();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneAdd = addEdittext.getText().toString();
//                cách 1: đảo 2 lần
//                Collections.reverse(list);
//                list.add(phoneAdd);
//                Collections.reverse(list);
//                cách 2  : thêm vị trí trước khi thêm phần tử
                list.add(0,phoneAdd);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private List<String> addnewList() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add("Phone" + (i + 1));
        }

        return list;
    }

}