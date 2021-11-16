package tdtu.lab07.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    TextView textCountNumberOpen;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initUI();

        if (sharedPreferences == null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            textCountNumberOpen.setText(String.valueOf(1));
            editor.putInt("numberCount", 1);
            editor.commit();
        } else {
            int CountNumber = sharedPreferences.getInt("numberCount",0);
            int CountNumberPlus = CountNumber+1;
            textCountNumberOpen.setText(String.valueOf(CountNumberPlus));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("numberCount", CountNumberPlus);
            editor.commit();
        }
    }

    private void initUI() {
        textCountNumberOpen = findViewById(R.id.textCountNumberOpen);
        sharedPreferences = getSharedPreferences("CountNumBerOpen", MODE_PRIVATE);
    }
}