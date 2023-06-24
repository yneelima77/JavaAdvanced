package Scholar.execute1;
import Scholar.modal1.Department;
import Scholar.modal1.Teacher1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        Teacher1 t1 = new Teacher1();
        t1.setTeachername("Haseeb");
        t1.setSalary("100");

        Teacher1 t2 = new Teacher1();
        t2.setTeachername("Jenny Finch");
        t2.setSalary("10000");

        Teacher1 t3 = new Teacher1();
        t3.setTeachername("James");
        t3.setSalary("25000");

        Teacher1 t4 = new Teacher1();
        t4.setTeachername("SID ROSE");
        t4.setSalary("3000");

        Teacher1 t5 = new Teacher1();
        t5.setSalary("200");
        t5.setTeachername("Ali");

        //Add teacher entity object to the list
        List<Teacher1> teachlist = new ArrayList();
        teachlist.add(t1);
        teachlist.add(t2);
        teachlist.add(t3);
        teachlist.add(t4);
        teachlist.add(t5);
        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        session.persist(t5);

        //Creating Department
        Department department = new Department();
        department.setDname("Development");
        department.setTeacherList(teachlist);

        //Storing Department
        session.persist(department);
        t.commit();
    }

}
