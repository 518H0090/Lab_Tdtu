package tdtu.lab04.exam04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Country> list;

    public CountryAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }

    public void setList(List<Country> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list != null) {
            return this.list.size();
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

    private class ViewHolder {
        ImageView imgCountry;
        TextView txtName, txtPopulation;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder.imgCountry = convertView.findViewById(R.id.imgCountry);
            viewHolder.txtName = convertView.findViewById(R.id.txtName);
            viewHolder.txtPopulation = convertView.findViewById(R.id.txtPopulation);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Country country = list.get(position);

        viewHolder.imgCountry.setImageResource(country.getImgCountry());
        viewHolder.txtName.setText(country.getNameCountry());
        viewHolder.txtPopulation.setText(country.getPopulationCountry());

        return convertView;
    }
}
