package MainPackage;

public class Employee {

    private int id;
    private String firstName;
    private String surname;
    private int yearOfBirth;
    private String placeOfBirth;
    private double salary;
    private String maritalStatus;

    public Employee(int id, String firstName, String surname, int yearOfBirth, String placeOfBirth, double salary, String maritalStatus) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.salary = salary;
        this.maritalStatus = maritalStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (this.id < 0){
            System.out.println("Id не может быть отрицательным!");
        } else {
            this.id = id;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (this.firstName.isEmpty()){
            System.out.println("Имя не может быть пустым!");
        } else {
            this.firstName = firstName;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (this.surname.isEmpty()){
            System.out.println("Вы не ввели фамилию!");
        } else {
            this.surname = surname;
        }
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (this.yearOfBirth < 0){
            System.out.println("Год рождения не может быть отрицательным!");
        } else {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        if (this.placeOfBirth.isEmpty()){
            System.out.println("Вы не ввели место рождения!");
        } else {
            this.placeOfBirth = placeOfBirth;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (this.salary < 0){
            System.out.println("Зарплата не может быть меньше 0!");
        } else {
            this.salary = salary;
        }
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        if (this.maritalStatus.isEmpty()){
            System.out.println("Вы не ввели семейное положение!");
        } else {
            this.maritalStatus = maritalStatus;
        }
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", salary=" + salary +
                ", maritalStatus='" + maritalStatus + '\'' +
                '}';
    }
}
