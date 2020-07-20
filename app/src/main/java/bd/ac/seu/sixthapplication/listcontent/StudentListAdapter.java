package bd.ac.seu.sixthapplication.listcontent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bd.ac.seu.sixthapplication.R;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentListView> {

    ArrayList<Student> students;
    Context context;

    public StudentListAdapter(ArrayList<Student> students,Context context){
        this.students = students;
        this.context=context;
    }

    @NonNull
    @Override
    public StudentListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.adapter_student_list,null);
        return new StudentListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListView holder, int position) {
        Student student =this.students.get(position);
        holder.name.setText("Name : "+student.getName());
        holder.dept.setText("Department : "+student.getDept());
        holder.id.setText("ID : "+student.getId());


    }

    @Override
    public int getItemCount() {

        return students.size();
    }

    class StudentListView extends RecyclerView.ViewHolder{
        TextView name,dept,id;

        public StudentListView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.student_name);
            dept = itemView.findViewById(R.id.department);
            id = itemView.findViewById(R.id.student_id);
        }
    }
}
