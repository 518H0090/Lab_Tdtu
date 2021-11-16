package tdtu.lab01.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    CheckBox checkAndroid,checkIOS,checkWindows,checkRIM;
    Button btnClick,btnClickRadio;
    TextView textResult,textResultRadio;
    RadioGroup radioGroup;
    RadioButton radioAndroid,radioIOS,radioWindows,radioRIM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Declare();
        CheckClick();
        RadioClick();


    }

    private void RadioClick() {
        btnClickRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Results = "The following were selected... \n";
                if (radioAndroid.isChecked()) {
                    Results += "Android:true \n";
                } else {
                    Results += "Android:false \n";
                }

                if (radioIOS.isChecked()) {
                    Results += "IOS:true \n";
                } else {
                    Results += "IOS:false \n";
                }

                if (radioWindows.isChecked()) {
                    Results += "Windows:true \n";
                } else {
                    Results += "Windows:false \n";
                }

                if (radioRIM.isChecked()) {
                    Results += "RIM:true \n";
                } else {
                    Results += "RIM:false \n";
                }

                textResultRadio.setText(Results);
            }
        });
    }

    private void CheckClick() {
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Results = "The following were selected... \n";
                if (checkAndroid.isChecked()) {
                    Results += "Android:true \n";
                } else {
                    Results += "Android:false \n";
                }

                if (checkIOS.isChecked()) {
                    Results += "IOS:true \n";
                } else {
                    Results += "IOS:false \n";
                }

                if (checkWindows.isChecked()) {
                    Results += "Windows:true \n";
                } else {
                    Results += "Windows:false \n";
                }

                if (checkRIM.isChecked()) {
                    Results += "RIM:true \n";
                } else {
                    Results += "RIM:false \n";
                }

                textResult.setText(Results);
            }
        });
    }

    private void Declare() {
        checkAndroid = (CheckBox) findViewById(R.id.checkAndroid);
        checkIOS = (CheckBox) findViewById(R.id.checkIOS);
        checkWindows = (CheckBox) findViewById(R.id.checkWindows);
        checkRIM = (CheckBox) findViewById(R.id.checkRIM);

        btnClick = (Button) findViewById(R.id.btnClick);
        btnClickRadio = (Button) findViewById(R.id.btnClickRadio);

        textResult = (TextView) findViewById(R.id.textResult);
        textResultRadio = (TextView) findViewById(R.id.textResultRadio);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioAndroid = (RadioButton) findViewById(R.id.radioAndroid);
        radioIOS = (RadioButton) findViewById(R.id.radioIOS);
        radioWindows = (RadioButton) findViewById(R.id.radioWindows);
        radioRIM = (RadioButton) findViewById(R.id.radioRIM);
    }
}