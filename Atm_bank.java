import java.util.Scanner;

class bank {
    int PIN = 7895;
    int transactions;
    String transactionHistory = " ";
    float bal = 100000f;

    public void checkPIN() {
        System.out.println("Enter your PIN for Login-:");
        Scanner sc = new Scanner(System.in);
        int EnterPin = sc.nextInt();
        if (EnterPin == PIN) {
            System.out.println("welcome Sir");
            menu();
        } 
        else{
            System.out.println("Please!enter the valid PIN");
        }
    }

    public void menu() {
        System.out.println("Hey!enter your choice:-");
        System.out.println("1. Enter the withdrawing amount-: ");
        System.out.println("2. deposite your amount-:");
        System.out.println("3. check your balance-:");
        System.out.println("4. Enter the Amount to Transfer-:");
        System.out.println("5. check your Transaction History-:");
        System.out.println("6. Exit");

        Scanner sc=new Scanner(System.in);
        int otp=sc.nextInt();

        if(otp==1){
            withdraw();
        }
        else if(otp==2){
            deposit();
        }
        else if(otp==3){
            checkBalance();
        }
        else if(otp==4){
            transfer();
        }
        else if(otp==5){
            THistory();
        }
        else if(otp==6){
            return;
        }
        else{
            System.out.println("Invalid choice");
        }
    }

    //function for withdrawing money
    public void withdraw(){
        System.out.println("Enter the amount to withdraw");
        Scanner sc=new Scanner(System.in);
        float amt=sc.nextFloat();
        try{
            if(bal>=amt){
                transactions++;
                bal-=amt;
                System.out.println("\n Amount withdrawled succesfully");
                String str = amt + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("insufficient balance");
            }
            menu();
        }
        catch(Exception e){

        }
    }
    //function for depositing the money
    public void deposit(){
        System.out.println("enter the Amount to deposite");
        Scanner sc=new Scanner(System.in);
        float amt=sc.nextFloat();
        try{
            if(amt<=100000f){
                transactions++;
                bal+=amt;
                System.out.println("\n Amount Succesfully Deposited");
                String str=amt+"\n Rs deposited";
                transactionHistory=transactionHistory.concat(str);
            }
            menu();
        }
        catch(Exception e){

        }
    }
    
    public void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the Receiver's name");
        String name=sc.nextLine();
        System.out.println("enter the amount to transfer");
        float amt=sc.nextFloat();

        try{
            if(bal>=amt){
                transactions++;
                bal-=amt;
                System.out.println("Succesfully transfered to"+name);
                String str=amt+"\n transfered to"+name;
                transactionHistory=transactionHistory.concat(str);

            }
            menu();
        }
        catch(Exception e){

        }
    }
     
    public void checkBalance(){
        System.out.println("\n"+bal+"Rs");
        menu();
    }
    
    public void THistory(){
        if(transactions==0){
            System.out.println("\n null");
        }
        else{
            System.out.println("\n"+transactionHistory);
        }
        menu();
    }

}

public class Atm_bank {
    public static void main(String[] args) {
        bank b=new bank();
        b.checkPIN();

    }

}
