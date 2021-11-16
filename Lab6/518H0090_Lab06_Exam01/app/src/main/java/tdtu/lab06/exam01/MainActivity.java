package tdtu.lab06.exam01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    Button btn_dialog_simple, btn_single_choice ,btn_mutiple_choice;
    int positionChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        iniUI();
        showSimpleDialog();
        showSingleChoice();
        showMutipleChoice();
    }

    private void iniUI() {
        btn_dialog_simple = findViewById(R.id.btn_dialog_simple);
        btn_single_choice = findViewById(R.id.btn_single_choice);
        btn_mutiple_choice = findViewById(R.id.btn_mutiple_choice);

    }

    private void showSimpleDialog() {
        btn_dialog_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Task");
                dialog.setMessage("Dress up like Mario and throw mushrooms at people");
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Option is Yes", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Option is No", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }

    private void showSingleChoice() {
        btn_single_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] optionChoice = {"Coke", "Pepsi", "Sprite", "Seven Up"};
                positionChecked = 0;
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Show Dialog");
                dialog.setSingleChoiceItems(optionChoice, positionChecked, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        positionChecked = which;
                    }
                });

                dialog.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, optionChoice[positionChecked], Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });
    }

    private void showMutipleChoice() {
        btn_mutiple_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] optionChoice = {"Coke", "Pepsi", "Sprite", "Seven Up"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                List<String> stringChoice = new ArrayList<>();
                dialog.setTitle("Show Dialog");
                dialog.setMultiChoiceItems(optionChoice, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked) {
                            stringChoice.add(optionChoice[which]);
                        } else if (stringChoice.contains(optionChoice[which]) ){
                            stringChoice.remove(stringChoice.get(which));
                        }
                    }
                });

                dialog.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String valueGet = "";
                        for (String valueString : stringChoice) {
                            valueGet += valueString +"\n";
                        }
                        Toast.makeText(MainActivity.this, valueGet, Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }

        });
    }


}