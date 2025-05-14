import java.util.LinkedList;
import java.util.List;

class Student{
    String name;
    int rollNumber;
    String fatherName;
    String motherName;
    List<String> subjects;

    Student(String name,int rollNumber,String fatherName,String motherName,List<String> subjects){
        this.rollNumber = rollNumber;
        this.name = name;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.subjects = subjects;
    }
    @Override
    public String toString(){
        return "name : "+this.name+"\nroll number : "+this.rollNumber+"\nfather name :"+fatherName+"\nmother name :"+motherName+"\n subjects : "+subjects;
    }
}

abstract class StudentBuilder{
    String name;
    int rollNumber;
    String fatherName;
    String motherName;
    List<String> subjects;

    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }
    public StudentBuilder setRoll(int roll){
        this.rollNumber = roll;
        return this;
    }
    public StudentBuilder setFather(String name){
        this.fatherName = name;
        return this;
    }
    public StudentBuilder setMother(String name){
        this.motherName = name;
        return this;
    }

    abstract public StudentBuilder setSubjects();
    public Student build(){
        return new Student(this.name,this.rollNumber,this.fatherName,this.motherName,this.subjects);
    }
}

class ElectronicsStudent extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects(){
        List<String> subjects = new LinkedList<>();
        subjects.add("Electrical");
        subjects.add("Electronics");
        subjects.add("signals");
        this.subjects = subjects;
        return this;
    }
}
class ComputerStudent extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects(){
        List<String> subjects = new LinkedList<>();
        subjects.add("CS");
        subjects.add("DSA");
        subjects.add("CN");
        this.subjects = subjects;
        return this;
    }
}

class Director{
    StudentBuilder studentBuilder;
    Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }
    public Student createStudent(){
        if(studentBuilder instanceof ElectronicsStudent){
            return createElectronicsStudent();
        }
        else{
            return createComputerScienceStudent();
        }
    }

    private Student createComputerScienceStudent() {
        return studentBuilder.setName("aflah").setFather("mohammed").setMother("sauda").setSubjects().build();
    }

    private Student createElectronicsStudent() {
        return studentBuilder.setName("sreesanth").setFather("hari").setMother("sri").setRoll(4).setSubjects().build();
    }
}

public class BuilderMain {
    public static void main(String[] args) {
            Director director = new Director(new ComputerStudent());
            Director director2 = new Director(new ElectronicsStudent());
            Student student = director.createStudent();
            Student student1 = director2.createStudent();
            System.out.println(student);
            System.out.println(student1);
    }
}
