package Scholar.modal;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int did;
    private String dname;

    @OneToMany(targetEntity=Teacher.class, cascade = {CascadeType.ALL})
    private List teacherList;
    public Department(int did, String dname) {
        super();
        this.did = did;
        this.dname = dname;
    }
    public Department()
    {

    }
    public List getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List teacherList) {
        this.teacherList = teacherList;
    }
    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }

}
