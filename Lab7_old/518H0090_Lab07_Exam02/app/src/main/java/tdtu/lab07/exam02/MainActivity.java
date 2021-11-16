package tdtu.lab07.exam02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_STORAGE_CODE = 10;
    EditText editTextWrite;
    Button readInternal, readExternal, writeInternal, writeExternal;
    TextView messageInternal, messageExternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initListener();
    }

    private void initUI() {
        editTextWrite = findViewById(R.id.editTextWrite);
        readInternal = findViewById(R.id.readInternal);
        readExternal = findViewById(R.id.readExternal);
        writeInternal = findViewById(R.id.writeInternal);
        writeExternal = findViewById(R.id.writeExternal);
        messageInternal = findViewById(R.id.messageInternal);
        messageExternal = findViewById(R.id.messageExternal);
    }

    private void initListener() {
        writeInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeInternalToFile();
            }
        });

        readInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readInternalFromFile();
            }
        });

        writeExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HasPermission()) {
                    writeExternalToFile();
                } else {
                    requestPermission();
                }

            }
        });

        readExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readExternalFromFile();
            }
        });
    }

    private void writeInternalToFile() {

        String valueWriteFile = editTextWrite.getText().toString().trim();

        if (valueWriteFile.isEmpty()) {
            Toast.makeText(MainActivity.this, "Thiếu Dữ liệu", Toast.LENGTH_SHORT).show();
        } else {

            try {
                FileOutputStream fileOutputStream = openFileOutput("fileInternal", MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(valueWriteFile);
                outputStreamWriter.close();
                fileOutputStream.close();
                Toast.makeText(MainActivity.this, "Lưu Dữ Liệu Thành Công", Toast.LENGTH_SHORT).show();
                editTextWrite.setText("");
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Có Lỗi " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void readInternalFromFile() {

        try {
            FileInputStream fileInputStream = openFileInput("fileInternal");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();
            String lines;

            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }

            messageInternal.setText(stringBuffer.toString());

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Có Lỗi " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void writeExternalToFile() {
        String valueWriteFile = editTextWrite.getText().toString().trim();

        if (valueWriteFile.isEmpty()) {
            Toast.makeText(MainActivity.this, "Thiếu Dữ Liệu", Toast.LENGTH_SHORT).show();
        } else {
            try {
                File file = new File(Environment.getExternalStorageDirectory() , "fileExternal.txt");
                file.createNewFile();

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(valueWriteFile);
                outputStreamWriter.close();
                fileOutputStream.close();
                Toast.makeText(MainActivity.this, "Lưu Dữ Liệu Thành Công", Toast.LENGTH_SHORT).show();
                editTextWrite.setText("");
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Có Lỗi" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void readExternalFromFile() {
        try {
            File file = new File(Environment.getExternalStorageDirectory() , "fileExternal.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();
            String lines;

            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }

            messageExternal.setText(stringBuffer.toString());

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Có Lỗi" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean HasPermission() {
        int code = ContextCompat.checkSelfPermission(this , Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return code == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.READ_EXTERNAL_STORAGE , Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_STORAGE_CODE);
    }


}