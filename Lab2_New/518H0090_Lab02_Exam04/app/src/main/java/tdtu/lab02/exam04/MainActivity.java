package tdtu.lab02.exam04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private List<Language> languages;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spinner = (Spinner) this.findViewById(R.id.spinner_language);
        languages = new ArrayList<Language>();
        languages.add(new Language(1,"Javascript", 67.7f));
        languages.add(new Language(2,"HTML/CSS", 63.1f));
        languages.add(new Language(3,"SQL", 54.7f));
        languages.add(new Language(4,"Python", 44.1f));
        languages.add(new Language(5, "Java", 40.2f));

        adapter = new CustomAdapter(
                MainActivity.this,
                R.layout.spinner_item_layout_resource,
                languages
        );

        spinner.setAdapter(adapter);

    }
}