package tdtu.lab06.exam03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MainActivity extends AppCompatActivity {

    ListView listViewN;
    List<Phone> list;
    PhoneAdapter adapter;
    int positionGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewN = findViewById(R.id.listViewN);

        list = new ArrayList<>();

        list.add(new Phone("Item" + (1), false));
        list.add(new Phone("Item" + (2), true));
        list.add(new Phone("Item" + (3), false));
        list.add(new Phone("Item" + (4), true));

        adapter = new PhoneAdapter(
                this,
                R.layout.custom_listview,
                list
        );

        listViewN.setAdapter(adapter);

        registerForContextMenu(this.listViewN);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Phone phone = list.get(info.position);
        if (phone.isCheckSelect() == true) {
            phone.setCheckSelect(true);
        } else {
            phone.setCheckSelect(false);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        positionGet = info.position;
        Phone phone = list.get(positionGet);
        switch (item.getItemId()) {
            case R.id.menu_show_check:

                if (phone.isCheckSelect() == true) {
                    phone.setCheckSelect(false);
                    adapter.notifyDataSetChanged();
                } else {
                    phone.setCheckSelect(true);
                    adapter.notifyDataSetChanged();
                }

                break;

            case R.id.menu_show_delete:
                list.remove(list.get(info.position));
                adapter.notifyDataSetChanged();
                break;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear_list:
                adapter.clearAll();
                break;

            case R.id.menu_show_info:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Author");
                dialog.setMessage("Huỳnh Trần Trung Hiếu - 518H0090");
                dialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
        return true;
    }
}