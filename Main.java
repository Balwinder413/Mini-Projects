import java.util.Scanner;

class Bankaccount{
    int accno;
     String name;
     double balance;
     // constructor
     Bankaccount(int i ,String n, double b){
        this.accno=i;
        this.name=n;
        this.balance=b;
     }
     //deposit
     void deposit(double amount){
        balance=balance + amount;
            System.out.println("Amount deposited succesful");
        }
        // withdraw method
      void withdraw(double amount){
        if(amount<=balance){
             balance= balance - amount;
             System.out.println("Withdraw succesfuly");
        }
        else{
            System.out.println("Insufficent balance");
        }
      } 
      
      // display
      void display(){
        System.out.println("Account No:" + accno);
        System.out.println("Name: "+ name);
        System.out.println("Balance: "+ balance);
    }
}
class SavingAccount extends Bankaccount{
    SavingAccount(int accno, String name, double balance){
    super(accno,name,balance);
    }
    // method overriding 

    @Override
    void display(){
        System.out.println("=====Saving account===");
        super.display();
    }
}
public class Main{
     public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // array of accounts
        SavingAccount account[] =new SavingAccount[5];
        int count=0;
        int choice;
         do{
            System.out.println("\n========Bank menu ========");
            System.out.println("1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.withdraw");
            System.out.println("4.Display Accounts");
            System.out.println("5.Exit");
            System.out.println("Enter choice");
              choice = sc.nextInt();
              switch(choice){
                 case 1:
                    if(count<account.length){
                        System.out.println("Enter the account number");
                        int accno= sc.nextInt();
                        System.out.println("Enter the name");
                        sc.nextLine();
                        String name= sc.nextLine();
                        
                        System.out.println("Enter balance");
                         double balance= sc.nextDouble();
                         account[count]= new SavingAccount(accno, name, balance);
                         count++;
                         System.out.println("Account created succesfuly");
                    }else{
                         System.out.println("array full");
                    }
                    break;
                    case 2:
                        System.out.println("Enter the account number");
                         int depacc= sc.nextInt();
                         System.out.println("Enter the deposit amount");
                         double depamount= sc.nextDouble();
                         for(int i=0; i<count; i++){
                            if(account[i].accno==depacc){
                                account[i].deposit(depamount);
                            }
                         }
                         break;
                         case 3:
                            System.out.println("Enter the account number");
                            int withacc= sc.nextInt();
                            System.out.println("Enter the withdraw amount");

                         double withamount= sc.nextDouble();
                            for(int i=0; i<count; i++){
                                if(account[i].accno== withacc){
                                    account[i].withdraw(withamount);
                                }
                            }
                            break;
                            case 4:
                                System.out.println("Count = " + count);
                                for(int i=0; i<count; i++){
                                    account[i].display();
                                    System.out.println("==============");
                                }
                                break;
                                case 5:
                                    System.out.println("Program exit");
                                    break;

                                    default:
                                        System.out.println("Invalid choice");
              }
         }while(choice!=5);
         sc.close();

     }
    }


