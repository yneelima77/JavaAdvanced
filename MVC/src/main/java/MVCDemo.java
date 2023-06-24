import contoller.StudentController;
import model.Student;
import view.StudentView;

public class MVCDemo {

    private static Student retriveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Robert");
        student.setRoolNum("10");
        return student;
    }
    public static void main(String[] args) {
        //Fetch student record based on his roll number from database
        Student model = retriveStudentFromDatabase();

        //create a view: to write the student details on console
        StudentView view = new StudentView();
        StudentController studentController = new StudentController(model,view);
        studentController.updateView();

        //update the model data
        studentController.setname("Jhon");
        studentController.updateView();
    }
}
