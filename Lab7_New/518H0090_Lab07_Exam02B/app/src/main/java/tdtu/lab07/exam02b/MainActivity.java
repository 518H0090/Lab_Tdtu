package tdtu.lab07.exam02b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button saveButton;
    private Button readButton;
    private Button listButton;

    private static final String LOG_TAG = "ExternalStorageDemo";
    private static final int REQUEST_ID_READ_PERMISSION = 100;
    private static final int REQUEST_ID_WRITE_PERMISSION = 200;

    private final String fileName = "note.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        saveButton = (Button) findViewById(R.id.button_save);
        readButton = (Button) findViewById(R.id.button_read);
        listButton = (Button) findViewById(R.id.button_list);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                askPermissionAndWriteFile();
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                askPermissionAndReadFile();
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                listExternalStorages();
            }
        });
    }

    private void askPermissionAndWriteFile() {
        boolean canWrite = this.askPermission(REQUEST_ID_WRITE_PERMISSION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(!canWrite)  {
            Toast.makeText(getApplicationContext(),
                    "You do not allow this app to write files.", Toast.LENGTH_LONG).show();
            return;
        }

        this.writeFile();
    }

    private void askPermissionAndReadFile() {
        boolean canRead = this.askPermission(REQUEST_ID_READ_PERMISSION,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        //
        if (!canRead) {
            Toast.makeText(getApplicationContext(),
                    "You do not allow this app to read files.", Toast.LENGTH_LONG).show();
            return;
        }
        //
        this.readFile();
    }

    private boolean askPermission(int requestId, String permissionName) {

        Log.i(LOG_TAG, "Ask for Permission: " + permissionName);
        Log.i(LOG_TAG, "Build.VERSION.SDK_INT: " + android.os.Build.VERSION.SDK_INT);

        if (android.os.Build.VERSION.SDK_INT >= 23) {

            // Check if we have permission
            int permission = ActivityCompat.checkSelfPermission(this, permissionName);

            Log.i(LOG_TAG, "permission: " + permission);
            Log.i(LOG_TAG, "PackageManager.PERMISSION_GRANTED: " + PackageManager.PERMISSION_GRANTED);

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // If don't have permission so prompt the user.
                this.requestPermissions(
                        new String[]{permissionName},
                        requestId
                );
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0) {
            switch (requestCode) {
                case REQUEST_ID_READ_PERMISSION: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        readFile();
                    }
                }
                case REQUEST_ID_WRITE_PERMISSION: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        writeFile();
                    }
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Permission Cancelled!", Toast.LENGTH_SHORT).show();
        }
    }

    // IMPORTANT!!
    public File getAppExternalFilesDir()  {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return this.getExternalFilesDir(null);
        } else {
            return Environment.getExternalStorageDirectory();
        }
    }


    private void writeFile() {
        try {
            File extStore = this.getAppExternalFilesDir( );

            boolean canWrite = extStore.canWrite();
            Log.i(LOG_TAG, "Can write: " + extStore.getAbsolutePath()+" : " + canWrite);

            String path = extStore.getAbsolutePath() + "/" + fileName;
            Log.i(LOG_TAG, "Save to: " + path);

            String data = editText.getText().toString();
            Log.i(LOG_TAG, "Data: " + data);


            File myFile = new File(path);
            FileOutputStream fOut = new FileOutputStream(myFile);
            fOut.write(data.getBytes("UTF-8"));
            fOut.close();

            Toast.makeText(getApplicationContext(), fileName + " saved", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Write Error:" + e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "Write Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void readFile() {

        File extStore = this.getAppExternalFilesDir();

        String path = extStore.getAbsolutePath() + "/" + fileName;
        Log.i(LOG_TAG, "Read file: " + path);

        String s = "";
        String fileContent = "";
        try {
            File myFile = new File(path);
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fIn));

            while ((s = myReader.readLine()) != null) {
                fileContent += s + "\n";
            }
            myReader.close();

            this.textView.setText(fileContent);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Read Error:" + e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "Read Error: " + e.getMessage());
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), fileContent, Toast.LENGTH_LONG).show();
    }

    private void listExternalStorages() {
        StringBuilder sb = new StringBuilder();

        sb.append("Data Directory: ").append("\n - ")
                .append(Environment.getDataDirectory().toString()).append("\n");

        sb.append("Download Cache Directory: ").append("\n - ")
                .append(Environment.getDownloadCacheDirectory().toString()).append("\n");

        sb.append("External Storage State: ").append("\n - ")
                .append(Environment.getExternalStorageState().toString()).append("\n");

        sb.append("External Storage Directory: ").append("\n - ")
                .append(Environment.getExternalStorageDirectory().toString()).append("\n");

        sb.append("Is External Storage Emulated?: ").append("\n - ")
                .append(Environment.isExternalStorageEmulated()).append("\n");

        sb.append("Is External Storage Removable?: ").append("\n - ")
                .append(Environment.isExternalStorageRemovable()).append("\n");

        sb.append("External Storage Public Directory (Music): ").append("\n - ")
                .append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).toString()).append("\n");

        sb.append("Download Cache Directory: ").append("\n - ")
                .append(Environment.getDownloadCacheDirectory().toString()).append("\n");

        sb.append("Root Directory: ").append("\n - ")
                .append(Environment.getRootDirectory().toString()).append("\n");

        Log.i(LOG_TAG, sb.toString());
        this.textView.setText(sb.toString());
    }

}