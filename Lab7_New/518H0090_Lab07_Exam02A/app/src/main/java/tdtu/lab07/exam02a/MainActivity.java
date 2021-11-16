package tdtu.lab07.exam02a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private Button readButton;

    private TextView textView;
    private EditText editText;

    private String simpleFileName = "note.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.saveButton = (Button) this.findViewById(R.id.button_save);
        this.readButton = (Button) this.findViewById(R.id.button_read);
        this.textView = (TextView) this.findViewById(R.id.textView);
        this.editText = (EditText) this.findViewById(R.id.editText);

        this.saveButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        this.readButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                readData();
            }
        });
    }


    private void saveData() {
        String data = this.editText.getText().toString();
        try {
            FileOutputStream out = this.openFileOutput(simpleFileName, MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);

            outputStreamWriter.write(data);
            outputStreamWriter.close();
            Toast.makeText(this,"File saved!",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void readData() {
        try {
            FileInputStream in = this.openFileInput(simpleFileName);
            InputStreamReader inputStreamReader = new InputStreamReader(in);

            BufferedReader br= new BufferedReader(inputStreamReader);

            StringBuilder sb= new StringBuilder();
            String s;

            while((s= br.readLine())!= null)  {
                sb.append(s).append("\n");
            }
            this.textView.setText(sb.toString());

        } catch (Exception e) {
            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

}