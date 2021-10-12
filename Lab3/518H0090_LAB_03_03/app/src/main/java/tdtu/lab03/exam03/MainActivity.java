package tdtu.lab03.exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    EditText editLink;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLink = (EditText) findViewById(R.id.editLink);
        btnClick = (Button) findViewById(R.id.btnClick);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editLink.getText().toString();
                if(url.equals("https://") || url.equals("") || url.equals("http://")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đường dẫn", Toast.LENGTH_SHORT).show();
                }
                else if (url.startsWith("https://") || url.startsWith("http://")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url),MainActivity.this,MainActivity2.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đúng định dạng", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}