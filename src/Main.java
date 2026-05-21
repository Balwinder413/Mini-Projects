import java.sql.*;
import java.util.*;
public class Main{
    static final String url="jdbc:mysql://localhost:3306/logindb";
    static final String username="root";
    static final String password="231023";
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            int choice;
            do{
                System.out.println("=====LOGIN SYSTEM====");
                System.out.println("1. Register");
                System.out.println("2.Login");
                System.out.println("3.Exit");
                System.out.println("Enter the choice");
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter username");
                        String user= sc.nextLine();
                        sc.nextLine();
                        System.out.println("Enter password");
                        int pass= sc.nextInt();

                        String query="INSERT INTO user(username,password)VALUES(?,?)";
                        PreparedStatement preparedStatement= con.prepareStatement(query);
                        preparedStatement.setString(1, user);
                        preparedStatement.setInt(2, pass);
                        int rows= preparedStatement.executeUpdate();
                        if(rows>0){
                            System.out.println("Registration succesful");

                        }
                        break;
                    case 2:
                        sc.nextLine();

                        System.out.println("Enter username");
                        String loginuser= sc.nextLine();
                        System.out.println("enter password");
                        int passlogin= sc.nextInt();
                        String loginquery= "SELECT * FROM user WHERE username=? AND password=?";
                        PreparedStatement preparedStatement2= con.prepareStatement(loginquery);
                        preparedStatement2.setString(1, loginuser);
                        preparedStatement2.setInt(2, passlogin);
                        ResultSet rs= preparedStatement2.executeQuery();
                        if(rs.next()){
                            System.out.println("Login succesfuly");
                        }else{
                            System.out.println("Invalid username and password");

                        }
                        break;
                    case 3:
                        System.out.println("Program exited");
                        break;
                    default:
                        System.out.println("invalid choice");

                }
            } while(choice!=3);
            con.close();
        }catch( Exception e){
            System.out.println(e);
        }
        sc.close();
    }


}