
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            System.out.println("Enter the student: " + (i + 1));

            System.out.print("Enter id: ");
            String id = sc.nextLine();
            
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter java score: ");
            double javaScore = sc.nextDouble();

            System.out.print("Enter sql score: ");
            double sqlScore = sc.nextDouble();
    

            System.out.print("Enter html score: ");
            double htmlScore = sc.nextDouble();

            sc.nextLine();

            students[i] = new Student(id, name, javaScore, sqlScore, htmlScore);
        }

        int choice;
        do { 
            System.out.println("============ MENU =============");
            System.out.println("1. LIST OF STUDENTS");
            System.out.println("2. THE STUDENT WITH THE BEST SCORE: ");
            System.out.println("3. THE STUDENT WITH THE WORST SCORE: ");
            System.out.println("4. PRINT PASSED STUDENTS");
            System.out.println("5. PRINT FAILED STUDENTS");
            System.out.println("6. EXIT");
            System.out.print("ENTER NUMBER: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    for(int i = 0; i < students.length; i++){
                        students[i].printInfo();
                    }
                    break;
                case 2:
                    double max = students[0].calculateAverage();
                    for(int i = 0; i < students.length; i++){
                        if(students[i].calculateAverage() > max) max = students[i].calculateAverage();
                    }
                    break;
                case 3:
                    double min = students[0].calculateAverage();
                    for(int i = 0; i < students.length; i++){
                        if(students[i].calculateAverage() < min) min = students[i].calculateAverage();
                    }
                    break;
                case 4:
                    for(int i = 0; i < students.length; i++){
                        if(students[i].isPassed()) students[i].printInfo();
                    }
                    break;
                case 5:
                    for(int i = 0; i < students.length; i++){
                        if(!students[i].isPassed()) students[i].printInfo();
                    }
                    break;
                case 6:
                    System.out.println("OUT THE PROGRAMME");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID");

            }

            
        } while (choice != 0);
    }
}