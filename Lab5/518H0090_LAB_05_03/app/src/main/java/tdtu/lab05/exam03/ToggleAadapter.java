package tdtu.lab05.exam03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class ToggleAadapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> list;

    public ToggleAadapter(Context context, int layout, List<String> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    private class ViewHolder {
        ToggleButton toggleButton;
        TextView pcView;
    }

    @Override
    public int getCount() {
        return list.size();
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
            convertView = inflater.inflate(layout,null);

            viewHolder.toggleButton = convertView.findViewById(R.id.toggleButton);
            viewHolder.pcView = convertView.findViewById(R.id.pcView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String pc = list.get(position);
        viewHolder.pcView.setText(pc);

        return convertView;
    }
}
