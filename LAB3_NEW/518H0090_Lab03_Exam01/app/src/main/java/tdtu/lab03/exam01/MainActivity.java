package tdtu.lab03.exam01;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//̀518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    EditText editEmail;
    Button btnLogin;
    TextView textShow;
    private final ActivityResultLauncher<Intent> mActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                String getName = intent.getStringExtra("name");
                String getText = intent.getStringExtra("text");
                editEmail.setText(getName);
                textShow.setText(getText);
//                editEmail.setEnabled(false);
                btnLogin.setVisibility(View.INVISIBLE);
                btnLogin.setEnabled(false);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Declare();
        btnLoginClick();

//        Intent intent = this.getIntent();
//        String getName = intent.getStringExtra("name");
//        String getText = intent.getStringExtra("text");
//
//
//
//        if(getName != null) {
//            editEmail.setText(getName);
//            textShow.setText(getText);
//            editEmail.setEnabled(false);
//            btnLogin.setVisibility(View.INVISIBLE);
//            btnLogin.setEnabled(false);
//
//        }



    }

    private void btnLoginClick() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                if(email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("email",email);
//                    startActivity(intent);
                    mActivityResult.launch(intent);
                }
            }
        });
    }

    private void Declare() {
        editEmail = (EditText) findViewById(R.id.editEmail);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textShow = (TextView) findViewById(R.id.textShow);
    }
}