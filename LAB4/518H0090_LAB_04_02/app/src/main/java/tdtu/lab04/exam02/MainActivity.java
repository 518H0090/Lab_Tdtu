package tdtu.lab04.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list;
    StringAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_item);
        list = new ArrayList<String>();

        for (int i = 0; i< 6 ; i++) {
            list.add("Item" + (i+1));
        }

        adapter = new StringAdapter(
                MainActivity.this,
                R.layout.custom_listview,
                list
        );

        listView.setAdapter(adapter);
    }
}