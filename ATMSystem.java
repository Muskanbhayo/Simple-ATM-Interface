
class Person {
    protected String name;
    protected String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayUser() {extends
        System.out.println("Name: " + name);
        System.out.princlasstln("ID: " + id);
    }
}

// Inheritance
   Person {
    private double balance;

    public Account(String name, String id, double initialBalance) {
        super(name, id);
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: $" + balance);
    }
}

// Composition
class ATM {
    privatAccounte Account account;
    private Scanner scanner;

    public ATM(Account account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. View Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.displayUser();
                    break;
                case 2:
                    account.checkBalance();
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(scanner.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter withdraw amount: ");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}

// Aggregation
class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public Account getAccountById(String id) {
        for (Account acc : accounts) {
            if (acc.id.equals(id)) {
                return acc;
            }
        }
        return null;
    }
}

// Main class
public class ATMSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Creating a sample account and adding to bank (Aggregation)
        Account user1 = new Account("Alice", "A001", 1000.0);
        bank.addAccount(user1);

        // Searching and starting ATM interface (Composition)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine();

        Account foundAccount = bank.getAccountById(enteredId);
        if (foundAccount != null) {
            ATM atm = new ATM(foundAccount);
            atm.start();
        } else {
            System.out.println("Account not found.");
        }
    }
}


 





 