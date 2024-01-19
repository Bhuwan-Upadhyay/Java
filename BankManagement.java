import java.util.Scanner;
import java.util.Random;
/*
 Acc no.
 Name
 adress
 opening balance
 date

 constructor
 Withdraw 
 Deposit
 */
class Bank
{
    // Bank Variables
    private int AccountNumber;
    private String Name;
    private String Address;
    private Double Balance = 0d;
    private String Date;
    
    // Input Scanner
    private Scanner s = new Scanner(System.in);

    public void Account_Opening()
    {
        
        Random rand = new Random();

        System.out.println("Account Opening Process Started");

        System.out.print("Enter your Name: ");
        Name = s.nextLine();

        System.out.print("Enter your address: ");
        Address = s.nextLine(); 

        System.out.print("Enter today's Date: ");
        Date = s.nextLine();

        AccountNumber = rand.nextInt(10000, 99999);
        System.out.println("New Account Number is alloted to you: " + AccountNumber);

        Balance += 2000d;
        System.out.println("Openning amount of RS 2000 is added to your new Account");
        System.out.println("Current Balance: RS " + Balance);

        System.out.println("Congratulation!! Your account has been created");

    }

    public void Withdraw()
    {
        System.out.print("Enter the Account Number: ");
        int temp = s.nextInt();

        if(temp == AccountNumber)
        {
            System.out.print("Enter the amount for withdrawal: ");
            double withdrawalAmount = s.nextDouble();
            if(withdrawalAmount <= 0) 
            {
                System.out.println("Error! Withdraw amount should be greater than zero!!");
            }
            else if(Balance<withdrawalAmount)
            {
                System.out.println("Insufficient Balanece");
            }
            else
            {
                Balance -= withdrawalAmount;
                System.out.println("Withdrawal Successful");
                System.out.println("Current Balance After Withdraw: RS " + Balance);
            }
        }
        else
        {
            System.out.println("No match found for Given Account Number");
        }
    }

    public void Deposit()
    {
        System.out.print("Enter the Account Number: ");
        int temp = s.nextInt();

        if(temp == AccountNumber)
        {
            System.out.print("Enter the amount for deposit: ");
            Double depositAmount = s.nextDouble();
            
            if(depositAmount <= 0)
            {
                System.out.println("Error! Deposit amount should be greater than zero!!");
            }
            else 
            {
                Balance +=depositAmount;
                System.out.println("Deposit Successful");
                System.out.println("Current Balance After Deposit: RS " + Balance);
            }
        }
        else
        {
            System.out.println("No match found for Given Account Number");
        }

    }

    public void View_Info()
    {
        System.out.print("Enter the Account Number: ");
        int temp = s.nextInt();

        if(temp == AccountNumber)
        {
            System.out.println("Name = " + Name);
            System.out.println("Account Number = " + AccountNumber);
            System.out.println("Date of opening Account = " + Date);
            System.out.println("Address = " + Address);
            System.out.println("Balance = RS " + Balance);
        }
        else 
        {
            System.out.println("No match found for Given Account Number");
        }
    }
}

class BankManagement
{
    public static void main(String agr[])
    {
        Scanner s = new Scanner(System.in);
        int choice = -1;

        Bank b = new Bank();

        do
        {
            System.out.println("Bank Management System");
            System.out.println("1. Opening Bank Account");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. View Account Information");
            System.out.println("5. Exit System");
            System.out.print("Enter you choice: ");
            choice = s.nextInt();

            switch(choice)
            {
                case 1:
                b.Account_Opening();
                break;

                case 2:
                b.Withdraw();
                break;

                case 3:
                b.Deposit();
                break;

                case 4:
                b.View_Info();
                break;

                case 5:
                System.out.println("Exited from system");
                choice = 0;
                break;

                default:
                System.out.println("Error! You have entered wrong choice");
                System.out.println("By default you are exiting from system");
                choice = 0;
                break;
            }

        } while(choice!=0);

        s.close();
        
    }
}