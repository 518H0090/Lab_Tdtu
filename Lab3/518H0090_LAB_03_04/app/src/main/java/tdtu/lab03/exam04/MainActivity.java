package tdtu.lab03.exam04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("518H0090","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("518H0090","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("518H0090","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("518H0090","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("518H0090","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("518H0090","onDestroy");
    }
}