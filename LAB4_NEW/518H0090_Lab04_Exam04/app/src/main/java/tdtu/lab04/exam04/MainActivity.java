package tdtu.lab04.exam04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    private ListView listViewCustom;
    private CountryAdapter adapter;
    private List<Country> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCustom = findViewById(R.id.listViewCustom);
        list = new ArrayList<>();

        adapter = new CountryAdapter(
                this,
                R.layout.custom_listview
        );

        adapter.setList(addNewCountry());

        listViewCustom.setAdapter(adapter);

        listViewCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country countryItem = list.get(position);
                Toast.makeText(MainActivity.this, "Selected " + countryItem , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<Country> addNewCountry() {
        list.add(new Country(R.drawable.vn,"Vietnam","Population : 98000000"));
        list.add(new Country(R.drawable.us,"United States","Population : 32000000000"));
        list.add(new Country(R.drawable.ru,"Russia","Population : 14200000000"));
        return list;
    }
}