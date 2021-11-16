package tdtu.lab07.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {


    private SeekBar seekBarSound ;
    private SeekBar seekBarBrightness;

    private RadioGroup radioGroupDiffLevel;
    private RadioButton radioButtonEasy;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonHard;

    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.seekBarBrightness= (SeekBar)this.findViewById(R.id.seekBar_brightness);
        this.seekBarSound= (SeekBar)this.findViewById(R.id.seekBar_sound);

        this.seekBarBrightness.setMax(100);
        this.seekBarSound.setMax(100);

        this.radioGroupDiffLevel= (RadioGroup) this.findViewById(R.id.radioGroup_diffLevel);
        this.radioButtonEasy=(RadioButton) this.findViewById(R.id.radioButton_easy);

        this.radioButtonMedium = (RadioButton)this.findViewById(R.id.radioButton_medium);
        this.radioButtonHard=(RadioButton) this.findViewById(R.id.radioButton_hard);

        this.buttonSave = (Button) this.findViewById(R.id.button_save);

        this.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.doSave(view);
            }
        });

        this.loadGameSetting();
    }


    private void loadGameSetting()  {
        //Khởi tạo sharedpreferences
        SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);

        //Nếu có giá trị thì thiết lập.
        if(sharedPreferences!= null) {

            //Lấy giá trị
            int brightness = sharedPreferences.getInt("brightness", 0);
            int sound = sharedPreferences.getInt("sound",0);
            int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", R.id.radioButton_medium);

            //Thiết lập giá trị
            this.seekBarSound.setProgress(sound);
            this.seekBarBrightness.setProgress(brightness);
            this.radioGroupDiffLevel.check(checkedRadioButtonId);

            //Nếu chưa có dữ liệu thì mặc định set chọn radiobutton là medium
        } else {
            this.radioGroupDiffLevel.check(R.id.radioButton_medium);
            Toast.makeText(this,"Use the default game setting",Toast.LENGTH_LONG).show();
        }

    }

    //Logic xử lý khi bấm save
    public void doSave(View view)  {
        //Gọi Shared Preferences
        SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);

        //Editor dùng để chỉnh sửa.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Set dữ liệu
        editor.putInt("brightness", this.seekBarBrightness.getProgress());
        editor.putInt("sound", this.seekBarSound.getProgress());

        int checkedRadioButtonId = radioGroupDiffLevel.getCheckedRadioButtonId();

        editor.putInt("checkedRadioButtonId", checkedRadioButtonId);

        //Lưu dữ liệu
        editor.commit();

        Toast.makeText(this,"Game Setting saved!",Toast.LENGTH_LONG).show();
    }
}