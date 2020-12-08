package ru.otus.service;

import ru.otus.model.Answer;

import java.util.Set;

public class CheckAnswerService {

    public static void check(Set<Answer> respond, long correctAnswers) {
        long correctAnswersGiven = respond.stream()
                .filter(it -> it != null)
                .filter(Answer::isCorrect)
                .count();

        if (correctAnswersGiven == 0) {
            System.out.println("Not correct");
        } else if (correctAnswersGiven > 0 && correctAnswersGiven < correctAnswers) {
            System.out.println("Not fully correct");
        } else if (correctAnswersGiven == correctAnswers) {
            System.out.println("Correct");
        }
        System.out.println();
    }
}
