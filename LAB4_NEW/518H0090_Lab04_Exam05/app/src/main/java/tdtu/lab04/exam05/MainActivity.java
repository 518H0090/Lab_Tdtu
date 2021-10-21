package tdtu.lab04.exam05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Country> list;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>(addListElement());

        adapter = new CountryAdapter(
                this,
                list
        );

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private List<Country> addListElement() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Vietnam", "vn","Population" + 98000000));
        countries.add(new Country("United States", "us", "Population" + 320000000));
        countries.add(new Country("Russia", "ru", "Population" + 142000000));
        countries.add(new Country("Autraylia", "au", "Population" + 25000000));
        countries.add(new Country("Japan", "jp", "Population" + 126000000));
        return countries;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.onrelease();
    }
}