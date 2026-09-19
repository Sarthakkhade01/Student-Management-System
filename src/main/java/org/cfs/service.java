package org.cfs;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class service {

    public void addStudent(Student student) {

        String sql = """
                INSERT INTO students (name,email,course,marks) VALUES (?,?,?,?)
                """;


       try {

           Connection connection = DBconfig.getConnection();
           PreparedStatement preparedStatement= connection.prepareStatement(sql);

           preparedStatement.setString(1,student.getName());
           preparedStatement.setString(2,student.getEmail());
           preparedStatement.setString(3,student.getCourse());
           preparedStatement.setDouble(4,student.getMarks());

           int rowAffected = preparedStatement.executeUpdate();
           if(rowAffected>0){
               System.out.println("student added sucesfully");
           }
           preparedStatement.close();
           connection.close();

       }catch (SQLException e){
           System.out.println("error : "+e.getMessage());
       }

    }

    public void viewAllStudent (){
        String sql="SELECT * from students";
        try{
            Connection connection = DBconfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println();
            System.out.println("studemt record");
            System.out.println("____________________");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email= resultSet.getString("email");
                String course= resultSet.getString("course");
                Double marks = resultSet.getDouble("marks");

                System.out.println("ID : "+id);
                System.out.println("name : " +name);
                System.out.println("email : " +email );
                System.out.println("course : "+course);
                System.out.println("marks : " +marks);

                System.out.println("______________________");



            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("error : "+e.getMessage());
        }
    }

    public void searchStudent(int newId){
        String sql = """
                SELECT * FROM students where id=?
                """;

        try{
            Connection connection = DBconfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,1);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                System.out.println();
                System.out.println("student found ");

                System.out.println("ID: "+resultSet.getInt("id"));
                System.out.println("name ; "+resultSet.getString("name"));
                System.out.println("email: "+resultSet.getString("email"));
                System.out.println("marks : "+resultSet.getDouble("marks"));
            }else{
                System.out.println("student is not found ");
            }

        }catch  (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateStudent(int id,String name,String email,String course,double marks){

        String sql=""" 
                UPDATE students
                SET name = ?, email = ?, course = ?, marks = ?
                WHERE id = ?;
                """;

        try {
            Connection connection = DBconfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set values first
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, course);
            preparedStatement.setDouble(4, marks);
            preparedStatement.setInt(5, id);

            //execute only after setting all values

            int rows = preparedStatement.executeUpdate();

            System.out.println("rows afected "+rows);
            if(rows>0){
                System.out.println("syudent ubdated succefully ");
            }else {
                System.out.println("student not found ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void DeleteStudent(int id){

        String sql= """
                DELETE * FROM students 
                WHERE id=? 
                """;
        try{
            Connection connection = DBconfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            int row =preparedStatement.executeUpdate();

            if(row > 0){
                System.out.println("student delete succesfully");
            }else {
                System.out.println("student not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


}
