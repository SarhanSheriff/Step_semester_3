package week8.assignment_problems.problem_1;

import java.util.*;

public class CodeSprintJudgingDesk {
    interface ScoringRule {
        double calculate(double idea, double execution, double presentation);
    }

    static class InnovationScoring implements ScoringRule {
        public double calculate(double idea, double execution, double presentation) {
            return idea * .50 + execution * .30 + presentation * .20;
        }
    }

    static class OpenScoring implements ScoringRule {
        public double calculate(double idea, double execution, double presentation) {
            return (idea + execution + presentation) / 3;
        }
    }

    static class Student {
        final String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class Team {
        final String name;
        final List<Student> members;
        final ScoringRule rule;
        Project project;

        Team(String name, List<Student> members, ScoringRule rule) {
            if (members.size() < 2 || members.size() > 4) {
                throw new IllegalArgumentException(
                        "A team must have 2 to 4 members");
            }
            this.name = name;
            this.members = new ArrayList<>(members);
            this.rule = rule;
        }

        void submit(Project project) {
            if (this.project != null) {
                throw new IllegalStateException("Team can submit only one project");
            }
            this.project = project;
        }
    }

    static class Project {
        final String name;
        Score score;

        Project(String name) {
            this.name = name;
        }
    }

    static class Score {
        final double idea;
        final double execution;
        final double presentation;

        Score(double idea, double execution, double presentation) {
            this.idea = idea;
            this.execution = execution;
            this.presentation = presentation;
        }
    }

    static class Judge {
        void score(Project project, double idea, double execution,
                   double presentation, boolean published) {
            if (published) {
                throw new IllegalStateException(
                        "Results have already been published");
            }
            project.score = new Score(idea, execution, presentation);
        }
    }

    static class Hackathon {
        enum State { OPEN, JUDGING, PUBLISHED }

        private State state = State.OPEN;
        private final List<Team> teams = new ArrayList<>();

        void register(Team team) {
            if (state != State.OPEN) {
                throw new IllegalStateException("Registration is closed");
            }

            for (Team old : teams) {
                for (Student student : team.members) {
                    if (old.members.contains(student)) {
                        throw new IllegalStateException(
                                "Student can belong to only one team");
                    }
                }
            }
            teams.add(team);
        }

        void startJudging() {
            state = State.JUDGING;
        }

        void publishResults() {
            state = State.PUBLISHED;
        }

        boolean isPublished() {
            return state == State.PUBLISHED;
        }
    }

    static double finalScore(Team team) {
        Score s = team.project.score;
        return team.rule.calculate(s.idea, s.execution, s.presentation);
    }
}
