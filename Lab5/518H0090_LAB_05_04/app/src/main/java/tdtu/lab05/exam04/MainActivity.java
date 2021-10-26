package tdtu.lab05.exam04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    GridView gridCountry;
    List<Country> list;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridCountry = findViewById(R.id.gridCountry);
        list = new ArrayList<Country>(addGridView());

        adapter = new CountryAdapter(
                this,
                R.layout.custom_gridview,
                list
        );

        gridCountry.setAdapter(adapter);

        gridCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = list.get(position);
                Toast.makeText(MainActivity.this, country.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Country> addGridView() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("vn" , "Vietnam", 98000000));
        list.add(new Country("us" , "United States", 320000000));
        list.add(new Country("ru" , "Russia", 142000000));
        list.add(new Country("au" , "Australia", 23766305));
        list.add(new Country("jp" , "Japan", 126788677));
        return list;
    }
}