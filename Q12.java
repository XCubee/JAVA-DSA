// 12. Create classes Student, Undergraduate, and Postgraduate with overridden calculateResult()

class Student {
    String name;
    int[] marks;
    int roll;

    Student(String name, int[] marks, int roll) {
        this.marks = marks;
        this.name = name;
        this.roll = roll;
    }

    void display() {
        System.out.println("Details:");
        System.out.println(name);
        System.out.println(roll);
    }

    void calculateResult() {
        int sum = 0;
        for (int i : marks)
            sum += i;

        double avg = (double) sum / marks.length;
        System.out.println("Average: " + avg);
    }
}

class Undergraduate extends Student {
    Undergraduate(String name, int[] marks, int roll) {
        super(name, marks, roll);
    }

    @Override
    void calculateResult() {
        int sum = 0;
        for (int i : marks)
            sum += i;

        double avg = (double) sum / marks.length;

        if (avg >= 50)
            System.out.println("UG PASS");
        else
            System.out.println("UG FAIL");
    }
}

class Postgraduate extends Student {
    Postgraduate(String name, int[] marks, int roll) {
        super(name, marks, roll);
    }

    @Override
    void calculateResult() {
        int sum = 0;
        for (int i : marks)
            sum += i;

        double avg = (double) sum / marks.length;

        if (avg >= 60)
            System.out.println("PG PASS");
        else
            System.out.println("PG FAIL");
    }
}

public class Q12 {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30};

        Student s1 = new Undergraduate("Saksham", arr, 66);
        s1.calculateResult();

        Student s2 = new Postgraduate("Rahul", arr, 77);
        s2.calculateResult();
    }
}
