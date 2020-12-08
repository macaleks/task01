package ru.otus.model;

import java.util.Objects;

public class Question {
    private int id;
    private String question;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return id == question1.id &&
                Objects.equals(question, question1.question);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, question);
    }
}
