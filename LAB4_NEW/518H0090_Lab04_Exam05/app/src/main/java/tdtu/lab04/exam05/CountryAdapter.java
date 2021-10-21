package tdtu.lab04.exam05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context context;
    private List<Country> countryList;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        if (country == null) {
            return;
        }

        int ResID = context.getResources().getIdentifier(country.getFlagName() , "drawable" , context.getPackageName());
        holder.imageView_flag.setImageResource(ResID);
        holder.textView_countryName.setText(country.getCountryName());
        holder.textView_population.setText(country.getPopulationCountry());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, country.getCountryName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onrelease() {
        context = null;
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView_flag;
        TextView textView_countryName, textView_population;
        RelativeLayout relativeLayout;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView_flag = itemView.findViewById(R.id.imageView_flag);
            textView_countryName = itemView.findViewById(R.id.textView_countryName);
            textView_population = itemView.findViewById(R.id.textView_population);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}
