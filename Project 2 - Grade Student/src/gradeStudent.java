import java.util.Scanner;
public class gradeStudent {
    static Scanner sc = new Scanner(System.in);
    private static int midTermWeight = 0;
    private static int finalTermWeight = 0;
    private static double weightedScoreMid = 0;
    private static double weightedScoreFinal = 0;
    private static double weightedScoreHome = 0;
    public static void main(String[] args) {
        begin();
        midTerm();
        finalTerm();
        homework();
        report();
    }
    public static void begin () {
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }
    //Tính điểm thi giữa kì
    public static void midTerm () {
        System.out.println("Mid term:");
        do {
            System.out.print("Weight (0 - 100): ");
            midTermWeight = sc.nextInt();
        }
        //Xét phần trọng số của 3 phần điểm thi phải có tổng chính xác là 100
        while (midTermWeight <= 0 || midTermWeight > 98);
        System.out.print("Score earned: ");
        int scoreEarn = sc.nextInt();
        System.out.print("Were scores shifted (1 = yes, 2 = no): ");
        int scoreShifted = sc.nextInt();
        int totalPoint;

        if (scoreShifted == 1) {
            System.out.print("Shift amount: ");
            int shiftAmount = sc.nextInt();
            totalPoint = scoreEarn + shiftAmount;
        } else {
            totalPoint = scoreEarn;
        }
        if (totalPoint > 100) {
            totalPoint = 100;
        }
            System.out.println("Total points = " + totalPoint + "/100");
        weightedScoreMid = (totalPoint/100.0)*midTermWeight;
        System.out.println("Weighted Score = " + (Math.ceil(weightedScoreMid*10)/10) + " / " + midTermWeight);
    }
    //Tính điểm thi cuối kì
    public static void finalTerm () {
        System.out.println("Final term:");
        do {
            System.out.print("Weight (0 - 100): ");
            finalTermWeight = sc.nextInt();
        }
        //Xét phần trọng số của 3 phần điểm thi phải có tổng chính xác là 100
        while (finalTermWeight <= 0 || finalTermWeight > 100 || (midTermWeight + finalTermWeight) >= 100);
        System.out.print("Score earned: ");
        int scoreEarn2 = sc.nextInt();
        System.out.print("Were scores shifted (1 = yes, 2 = no): ");
        int scoreShifted2 = sc.nextInt();
        int totalPoint2;

        if (scoreShifted2 == 1) {
            System.out.print("Shift amount: ");
            int shiftAmount2 = sc.nextInt();
            totalPoint2 = scoreEarn2 + shiftAmount2;
        } else {
            totalPoint2 = scoreEarn2;
        }
        if (totalPoint2 > 100) {
            totalPoint2 = 100;
        }
            System.out.println("Total points = " + totalPoint2 + "/100");
        weightedScoreFinal = (totalPoint2/100.0)*finalTermWeight;
        System.out.println("Weighted Score = " + (Math.ceil(weightedScoreFinal*10)/10) + "/" + finalTermWeight);
    }
    //Tính điểm bài tập về nhà
    public static void homework () {
        System.out.println("Homework:");
        int homeworkWeight;
        do {
            System.out.print("Weight (0 - 100): ");
            homeworkWeight = sc.nextInt();
        }
        //Xét phần trọng số của 3 phần điểm thi phải có tổng chính xác là 100
        while (homeworkWeight <= 0 || homeworkWeight > 100 || (midTermWeight + homeworkWeight + finalTermWeight) != 100);
        System.out.print("Number of assignments ?");
        int asmNumber = sc.nextInt();
        int asmScore = 0;
        int asmScoreMax = 0;
        for (int i = 0; i < asmNumber; i++ ) {
            System.out.println("Assignment " + (i + 1) + " score and max: ");
            asmScore += sc.nextInt();
            asmScoreMax += sc.nextInt();
            if (asmScore > 150) { //Điểm tối đa của phần Assignment là 150, nếu vượt quá thì cũng chỉ tính là 150 điểm
                asmScore = 150;
            }
        }
        System.out.println("How many sections did you attend: ");
        int attendNum = sc.nextInt();
        int sectionPoints = attendNum * 5;
        if (sectionPoints > 30) { //Điểm tối đa của phần Attend là 30, nếu vượt quá 30 thì vẫn chỉ tính là 30
            sectionPoints = 30;
        }
        System.out.println("Section points: " + sectionPoints + " / 30");
        int totalPoint = asmScore + sectionPoints;
        int totalMaxPoint = asmScoreMax + 30;
        System.out.println("Total points: " + totalPoint + " / " + totalMaxPoint);
        weightedScoreHome = (totalPoint/(double)totalMaxPoint)*homeworkWeight;
        System.out.println("Weight score = " + (Math.floor(weightedScoreHome*10)/10) + " / " + homeworkWeight);
    }
    public static void report () {
        double overAll = weightedScoreMid + weightedScoreFinal + weightedScoreHome; //Tính tổng điểm đạt được của 3 môn tính theo thang điểm 100
        System.out.println("Overall percentage = " + (Math.floor(overAll*10)/10));
        //Xét điểm GPA
        if (overAll == 100) {
            System.out.println("Your grade will be at: 4.0");
        } else if (overAll >= 85) {
            System.out.println("Your grade will be at least: 3.0");
        } else if (overAll >= 75) {
            System.out.println("Your grade will be at least: 2.0");
        } else if (overAll >= 60) {
            System.out.println("Your grade will be at least: 1.0");
        } else {
            System.out.println("Your grade will be at least: 0.0");
        }
    }
}
