package main.phrase3;

import java.util.Scanner;
import java.util.ArrayList;

public class User {
    private static int papersCount;
    private static int operationCount;

    private static ArrayList[] answersList;


    public static void doExamPaper() {
        answersList = new ArrayList[papersCount];
        System.out.println("\n一套练习的答案占一行,一行里面的每个答案之间用英文的;分割\n请输入你的答案");
        Util.startTimer();
        for (int i = 0; i < papersCount; i++) {
            String temp = null;
            try {
                temp = Main.sc.next();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                String[] aAnswerString = temp.split(";");
                ArrayList<Integer> anExerciseAnswer = new ArrayList<>();

                for (String str : aAnswerString) {
                    try {
                        anExerciseAnswer.add(Integer.parseInt(str));
                    } catch (Exception e) {
                        anExerciseAnswer.add(null);
                    }
                }
                answersList[i] = anExerciseAnswer;

            }

        }
        Util.endTimer();
    }

    public static int inputPapersCount() {
        boolean isInputLegal;
        do {
            isInputLegal = true;
            System.out.println("请输入试卷的数量:");
            try {
                papersCount = Main.sc.nextInt();
            } catch (Exception e) {
                isInputLegal = false;
                System.out.println("输入了非法数值,请输入合法数值");
            } finally {
                Main.sc = new Scanner(System.in);
            }
        } while (!isInputLegal);
        return papersCount;
    }

    public static ArrayList<ArrayList>[] getAnswers() {
        return answersList;
    }

    static int chooseWayOfInputOperationCount() {
        //int opt = 0;
        String opt = null;
        boolean isInputLegal = true;
        do {
            System.out.println("输入题目的数量\n\t1.手动输入\n\t2.选择选项");
            try {
                isInputLegal = true;
                opt = Main.sc.next();
            } catch (Exception e) {
                isInputLegal = false;
            } finally {
                if ((!opt.equals("1") && !opt.equals("2")) || (!isInputLegal)) {
                    isInputLegal = false;
                    System.out.println("输入了非法数值,请重新输入合法数值----");
                }
            }
        } while (!isInputLegal);
        return Integer.parseInt(opt);
    }

    static int inputOperationCount(int choice) {
        int operationCount = 0;
        if (choice == 1)
            operationCount = inputOperationCountByUser();
        else if (choice == 2)
            operationCount = chooseOperationCountByUser();
        return operationCount;
    }

    static int inputOperationCountByUser() {
        boolean isInputLegal;
        do {
            System.out.println("请输入一套习题中算式的数量");
            try {
                isInputLegal = true;
                operationCount = Main.sc.nextInt();
            } catch (Exception e) {
                isInputLegal = false;
                System.out.println("输入了非法数值,请重新输入合法数值");
            } finally {
                Main.sc = new Scanner(System.in);
            }
        } while (!isInputLegal);
        return operationCount;
    }


    static int chooseOperationCountByUser() {
        int opt = 0;
        boolean isInputLegal;
        do {
            System.out.println("请选择一套习题中算式的数量对应的序号\n\t1.10\n\t2.20\n\t3.30\n\t4.40");
            try {
                isInputLegal = true;
                opt = Main.sc.nextInt();
            } catch (Exception e) {
                isInputLegal = false;
                System.out.println("输入了非法数值,请重新输入合法数值");
                //e.printStackTrace();
            } finally {
                if (opt <= 0 || opt >= 5) {
                    isInputLegal = false;
                    System.out.println("输入了非法数值,请重新输入合法数值");
                }
                Main.sc = new Scanner(System.in);
            }
        } while (!isInputLegal);
        operationCount = opt * 10;
        return operationCount;
    }

    public static int getPapersCount() {
        return papersCount;
    }

    public static int getOperationCount() {
        return operationCount;
    }

}
