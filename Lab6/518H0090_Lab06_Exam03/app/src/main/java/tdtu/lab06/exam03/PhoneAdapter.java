package tdtu.lab06.exam03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class PhoneAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Phone> list;

    public PhoneAdapter() {
    }

    public PhoneAdapter(Context context, int layout, List<Phone> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    private class ViewHolder {
        TextView phoneName;
        CheckBox checkBox;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder.phoneName = convertView.findViewById(R.id.phoneName);
            viewHolder.checkBox = convertView.findViewById(R.id.checkBox);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Phone phone = list.get(position);

        String phonename = phone.getPhoneName();
        viewHolder.phoneName.setText(phonename);
        viewHolder.checkBox.setChecked(phone.isCheckSelect());

        return convertView;
    }

    public void clearAll() {
        list.clear();
        notifyDataSetChanged();
    }

}
