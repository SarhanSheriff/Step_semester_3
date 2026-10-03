package inheritance.class_problems;

import java.util.*;

public class OnlineExaminationSystem {
    interface Question {
        boolean checkAnswer(String answer);
    }

    static class MultipleChoice implements Question {
        private final String correct;

        MultipleChoice(String correct) {
            this.correct = correct;
        }

        public boolean checkAnswer(String answer) {
            return correct.equalsIgnoreCase(answer);
        }
    }

    static class TrueFalse implements Question {
        private final boolean correct;

        TrueFalse(boolean correct) {
            this.correct = correct;
        }

        public boolean checkAnswer(String answer) {
            return Boolean.parseBoolean(answer) == correct;
        }
    }

    static class Examination {
        private final String title;
        private final List<Question> questions = new ArrayList<>();

        Examination(String title) {
            this.title = title;
        }

        void addQuestion(Question question) {
            questions.add(question);
        }

        Attempt start(Student student) {
            return new Attempt(student, this);
        }

        String getTitle() {
            return title;
        }
    }

    static class Student {
        private final String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class Attempt {
        private final Student student;
        private final Examination exam;
        private final Map<Integer, String> answers = new HashMap<>();
        private boolean submitted;

        Attempt(Student student, Examination exam) {
            this.student = student;
            this.exam = exam;
        }

        void answer(int number, String answer) {
            if (submitted) {
                throw new IllegalStateException("Attempt already submitted");
            }
            answers.put(number, answer);
        }

        int submit() {
            if (submitted) {
                throw new IllegalStateException("Attempt already submitted");
            }

            int score = 0;
            for (int i = 0; i < exam.questions.size(); i++) {
                String answer = answers.get(i);
                if (answer != null && exam.questions.get(i).checkAnswer(answer)) {
                    score++;
                }
            }

            submitted = true;
            return score;
        }
    }
}
