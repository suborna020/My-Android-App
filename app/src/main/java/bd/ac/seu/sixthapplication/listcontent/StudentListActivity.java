package bd.ac.seu.sixthapplication.listcontent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bd.ac.seu.sixthapplication.R;

public class StudentListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Student> students;
    StudentListAdapter studentListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);//red warn ashbe ,tokhon import class korbo
    }

    @Override

    protected void onStart() {
        super.onStart();
        recyclerView =findViewById(R.id.studentListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        students=new ArrayList<>();
        //add data
        students.add(new Student("a","cse","001"));
        students.add(new Student("b","eee","002"));
        students.add(new Student("c","cse","003"));
        students.add(new Student("d","phm","004"));
        students.add(new Student("e","mba","005"));
        students.add(new Student("f","cse","006"));
        students.add(new Student("g","eee","007"));

        studentListAdapter=new StudentListAdapter(students,this);
        recyclerView.setAdapter(studentListAdapter);
    }
}