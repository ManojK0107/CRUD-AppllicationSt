import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

public class Main {
       static Scanner sc = new Scanner(System.in);
       static StudentTeacher s1 = new StudentTeacher();
       static StudentTeacher t1 = new StudentTeacher();
    public static void main(String[] args) {
       insertStudent();
       selectStudent();
       updateStudent();
       deleteStudent();
       insertTeacher();
       selectTeacher();
       updateTeacher();
       deleteTeacher();
    }
    static void  insertStudent(){
        try {
            System.out.println("Enter Student RollNo:-");
            s1.setRollNo(sc.nextInt());
            System.out.println("Enter Student Name:-");
            s1.setName(sc.next());
            System.out.println("Enter Student Email:-");
            s1.setEmail(sc.next());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            Statement stmt= con.createStatement();
            stmt.executeUpdate("insert into info values('"+s1.getRollNo()+"','"+s1.getName()+"','"+s1.getEmail()+"')");
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static void selectStudent(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from info");
            while (rs.next()){
                System.out.print(rs.getString("rollNo"));
                System.out.println("");
                System.out.print(rs.getString("name"));
                System.out.println("");
                System.out.print(rs.getString("email"));
            }
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static  void updateStudent(){
        try {
            System.out.println("Enter updated Student RollNo:-");
            s1.setRollNo(sc.nextInt());
            System.out.println("Enter Student Name:-");
            s1.setName(sc.next());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            Statement stmt= con.createStatement();
            stmt.executeUpdate("update info set rollNo='"+s1.getRollNo()+"' where name='"+s1.getName()+"'");
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static  void  deleteStudent(){
        try {
            System.out.println("Enter Student RollNo:-");
            s1.setRollNo(sc.nextInt());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            Statement stmt= con.createStatement();
            int count=stmt.executeUpdate("delete from info where rollNo='"+s1.getRollNo()+"'");
            if (count>0){
                System.out.println("Student Data Deleted From Database");
            }
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
         static  void insertTeacher(){
             try {
                 System.out.println("Enter Teacher Id:-");
                 t1.setId(sc.nextInt());
                 System.out.println("Enter Teacher Name:-");
                 t1.setTname(sc.next());
                 System.out.println("Enter Teacher Email:-");
                 t1.setTemail(sc.next());
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
                 Statement stmt= con.createStatement();
                 stmt.executeUpdate("insert into teacher values('"+t1.getId()+"','"+t1.getTname()+"','"+t1.getTemail()+"')");
                 con.close();
             }
             catch (Exception e){
                 System.out.println(e);
             }
         }
          static void selectTeacher(){
              try {
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
                  Statement stmt= con.createStatement();
                  ResultSet rs=stmt.executeQuery("select * from teacher");
                  while (rs.next())
                  {
                      System.out.print(rs.getString("id"));
                      System.out.print("");
                      System.out.print(rs.getString("tname"));
                      System.out.print("");
                      System.out.print(rs.getString("temail"));
                  }
                  con.close();
              }
              catch (Exception e){
                  System.out.println(e);
              }
          }
         static void updateTeacher(){
             try {
                 System.out.println("Enter Updated Teacher Id:-");
                 t1.setId(sc.nextInt());
                 System.out.println("Enter Teacher Name:-");
                 t1.setTname(sc.next());
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
                 Statement stmt= con.createStatement();
                 stmt.executeUpdate("update teacher set id='"+t1.getId()+"'where tname='"+t1.getTname()+"'");
                 con.close();
             }
             catch (Exception e){
                 System.out.println(e);
             }
         }
         static void deleteTeacher(){
             try {
                 System.out.println("Enter Teacher Id:-");
                 t1.setId(sc.nextInt());
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
                 Statement stmt= con.createStatement();
                 int count=stmt.executeUpdate("delete from teacher where id='"+t1.getId()+"'");
                 if (count>0){
                     System.out.println("Teacher record deleted");
                 }
                 con.close();
             }
             catch (Exception e){
                 System.out.println(e);
             }
         }

}