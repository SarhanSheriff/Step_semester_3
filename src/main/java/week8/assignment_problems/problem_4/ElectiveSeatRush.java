package week8.assignment_problems.problem_4;

import java.util.*;

public class ElectiveSeatRush {
    interface CreditPolicy {
        int limit();
    }

    static class RegularPolicy implements CreditPolicy {
        public int limit() {
            return 24;
        }
    }

    static class HonorsPolicy implements CreditPolicy {
        public int limit() {
            return 28;
        }
    }

    static class ExchangePolicy implements CreditPolicy {
        public int limit() {
            return 20;
        }
    }

    static class Student {
        final String name;
        final CreditPolicy policy;
        int credits;

        Student(String name, CreditPolicy policy, int credits) {
            this.name = name;
            this.policy = policy;
            this.credits = credits;
        }

        boolean canAdd(int creditsToAdd) {
            return credits + creditsToAdd <= policy.limit();
        }
    }

    static class Elective {
        final String name;
        final int credits;
        private final int capacity;
        private final List<Student> enrolled = new ArrayList<>();
        private final Queue<Student> waitlist = new ArrayDeque<>();

        Elective(String name, int credits, int capacity) {
            this.name = name;
            this.credits = credits;
            this.capacity = capacity;
        }

        boolean contains(Student student) {
            return enrolled.contains(student) || waitlist.contains(student);
        }

        String enroll(Student student) {
            if (contains(student)) {
                return "Student already enrolled or waitlisted";
            }

            if (!student.canAdd(credits)) {
                return "Enrollment failed: credit limit exceeded";
            }

            if (enrolled.size() >= capacity) {
                waitlist.add(student);
                return student.name + " added to waitlist";
            }

            enrolled.add(student);
            student.credits += credits;
            return student.name + " enrolled in " + name;
        }

        String drop(Student student) {
            if (!enrolled.remove(student)) {
                return "Student is not enrolled";
            }

            student.credits -= credits;
            promote();
            return student.name + " dropped " + name;
        }

        private void promote() {
            while (!waitlist.isEmpty() && enrolled.size() < capacity) {
                Student student = waitlist.peek();

                if (!student.canAdd(credits)) {
                    waitlist.poll();
                    continue;
                }

                waitlist.poll();
                enrolled.add(student);
                student.credits += credits;
            }
        }
    }

    static class EnrollmentService {
        String enroll(Elective elective, Student student) {
            return elective.enroll(student);
        }

        String drop(Elective elective, Student student) {
            return elective.drop(student);
        }
    }
}
