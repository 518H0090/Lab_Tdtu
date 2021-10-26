package tdtu.lab05.exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    GridView gridView;
    List<String> list;
    ToggleAadapter toggleAadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        list = new ArrayList<String>(addnewValue());

        toggleAadapter = new ToggleAadapter(
                this,
                R.layout.custom_toggle,
                list
        );

        gridView.setAdapter(toggleAadapter);
    }

    private List<String> addnewValue() {
        List<String> arraylist = new ArrayList<>();
        for (int i = 0 ; i < 12 ; i++ ) {
            arraylist.add("PC" + (i+1));
        }
        return arraylist;
    }
}