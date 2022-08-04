import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class optionmenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'####,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(9876543, 9876);
                data.put(1234567, 7895);

                System.out.println("WELCOME TO THE ATM PROJECT! ");

                System.out.println("ENTER YOUR CUSTOMER NUMBER: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("ENTER YOUR PIN NUMBER: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber())
                    getAccountType();
            }


            System.out.println("\n" + "WRONG CUSTOMER NUMBER OR PIN NUMBER>" + "\n");
        } while (x == 1);

    }
        public void getAccountType () {
            System.out.println("SELECT THE ACCOUNT YOU WANT TO ACCESS");
            System.out.println("TYPE 1 - Checking Account");
            System.out.println("TYPE 2 - Saving Account");
            System.out.println("TYPE 3 - Exit");
            System.out.println("Choice: ");

            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    getChecking();
                    break;
                case 2:
                    getSaving();
                    break;
                case 3:
                    System.out.println("THANK YOU FOR USING... :) ");
                    break;
                default:
                    System.out.println("\n" + "INVALID CHOICE." + "\n");
                    getAccountType();
            }
        }

        public void getChecking ()
        {
            System.out.println("CHECKING ACCOUNT");
            System.out.println("TYPE 1 - View Balance");
            System.out.println("TYPE 2 - Withdraw Funds");
            System.out.println("TYPE 3 - Deposit Funds");
            System.out.println("TYPE 4 - Exit");
            System.out.println("Choice: ");

            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                    getAccountType();
                    break;
                case 2:
                    getCheckingWithdrawInput();
                    getAccountType();
                    break;
                case 3:
                    getCheckingDepositInput();
                    getAccountType();
                    break;
                case 4:
                    System.out.println("THANK YOU FOR USING ATM. :)");
                    break;
                default:
                    System.out.println("\n" + "Invalid Choice" + "\n");
                    getChecking();
            }
        }



    public void getSaving ()
        {
            System.out.println("SAVING ACCOUNT");
            System.out.println("TYPE 1 - View Balance");
            System.out.println("TYPE 2 - Withdraw Funds");
            System.out.println("TYPE 3 - Deposit Funds");
            System.out.println("TYPE 4 - Exit");
            System.out.println("Choice: ");

            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                    getAccountType();
                    break;
                case 2:
                    getSavingWithdrawInput();
                    getAccountType();
                    break;
                case 3:
                    getSavingDepositInput();
                    getAccountType();
                    break;
                case 4:
                    System.out.println("THANK YOU FOR USING ATM. :)");
                    break;
                default:
                    System.out.println("\n" + "Invalid Choice" + "\n");
                    getSaving();
            }
        }
        int selection;
    }

