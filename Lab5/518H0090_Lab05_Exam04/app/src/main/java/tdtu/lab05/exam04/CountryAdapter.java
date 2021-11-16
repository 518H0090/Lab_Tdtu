package tdtu.lab05.exam04;

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

    public CountryAdapter(Context context, int layout, List<Country> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    private class ViewHolder {
        ImageView imgView;
        TextView txtCountry, txtPopulation;
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

            viewHolder.imgView =convertView.findViewById(R.id.imgView);
            viewHolder.txtCountry =convertView.findViewById(R.id.txtCountry);
            viewHolder.txtPopulation =convertView.findViewById(R.id.txtPopulation);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Country country = list.get(position);
        int ImgID = context.getResources().getIdentifier(country.getCountryImageName() , "drawable" , context.getPackageName());

        viewHolder.imgView.setImageResource(ImgID);
        viewHolder.txtCountry.setText(country.getCountryName());
        viewHolder.txtPopulation.setText(String.valueOf(country.getCountryPopulation()));

        return convertView;
    }
}
