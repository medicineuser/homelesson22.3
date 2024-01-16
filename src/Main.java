import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){

        BankAccount wallet = new BankAccount();
        wallet.deposit(15000);

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Текущий счет " + wallet.getAmount());
            int sum  = scanner.nextInt();
            try {
                wallet.withDraw(sum);
                System.out.println("Было снято: " + sum + " Остаток на счету: "+ wallet.getAmount());
            }catch (LimitException e){
                System.out.println(e.getMessage() + "У вас на счету " + wallet.getAmount());
                try {
                    wallet.withDraw((int)wallet.getAmount());
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Остаток суммы был снят полностью , текущий баланс клиента " + wallet.getAmount());
            }
        }
    }
}