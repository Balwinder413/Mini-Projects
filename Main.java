import java.util.ArrayList;
import java.util.Scanner;

class Student{
     int id;
     String name;
     int age;
     Student(int i, String n, int a){
        this.id= i;
        this.name=n;
        this.age= a;
     }
     void display(){
        System.out.println("id" +  id);
        System.out.println("name"+  name);
        System.out.println("age" +  age);
     }
}
public class Main{
    public static void main(String[] args) {
        ArrayList<Student>students=new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        int choice;
        do{
         System.out.println("=======Student Management System=====");
         System.out.println("1.Add student");
         System.out.println("2.View student");
         System.out.println("3.Search student");
         System.out.println("4.Exit");
         choice =sc.nextInt();
         switch(choice){
            case 1:
               System.out.println("Enter the id");
               int id= sc.nextInt();
               System.out.println("Enter the name");
               String name= sc.next();
               System.out.println("Enter the age");
               int age= sc.nextInt();
               students.add(new Student(id,name ,age));
               System.out.println("Succesful added");
               break;

               case 2:
                  if(students.isEmpty()){
                     System.out.println("No Students found");
                  }else{
                     for(Student s:students){
                        s.display();
                     }
                  }
                  break;

                  case 3:
                     System.out.println("Enter the Student id to search");
                     int searchId= sc.nextInt();
                     boolean found= false;
                     for(Student s:students){
                        if(s.id== searchId){
                           s.display();
                           found=true;

                        }
                     }
                     if(!found){
                        System.out.println("Studnet not found");
                     }
                     break;

                     case 4:
                     System.out.println("Program exit");
                     break;

                     default:
                     System.out.println("Invalid choice");

         }
        }
        while(choice!=4);
        sc.close();
    }
}