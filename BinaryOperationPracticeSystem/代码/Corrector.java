package main.phrase3;

import java.util.ArrayList;

public class Corrector {

    public static void markPaper() {
        ArrayList[] userAnswers;
        ArrayList[] correctAnswers;
        userAnswers = User.getAnswers();
        correctAnswers = new ArrayList[User.getPapersCount()];
        for (int i = 0; i < User.getPapersCount(); i++) {
            ArrayList aPaperCorrectResult = Main.papers[i].getCorrectResults();
            correctAnswers[i] = aPaperCorrectResult;
        }
        for (int paperIndex = 0; paperIndex < User.getPapersCount(); paperIndex++) {
            ArrayList rightAnswerList = Main.papers[paperIndex].getRightAnswerList();
            ArrayList wrongAnswerList = Main.papers[paperIndex].getWrongAnswerList();

            for (int operationIndex = 0; operationIndex < User.getOperationCount(); operationIndex++) {
                int tempOperationIndex = operationIndex;
                try {
                    if (userAnswers[paperIndex].get(operationIndex).equals
                            (correctAnswers[paperIndex].get(operationIndex))) {
                        rightAnswerList.add(++tempOperationIndex);
                    } else {
                        wrongAnswerList.add(++tempOperationIndex);
                    }
                } catch (Exception e) {
                    wrongAnswerList.add(++tempOperationIndex);
                }

            }
            Main.papers[paperIndex].setScore(rightAnswerList.size());
        }


    }

}
