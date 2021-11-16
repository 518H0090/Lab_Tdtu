package tdtu.lab04.exam04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>{

    private Context context;
    private int layout;
    private List<Employee> employeeList;

    public EmployeeAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        if (employee == null ) {
            return;
        }
        holder.txtEName.setText(employee.getEName());
        holder.txtEDepartment.setText(employee.getEDepartment());
        holder.imgEmployee.setImageResource(employee.getEImage());
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtEName, txtEDepartment;
        ImageView imgEmployee;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            txtEName = (TextView) itemView.findViewById(R.id.txtEName);
            txtEDepartment = (TextView) itemView.findViewById(R.id.txtEDepartment);
            imgEmployee = (ImageView) itemView.findViewById(R.id.imgEmployee);
        }
    }
}
