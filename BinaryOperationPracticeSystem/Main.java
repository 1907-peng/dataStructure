package main.phrase3;


import main.phrase3.paper.AbstractTestPaper;
import main.phrase3.paper.AdditionTestPaper;
import main.phrase3.paper.SubtractTestPaper;
import main.phrase3.paper.MixedTestPaper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static AbstractTestPaper[] papers;
    public static Scanner sc = new Scanner(System.in);

    static {

        try {
            OperationBase.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        System.out.println("————————————欢迎来到小学生做题系统———————————————");
        String opt = null;
        boolean isInputLegal;
        while (true) {
            do {
                isInputLegal = true;
                System.out.println("请输入你想要练习的题目类型对应的序号" + "\n\t1.加法题\n\t2.减法题目\n\t3.加减混合题\n\t4.退出系统");
                try {
                    opt = sc.next();
                } catch (Exception e) {

                } finally {
                    if (opt.equals("1")) {
                        generateAdditionPapers();
                        User.doExamPaper();
                        Corrector.markPaper();
                        getPapersAnalysis();

                    } else if (opt.equals("2")) {
                        generateSubtractPapers();
                        User.doExamPaper();
                        Corrector.markPaper();
                        getPapersAnalysis();

                    } else if (opt.equals("3")) {
                        generateMixedPapers();
                        User.doExamPaper();
                        Corrector.markPaper();
                        getPapersAnalysis();
                    } else if (opt.equals("4")) {
                        sc.close();
                        System.exit(0);
                    } else {
                        isInputLegal = false;
                        System.out.println("输入非法内容,请重新输入");
                    }
                }
            } while (!isInputLegal);
        }

    }

    private static void generateAdditionPapers() throws IOException {
        int operationsCount;
        operationsCount = User.inputOperationCount(User.chooseWayOfInputOperationCount());

        papers = new AdditionTestPaper[User.inputPapersCount()];

        for (int i = 0; i < User.getPapersCount(); i++) {
            int paperIndex = i;
            papers[i] = new AdditionTestPaper(operationsCount);
            System.out.println("成功生成了第" + ++paperIndex + "套试卷！！");
        }

        for (int paperIndex = 0; paperIndex < User.getPapersCount(); paperIndex++) {
            int temp = paperIndex;
            System.out.println("这是第" + (++temp) + "套试卷的内容");
            papers[paperIndex].formatAndDisplay(5);
        }
    }

    private static void generateSubtractPapers() throws IOException {
        int operationsCount;
        operationsCount = User.inputOperationCount(User.chooseWayOfInputOperationCount());

        papers = new SubtractTestPaper[User.inputPapersCount()];

        for (int i = 0; i < User.getPapersCount(); i++) {
            int paperIndex = i;
            papers[i] = new SubtractTestPaper(operationsCount);
            System.out.println("成功生成了第" + ++paperIndex + "套试卷！！");
        }

        for (int paperIndex = 0; paperIndex < User.getPapersCount(); paperIndex++) {
            int temp = paperIndex;
            System.out.println("这是第" + (++temp) + "套试卷的内容");
            papers[paperIndex].formatAndDisplay(5);
        }
    }

    private static void generateMixedPapers() throws IOException {
        int operationsCount;
        operationsCount = User.inputOperationCount(User.chooseWayOfInputOperationCount());

        papers = new MixedTestPaper[User.inputPapersCount()];

        for (int i = 0; i < User.getPapersCount(); i++) {
            int paperIndex = i;
            papers[i] = new MixedTestPaper(operationsCount);
            System.out.println("成功生成了第" + ++paperIndex + "套试卷！！");
        }

        for (int paperIndex = 0; paperIndex < User.getPapersCount(); paperIndex++) {
            int temp = paperIndex;
            System.out.println("这是第" + (++temp) + "套试卷的内容");
            papers[paperIndex].formatAndDisplay(5);
        }
    }

    private static void getPapersAnalysis() {
        for (AbstractTestPaper paper : papers) {
            paper.getAnalysis();
        }
    }


}
