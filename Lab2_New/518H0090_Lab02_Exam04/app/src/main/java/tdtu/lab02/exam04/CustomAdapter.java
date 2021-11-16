package tdtu.lab02.exam04;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Language> list;

    public CustomAdapter(Context context, int layout, List<Language> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return this.list.size();
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
        TextView textView_item_name,textView_item_percent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null ){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.spinner_item_layout_resource,parent,false);

            viewHolder.textView_item_name = (TextView) convertView.findViewById(R.id.textView_item_name);
            viewHolder.textView_item_percent = (TextView) convertView.findViewById(R.id.textView_item_percent);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Language language = list.get(position);
        viewHolder.textView_item_name.setText(language.getName());
        viewHolder.textView_item_percent.setText(language.getPercent() + "%");

        return convertView;
    }
}
