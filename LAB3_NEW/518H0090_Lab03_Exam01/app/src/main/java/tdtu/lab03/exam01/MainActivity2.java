package tdtu.lab03.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//518H0090 - Huỳnh Trần Trung Hiếu.
public class MainActivity2 extends AppCompatActivity {

    EditText editName;
    Button btnOut;
    TextView textIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Declare();
        setTextViewIntent();


        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Vui lòng nhập tên", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("text","Hẹn gặp lại");
//                    startActivity(intent);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });


    }

    private void setTextViewIntent() {
        Intent intent = this.getIntent();
        String Email = intent.getStringExtra("email");

        textIntent.setText("Xin chào, " +Email+ " .Vui lòng nhập tên");
    }

    private void Declare() {
        editName = (EditText) findViewById(R.id.editName);
        btnOut = (Button) findViewById(R.id.btnOut);
        textIntent = (TextView) findViewById(R.id.textIntent);
    }
}