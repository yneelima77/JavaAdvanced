package contoller;

import model.Student;
import view.StudentView;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setname(String name) {
        this.model.setName(name);
    }
    public String getname(){
        return this.model.getName();
    }
    public void setrollNum(String rollNum) {
        this.model.setRoolNum(rollNum);
    }

    public String getrollNum(){
        return this.model.getRoolNum();
    }

    public  void updateView(){
        view.printStudentDetails(model.getName(), model.getRoolNum());
    }
}