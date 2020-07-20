package bd.ac.seu.sixthapplication.listcontent;

public class Student {
    private String name;
    private String dept;
    private String id;
    public Student(String name,String dept,String id) {
        this.name = name;
        this.dept = dept;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

