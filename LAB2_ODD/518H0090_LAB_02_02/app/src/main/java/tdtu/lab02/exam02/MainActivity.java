package tdtu.lab02.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textResult;
    GridView gridTable;
    String[] buttonPress;
    String add = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = (TextView) findViewById(R.id.textResult);
        gridTable = (GridView) findViewById(R.id.gridTable);
        buttonPress = new String[]{
                "0", "1", "2", "3", "4",
                "5","6","7","8","9",".","+","-","X","/","SQRT","V","MOD",
                "DIV","="
        };

        ArrayAdapter adapter = new ArrayAdapter(
                    MainActivity.this,
                    android.R.layout.simple_list_item_1,
                    buttonPress
        );

        gridTable.setAdapter(adapter);

        gridTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                add += buttonPress[position] + " ";
                textResult.setText(add);
            }
        });

    }
}