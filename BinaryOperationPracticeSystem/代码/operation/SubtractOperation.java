package main.phrase3.operation;


public class SubtractOperation extends AbstractBinaryOperation {

    public SubtractOperation() {
        this.generateQualifiedOperation();
    }

    public SubtractOperation(int leftOp, int rightOp) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
        this.operator = '-';
        this.result = leftOp - rightOp;
    }

    private void generateQualifiedOperation() {
        do {
            this.setLeftOp();
            this.setRightOp();
            this.operator = '-';
            this.result = leftOp - rightOp;
        } while (!checkResult());
    }

    @Override
    public boolean checkResult() {
        return this.result >= 0 ? true : false;
    }

}
