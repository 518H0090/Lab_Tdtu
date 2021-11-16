package tdtu.lab04.exam04;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<User> userList;

    public UserAdapter(Context context, int layout, List<User> userList) {
        this.context = context;
        this.layout = layout;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtUser, txtPass;
        Button btnRemove;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            viewHolder.txtUser = (TextView) convertView.findViewById(R.id.txtUser);
            viewHolder.txtPass = (TextView) convertView.findViewById(R.id.txtPass);
            viewHolder.btnRemove = (Button) convertView.findViewById(R.id.btnRemove);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User user = userList.get(position);
        viewHolder.txtUser.setText(user.getUsername());
        viewHolder.txtPass.setText(user.getPassword());
        viewHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userList.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
