package main.phrase3.paper;

import main.phrase3.Main;
import main.phrase3.Util;
import main.phrase3.OperationBase;
import main.phrase3.operation.AdditionOperation;
import main.phrase3.operation.AbstractBinaryOperation;


import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class AdditionTestPaper extends AbstractTestPaper {
    private int score;
    private int formulasQuantity;
    private boolean isInputLegal;
    private String paperFileName;


    private ArrayList correctResults = new ArrayList<Integer>();

    private ArrayList rightAnswerIndex = new ArrayList<Integer>();
    private ArrayList wrongAnswerIndex = new ArrayList<Integer>();


    private ArrayList<AbstractBinaryOperation> tempOfBase = new ArrayList<>();
    private ArrayList<AbstractBinaryOperation> formulasList = new ArrayList<>();


    public void savedToFile() throws IOException {
        System.out.println("请输入试卷的文件名:" + "\n\t例如:AdditionExercise1,AdditionExercise2...");
        this.paperFileName = Main.sc.next();
        File file = new File("C:/JavaFile/" + paperFileName + ".txt");
        if(!file.exists())
            file.createNewFile();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (AbstractBinaryOperation op : formulasList) {
                objectOutputStream.writeObject(op);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AdditionTestPaper(int formulasQuantity) throws IOException {
        String option = null;
        this.formulasQuantity = formulasQuantity;
        do {
            System.out.println("请输入该套练习的题目来源:" + "\n\t1.随机产生" + "\n\t2.从算式基中随机选取");
            try {
                option = Main.sc.next();

            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            } finally {
                if (option.equals("1")) {
                    this.getExerciseOfRandomFormula(formulasQuantity);
                    this.savedToFile();
                } else if (option.equals("2")) {
                    this.getExerciseOfBaseFormula(formulasQuantity);
                    this.savedToFile();
                } else {
                    this.isInputLegal = false;
                    System.out.println("输入错误,请重新输入选项\n");
                }
            }
        }
        while (!this.isInputLegal);

    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void getAnalysis() {
        System.out.println("在本套试题中\n" +
                "你的得分为:\t" + this.score +
                "\n回答正确的题目数量:" + this.rightAnswerIndex.size() +
                "\n回答错误的题目数量:" + this.wrongAnswerIndex.size() +
                "\n正确率:" + ((double) this.rightAnswerIndex.size() / (double) this.formulasQuantity) * 100 + "%" +
                "\n回答正确的题号为: " + getIndexStringOfRightAnswers() +
                "\n回答错误的题号为: " + getIndexStringOfWrongAnswers() +
                "\n本次练习一共耗时:" + Util.getLastTime() + "分钟" +
                "\n"
        );
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void formatAndDisplay(int colAmount) {
        int count = 0;
        for (AbstractBinaryOperation operation : formulasList) {
            count++;
            System.out.print(count + ". " + operation.toString());
            if (count % colAmount == 0) System.out.println('\n');
        }
        System.out.println("\n");
    }

    @Override
    public StringBuilder getIndexStringOfRightAnswers() {
        StringBuilder rightIndexString = new StringBuilder();
        for (Object index : rightAnswerIndex) {
            rightIndexString.append(index + " ");
        }
        return rightIndexString;
    }

    @Override
    public StringBuilder getIndexStringOfWrongAnswers() {
        StringBuilder wrongIndexString = new StringBuilder();
        for (Object index : wrongAnswerIndex) {
            wrongIndexString.append(index + " ");
        }
        return wrongIndexString;
    }

    @Override
    public ArrayList<Integer> getCorrectResults() {
        for (int index = 0; index < this.formulasQuantity; index++) {
            this.correctResults.add(formulasList.get(index).getResult());
        }
        return this.correctResults;
    }

    @Override
    public ArrayList getRightAnswerList() {
        return this.rightAnswerIndex;
    }

    @Override
    public ArrayList getWrongAnswerList() {
        return this.wrongAnswerIndex;
    }

    private void getExerciseOfBaseFormula(int formulasQuantity) {
        isInputLegal = true;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:/JavaFile/AdditionBase.txt"))) {
            for (int i = 0; i < OperationBase.TOTAL_OPERATIONS_IN_BASE; i++) {
                AbstractBinaryOperation binaryOperation = (AbstractBinaryOperation) objectInputStream.readObject();
                tempOfBase.add(binaryOperation);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int count = 0; count < formulasQuantity; count++) {
            int randomIndex = new Random().nextInt(tempOfBase.size() + 1);
            this.formulasList.add(tempOfBase.get(randomIndex));
        }
    }

    private void getExerciseOfRandomFormula(int formulasQuantity) {
        isInputLegal = true;
        for (int i = 0; i < formulasQuantity; i++) {
            this.formulasList.add(new AdditionOperation());
        }
    }

}

