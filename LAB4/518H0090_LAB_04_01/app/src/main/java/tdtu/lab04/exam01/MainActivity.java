package tdtu.lab04.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    ListView listViewItem;
    List<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] array = new String[6];
        for (int i = 0; i < array.length ; i++) {
            array[i] = "Item" + (i+1);
        }

        listViewItem = (ListView) findViewById(R.id.listViewItem);
        list = new ArrayList<String>(Arrays.asList(array));

        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                list
        );

        listViewItem.setAdapter(adapter);

        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}