package main.phrase3.operation;

import java.util.Random;
import java.io.Serializable;

public abstract class AbstractBinaryOperation implements Serializable {
    private static final long serialVersionUID = 1L;

    int leftOp;
    int rightOp;
    int result;
    char operator;

    public abstract boolean checkResult();

    public void setLeftOp() {
        this.leftOp = new Random().nextInt(101);
    }

    public void setRightOp() {
        this.rightOp = new Random().nextInt(101);
    }

    public int getResult() {
        return this.result;
    }

    public String fullString() {
        return (this.leftOp + "" + this.operator + "" + this.rightOp + " = " + this.result + '\t');
    }

    public String toString() {
        return (this.leftOp + "" + this.operator + "" + this.rightOp + " = " + '\t');
    }
}
