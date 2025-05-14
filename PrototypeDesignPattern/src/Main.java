interface Prototype{
    Student clone();
}
class Student implements Prototype{
    String name ;
    private int rollNumber;
    private String batch;
    Student(){}
    Student(String name,int rollNumber,String batch){
        this.name = name;
        this.rollNumber = rollNumber;
        this.batch = batch;
    }
    @Override
    public Student clone(){
        return new Student(name,rollNumber,batch);
    }
}
public class Main {
    public static void main(String[] args) {
        Student student = new Student("aflah",2,"CS");
        Student cloneStudent = student.clone();
        System.out.println(cloneStudent.name);
    }
}