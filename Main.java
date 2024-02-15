package MainPackage;
import java.util.Scanner;

public class Main {

    private static final int MAX_EMPLOYEES = 100;
    private static Employee[] employees = new Employee[MAX_EMPLOYEES];
    private static int numOfEmployees = 0;

    private static boolean isIdUnique(int id) {
        for (int i = 0; i < numOfEmployees; i++) {
            if (employees[i].getId() == id) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ;
        int choice;

        do {
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Найти сотрудника по id");
            System.out.println("3. Найти сотрудника по имени или году рождения");
            System.out.println("4. Изменить информацию о сотруднике");
            System.out.println("5. Рассчитать общую зарплату сотрудников");
            System.out.println("0. Выйти");

            System.out.print("Выберите действие: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    findEmployeeById();
                    break;
                case 3:
                    findEmployeeByNameOrBirthYear();
                    break;
                case 4:
                    updateEmployeeInfo();
                    break;
                case 5:
                    calculateTotalSalary();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);
    }


    private static void addEmployee() {
        Scanner scan = new Scanner(System.in);
        if (numOfEmployees < MAX_EMPLOYEES) {
            System.out.print("Введите id сотрудника: ");
            int id = scan.nextInt();

            // Проверим на уникальность id
            if (isIdUnique(id)) {
                System.out.print("Введите имя: ");
                String firstName = scan.next();

                System.out.print("Введите фамилию: ");
                String surname = scan.next();

                System.out.print("Введите год рождения: ");
                int yearOfBirth = scan.nextInt();

                System.out.print("Введите место рождения: ");
                String placeOfBirth = scan.next();

                System.out.print("Введите зарплату: ");
                double salary = scan.nextDouble();

                System.out.print("Введите семейное положение: ");
                String maritalStatus = scan.next(); // scan.next() считавые только первое слово, scan.nextLine() не считывает вообще ничего!

                Employee employee = new Employee(id, firstName, surname, yearOfBirth, placeOfBirth, salary, maritalStatus);
                employees[numOfEmployees++] = employee;
                System.out.println("Сотрудник добавлен успешно.");

            } else {
                System.out.println("Сотрудник с таким id уже существует.");
            }
        } else {
            System.out.println("Достигнут лимит сотрудников!");
        }
    }

    private static void findEmployeeById() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите id сотрудника для поиска: ");
        int idToFind = scanner.nextInt();

        for (int i = 0; i < numOfEmployees; i++) {
            if (employees[i].getId() == idToFind) {
                printEmployeeInfo(employees[i]);
                return;
            }
        }

    }

    private static void findEmployeeByNameOrBirthYear() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя или год рождения сотрудника: ");
        String research = scanner.next();

        for (int i = 0; i < numOfEmployees; i++) {
            if (employees[i].getFirstName().equalsIgnoreCase(research) || employees[i].getYearOfBirth() == Integer.parseInt(research)) {
                // Первое условие проверяет, совпадает ли имя сотрудника с введенным запросом.
                // equalsIgnoreCase делает сравнение без учета регистра символов.
                // Второе условие проверяет, совпадает ли год рождения сотрудника с введенным запросом.
                // Integer.parseInt используется для преобразования строки в целое число.
                printEmployeeInfo(employees[i]);
            }
        }
    }

    private static void updateEmployeeInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите Id сотрудника: ");
        int idToFind = scanner.nextInt();

        for(int i = 0; i < numOfEmployees; i++) {
            if (employees[i].getId() == idToFind) {
                System.out.println("Выберите поле для изменения:");
                System.out.println("1. Имя");
                System.out.println("2. Фамилия");
                System.out.println("3. Год рождения");
                System.out.println("4. Место рождения");
                System.out.println("5. Зарплата");
                System.out.println("6. Семейное положение");

                int change = scanner.nextInt();

                switch (change) {
                    case 1:
                        System.out.print("Введите новое имя: ");
                        employees[i].setFirstName(scanner.next());
                        break;
                    case 2:
                        System.out.print("Введите новую фамилию: ");
                        employees[i].setSurname(scanner.next());
                        break;
                    case 3:
                        System.out.print("Введите новый год рождения: ");
                        employees[i].setYearOfBirth(scanner.nextInt());
                        break;
                    case 4:
                        System.out.print("Введите новое место рождения: ");
                        employees[i].setPlaceOfBirth(scanner.next());
                        break;
                    case 5:
                        System.out.print("Введите новую зарплату: ");
                        employees[i].setSalary(scanner.nextDouble());
                        break;
                    case 6:
                        System.out.print("Введите новое семейное положение: ");
                        employees[i].setMaritalStatus(scanner.next());
                        break;
                    default:
                        System.out.println("Некорекктный выбор!");
                }
                System.out.println("Изменения внесены успешно!");
                return;
            }
        }
    }

    private static void calculateTotalSalary(){
        double totalSalary = 0;
        for(int i = 0; i < numOfEmployees; i++){
            totalSalary += employees[i].getSalary();
        }
        System.out.println("Общая сумма денег заработной платы всех сотрудников = " + totalSalary + " руб.");
    }

    private static void printEmployeeInfo(Employee employee){
        System.out.println("ID: " + employee.getId());
        System.out.println("Имя: " + employee.getFirstName());
        System.out.println("Фамилия: " + employee.getSurname());
        System.out.println("Год рождения: " + employee.getYearOfBirth());
        System.out.println("Место рождения: " + employee.getPlaceOfBirth());
        System.out.println("Зарплата: " + employee.getSalary() + " руб.");
        System.out.println("Семейное положение: " + employee.getMaritalStatus());
    }
}