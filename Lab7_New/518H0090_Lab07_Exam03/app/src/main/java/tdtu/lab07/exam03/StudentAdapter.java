package tdtu.lab07.exam03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<STUDENT> list;
    private IStudentOption iStudentOption;

    public StudentAdapter(Context context, int layout, List<STUDENT> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    public void setiStudentOption(IStudentOption iStudentOption) {
        this.iStudentOption = iStudentOption;
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

    private class ViewHolder {
        TextView studentNameShow , studentClassShow, studentIdShow;
        Button btnRemove;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder.studentNameShow = convertView.findViewById(R.id.studentNameShow);
            viewHolder.studentClassShow = convertView.findViewById(R.id.studentClassShow);
            viewHolder.studentIdShow = convertView.findViewById(R.id.studentIdShow);
            viewHolder.btnRemove = convertView.findViewById(R.id.btnRemove);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        STUDENT student = list.get(position);

        viewHolder.studentIdShow.setText(String.valueOf(student.getID()));
        viewHolder.studentNameShow.setText(student.getSTUDENTNAME());
        viewHolder.studentClassShow.setText(student.getCLASS());
        viewHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iStudentOption.onDeleteStudent(position);
            }
        });


        return convertView;
    }
}
