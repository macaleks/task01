package ru.otus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.dao.AnswerDao;
import ru.otus.dao.QuestionDao;
import ru.otus.model.Answer;
import ru.otus.model.Question;
import ru.otus.service.CheckAnswerService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/appContext.xml");
        AnswerDao dao = ctx.getBean("answerDao", AnswerDao.class);
        QuestionDao questionDao = ctx.getBean("questionDao", QuestionDao.class);

        Map<Integer, List<Answer>> allAnswers = dao.getMapOfAnswers();
        Map<Integer, Question> allQuestions = questionDao.getMapOfQuestions();

        int num;
        while (true) {
            System.out.println("Select a question. Enter its number or -1 to exit.");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            allQuestions.values().forEach(q -> System.out.println(String.format("%d. %s", q.getId(), q.getQuestion())));

            //Check that it is not out of range
            num = scanner.nextInt();
            if (num == -1) break;
            if (!allQuestions.containsKey(num)) {
                System.out.println("No such question.");
                System.out.println("*******************************************************");
                continue;
            }

            List<Answer> answers = allAnswers.get(num);
            long correctAnswers = answers.stream().filter(Answer::isCorrect).count();

            System.out.printf("Select %d correct answers(press Enter after each selected answer):", correctAnswers);
            System.out.println();
            for (int i = 0; i < answers.size(); i++) {
                System.out.println(String.format("%d. %s", i, answers.get(i).getAnswer()));
            }
            Set<Answer> respond = new HashSet<>();
            for (int i = 0; i < correctAnswers; i++) {
                int var = scanner.nextInt();
                //Check that it is not out of range
                if (var >=0 && var < answers.size()) {
                    respond.add(answers.get(var));
                }
            }
            //check the answer
            CheckAnswerService.check(respond, correctAnswers);
        }
    }
}
