package main.phrase3;

import main.phrase3.operation.AbstractBinaryOperation;
import main.phrase3.operation.AdditionOperation;
import main.phrase3.operation.SubtractOperation;

import java.io.*;

public class OperationBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int MIN_VALUE_IN_OPERATION = 0;
    public static final int MAX_VALUE_IN_OPERATION = 100;
    public static final int TOTAL_OPERATIONS_IN_BASE = 5149;
    private static AbstractBinaryOperation[][] operationBase;

    public static void init() throws IOException {
        //"file/AdditionBase.txt"
        //"file/SubtractBase.txt"
        //D:\Project\Java_IDEA\softwareconstruction\src\main\phrase3\operation\AbstractBinaryOperation.java
        File JavaFile = new File("C:/JavaFile");
        if (!JavaFile.exists()) {
            JavaFile.mkdirs();
        }
        File additionBaseFile = new File("C:/JavaFile/AdditionBase.txt");
        File subtractBaseFile = new File("C:/JavaFile/SubtractBase.txt");
        if (!additionBaseFile.exists())
            additionBaseFile.createNewFile();
        if (!subtractBaseFile.exists())
            subtractBaseFile.createNewFile();

        generateAdditionBase();
        generateSubtractBase();

    }

    //系统用的是算式基文件,我这里算式基只是用来显示的
    private static void generateAdditionBase() {
        AdditionOperation additionOperation;
        operationBase = new AdditionOperation[MAX_VALUE_IN_OPERATION + 1][MAX_VALUE_IN_OPERATION + 1];
        for (int i = 0; i <= MAX_VALUE_IN_OPERATION; i++) {
            for (int j = 0; j <= MAX_VALUE_IN_OPERATION; j++) {
                if (i + j <= MAX_VALUE_IN_OPERATION) {
                    additionOperation = new AdditionOperation(i, j);
                    operationBase[i][j] = additionOperation;
                }
            }
        }
        savedToFile("AdditionBase");
    }

    private static void generateSubtractBase() {
        SubtractOperation subtractOperation;
        operationBase = new SubtractOperation[MAX_VALUE_IN_OPERATION + 1][MAX_VALUE_IN_OPERATION + 1];
        for (int i = 0; i <= MAX_VALUE_IN_OPERATION; i++) {
            for (int j = 0; j <= MAX_VALUE_IN_OPERATION; j++) {
                if (i - j >= MIN_VALUE_IN_OPERATION) {
                    subtractOperation = new SubtractOperation(i, j);
                    operationBase[i][j] = subtractOperation;
                }
            }
        }
        savedToFile("SubtractBase");
    }

    public static AbstractBinaryOperation[][] getAdditionBase() {
        generateAdditionBase();
        return operationBase;
    }

    public static AbstractBinaryOperation[][] getSubtractBase() {
        generateSubtractBase();
        return operationBase;
    }

    private static void savedToFile(String fileName) {
        File file = new File("C:/JavaFile/" + fileName + ".txt");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < operationBase.length; i++) {
                for (int j = 0; j < operationBase[0].length; j++)
                    if (operationBase[i][j] != null) objectOutputStream.writeObject(operationBase[i][j]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // file.setReadOnly();
    }

    public void displayOperationBase(AbstractBinaryOperation[][] operationBase) {
        for (int row = 0; row < operationBase.length; row++) {
            for (int col = 0; col < operationBase[0].length; col++) {
                if (operationBase[row][col] != null) {
                    System.out.print(operationBase[row][col].fullString() + "\t");
                }
            }
            System.out.println("");
        }
    }


}
