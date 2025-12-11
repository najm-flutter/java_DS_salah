package PublicClass;

import java.util.Scanner;

import DLList.Student;

public class Methods {
    public static Object choiseTypeT(Scanner in) {
        System.out.println("""

                    Choose data type:
                    1. Integer
                    2. Double
                    3. String
                    4. Character
                    5. Boolean
                    6. Student
                    0. Default 0

                """);

        int choice;
        while ((choice = in.nextInt()) != 0) {
            try {
                switch (choice) {
                    case 1:
                        return in.nextInt();
                    case 2:
                        return in.nextDouble();
                    case 3:
                        return in.next();
                    case 4:
                        return in.next().charAt(0);
                    case 5:
                        return in.nextBoolean();
                    case 6:
                        System.out.println("Student name:");
                        return new Student(in.next());
                    default:
                        Messages.printInvalidOptionMessage();
                        break;
                }
            } catch (Exception e) {
                Messages.printInvalidOptionMessage();
            }

            System.out.println("""

                    Choose data type:
                    1. Integer
                    2. Double
                    3. String
                    4. Character
                    5. Boolean
                    0. Default 0

                    """);
        }
        return 0;

    }
}
