package org.cfs;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        service service = new service();
        int choice;

        do{
            System.out.println();
            System.out.println("=== student management system ===");

            System.out.println("1. add student: ");
            System.out.println("2. view all student: ");
            System.out.println("3. search student: ");
            System.out.println("4. ubdate student :");
            System.out.println("5. delete studemt");
            System.out.println("6. exit");

            System.out.println("enter your choice ");
            choice=scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("enter the student ID: ");
                    int id =scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("enter student name ");
                    String name = scanner.nextLine();

                    System.out.println("enter student email: ");
                    String email=scanner.nextLine();

                    System.out.println("enter the course : ");
                    String course = scanner.nextLine();

                    System.out.println("enter the marks");
                    double marks=scanner.nextDouble();

                    Student student=new Student(id,name,email,course,marks);
                    service.addStudent(student);
                    break;


                case 2:
                        service.viewAllStudent();
                        break;
                case 3:
                    System.out.println("enter the student ID: ");
                    int newId =scanner.nextInt();
                    scanner.nextLine();

                    service.searchStudent(newId);
                    break;

                case 4://ubdate

                    System.out.println("Enter student ID to update:");
                    int UBid = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter new student name:");
                    String UBname = scanner.nextLine();

                    System.out.println("Enter new student email:");
                    String UBemail = scanner.nextLine();

                    System.out.println("Enter new course:");
                    String UBcourse = scanner.nextLine();

                    System.out.println("Enter new marks:");
                    double UBmarks = scanner.nextDouble();

                    service.updateStudent(UBid,UBname,UBemail,UBcourse,UBmarks);

                    break;

                case 5:

                    System.out.println("Enter student ID to delete:");
                    int DEid = scanner.nextInt();
                    scanner.nextLine();

                    service.DeleteStudent(DEid);
                    break;

                case 6:
                    System.out.println("Application closed: ");
                    break;

                default:
                    System.out.println("invalid choice ");

            }
        }while(choice!=6);
            scanner.close();
        }





    }

