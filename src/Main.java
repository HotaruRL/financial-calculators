import java.util.Scanner;

public class Main {


//CALCULATOR 1: MONTHLY MORTGAGE PAYMENT
        public static double monthlyMortgageCalc (double P, double i, int n){

            // P = principal amount
            // i = monthly interest rate
            // n = numbers of payments
            return P * (i * Math.pow((1 + i), n)) / (Math.pow((1 + i), n) - 1);
        }
        public static void calculator1 (){
            // CREATE AN INSTANCE OF SCANNER NAMED s
            Scanner s = new Scanner(System.in);

            // INTRO
            System.out.println("\n--------------- Mortgage Monthly Payment Calculator ---------------");

            // USER INPUTS
            System.out.println("\nPlease enter the principal amount (no commas) e.g. 53000: ");
            double principalAmount = s.nextDouble();

            System.out.println("\nPlease enter the loan term in years e.g. 15: ");
            int years = s.nextInt(); // whole numbers of years

            System.out.println("\nPlease enter the annual interest rate e.g. 7.625: ");
            double rawRate = s.nextDouble();
            // convert % yearly rate to monthly rate in decimals
            double monthlyInterestRate = rawRate / 100 / 12;

            // calculate the number of payments behind the scene
            int numberOfPayment = years * 12;

            //OUTPUTS
            double expectedMonthlyPayments = monthlyMortgageCalc(principalAmount, monthlyInterestRate, numberOfPayment);
            double totalInterestPaid = (numberOfPayment * expectedMonthlyPayments) - principalAmount;

            // DISPLAY
            System.out.printf("\nA $%.2f loan at %.3f%% interest for %d years would have\na $%.2f/mo payment with\na total interest of $%.2f\n", principalAmount, rawRate, years, expectedMonthlyPayments, totalInterestPaid);
        }


//CALCULATOR 2: CD FUTURE VALUE
        public static double futureValueCalc(double P, double r, int t){
            int DAYS_IN_YEAR = 365;
            // P = principal amount (initial deposit amount)
            // r = annual interest rate
            // t = total numbers of years the deposit will earn interest
            return P * (Math.pow((1 + (r / DAYS_IN_YEAR)), (DAYS_IN_YEAR * t)));
        }
        public static void calculator2(){
            // CREATE AN INSTANCE OF SCANNER NAMED s
            Scanner s = new Scanner(System.in);

            // INTRO
                System.out.println("\n--------------- CD Future Value Calculator ---------------");

            // USER INPUT VARIABLES
                System.out.println("\nPlease enter your initial deposit amount e.g. 1000: ");
            double principalAmount = s.nextDouble();

                System.out.println("Please enter the annual interest rate e.g. 1.75: ");
            double rawRate = s.nextDouble();
            // convert rate from % to decimals
            double annualInterestRate = rawRate / 100;

                System.out.println("Please enter the total number of years until CD is matured e.g. 5: ");
            int years = s.nextInt();

            // OUTPUTS
            double futureValue = futureValueCalc(principalAmount,annualInterestRate,years);
            double total_Interest_Earned = futureValue - principalAmount;

            // DISPLAY
                System.out.printf("\nIf you deposit $%.2f in a CD that earns %.2f%% interest and matures in %d years,\nyour CD's ending balance will be $%.2f,\nand you would have earned $%.2f in interest\n\n*** Note: The numbers above assume daily compounding.***\n", principalAmount, rawRate, years, futureValue, total_Interest_Earned);
        }


//CALCULATOR 3: ANNUITY PRESENT VALUE
        public static double annuityPresentValueCalc (double c, double i, int n){
            // c = cash flow per period (payment amount)
            // i = interest rate
            // n = number of payments
            return c * ((1 - Math.pow((1 + i), (-n))) / i);
        }
        public static void calculator3 (){
            // CREATE AN INSTANCE OF SCANNER NAMED s
            Scanner s = new Scanner(System.in);

            // INTRO
            System.out.println("\n--------------- Annuity Present Value Calculator ---------------");

            // USER INPUT VARIABLES
            System.out.println("\nPlease enter the monthly payout amount (no commas) e.g. 3000: ");
            double monthlyPayout = s.nextDouble();

            System.out.println("\nPlease enter the expected interest rate e.g. 2.5: ");
            double rawExpectedInterest = s.nextDouble();
            // convert yearly rate % into monthly rate decimals
            double expectedInterest = rawExpectedInterest / 100 / 12;

            System.out.println("\nPlease enter the number of years to pay out e.g. 20: ");
            int years = s.nextInt();
            // convert payout period from yearly to monthly
            int numberOfPayment = years * 12;

            // OUTPUT
            double presentValue = annuityPresentValueCalc(monthlyPayout, expectedInterest, numberOfPayment);

            // DISPLAY
            System.out.printf("\nTo fund annuity that pays $%.2f monthly \nfor %d years and \nearns an expected %.2f%% interest \nyou would need to invest $%.2f today.\n"
                    ,monthlyPayout, years, rawExpectedInterest, presentValue);
        }

        public static void main(String[] args) {
            // CREATE AN INSTANCE OF SCANNER NAMED s
            Scanner s = new Scanner(System.in);

            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\n--------------- Welcome to Financial Calculators Project ---------------");
            System.out.println("\n------------------------------------------------------------------------\n");

            System.out.println("\n1. MONTHLY MORTGAGE PAYMENT");
            System.out.println("\n2. CD FUTURE VALUE");
            System.out.println("\n3. ANNUITY PRESENT VALUE\n");

            System.out.println("\nPlease enter a number from 1-3 to choose the calculator that you want to use.");
            int chooseCalc = s.nextInt();

            if (chooseCalc == 1){
                calculator1();
            } else if (chooseCalc == 2) {
                calculator2();
            } else if (chooseCalc == 3) {
                calculator3();
            }else{
                System.out.println("\n!!! Invalid option !!!");
                System.out.println("\nPlease re-run the program and\nenter a number from 1-3 to choose the calculator that you want to use.");
            }

        }
}