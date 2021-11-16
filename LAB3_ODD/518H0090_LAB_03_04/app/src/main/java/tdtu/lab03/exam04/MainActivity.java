package tdtu.lab03.exam04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Create","Khởi tạo");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start","Bắt đầu");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume","Chạy lại");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause","Tạm dừng");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop","Dừng tiến trình");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy","Hủy hoặc kết thúc");
    }
}