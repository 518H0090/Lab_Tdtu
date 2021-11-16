package tdtu.lab02.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

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
                "5","6","7","8","9",".","+","-","X","/","","","back",
                "clear","="
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
                if (buttonPress[position].isEmpty()){
                    Toast.makeText(MainActivity.this, "Nút Nhấn Không tồn tại", Toast.LENGTH_SHORT).show();
                } else {
                    if (buttonPress[position].equals("clear")) {
                        add = "";
                    } else if (buttonPress[position].equals("back")) {
                        int length = add.length();
                        add = add.substring(0,length-1);
                    }
                    else {
                        add += buttonPress[position] + "";
                    }
                    textResult.setText(add);
                }

            }
        });

    }
}