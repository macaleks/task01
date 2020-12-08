package ru.otus.dao;

import ru.otus.model.Answer;
import ru.otus.parser.IParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class AnswerDao {

    private final IParser<Answer> parser;
    private final String filename;

    public AnswerDao(IParser<Answer> parser, String filename) {
        this.parser = parser;
        this.filename = filename;
    }

    public Map<Integer, List<Answer>> getMapOfAnswers() {
        List<Answer> answers = new ArrayList<>();
        parser.parseCsv(filename, answers::add);
        return answers.stream()
                .collect(groupingBy(Answer::getId));
    }
}
