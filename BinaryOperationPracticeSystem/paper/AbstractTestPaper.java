package main.phrase3.paper;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractTestPaper implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract int getScore();

    public abstract void getAnalysis();

    public abstract void setScore(int score);

    public abstract void formatAndDisplay(int colAmount);

    public abstract ArrayList getRightAnswerList();

    public abstract ArrayList getWrongAnswerList();

    public abstract ArrayList<Integer> getCorrectResults();

    public abstract StringBuilder getIndexStringOfRightAnswers();

    public abstract StringBuilder getIndexStringOfWrongAnswers();
}
