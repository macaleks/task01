package ru.otus.dao;

import ru.otus.model.Question;
import ru.otus.parser.IParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class QuestionDao {

    private final IParser<Question> parser;
    private final String filename;

    public QuestionDao(IParser<Question> parser, String filename) {
        this.parser = parser;
        this.filename = filename;
    }

    public Map<Integer, Question> getMapOfQuestions() {
        List<Question> questions = new ArrayList<>();
        parser.parseCsv(filename, questions::add);
        return questions.stream()
                .collect(toMap(k -> k.getId(), v -> v));
    }
}
