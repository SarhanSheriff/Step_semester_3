package inheritance.class_problems;

import java.time.*;

public class EmployeeLeaveManagement {
    interface LeavePolicy {
        boolean canTakeLeave(int days);
    }

    static class FullTimePolicy implements LeavePolicy {
        public boolean canTakeLeave(int days) {
            return days <= 30;
        }
    }

    static class PartTimePolicy implements LeavePolicy {
        public boolean canTakeLeave(int days) {
            return days <= 15;
        }
    }

    static class ContractPolicy implements LeavePolicy {
        public boolean canTakeLeave(int days) {
            return days <= 10;
        }
    }

    static class Employee {
        private final String name;
        private final LeavePolicy policy;

        Employee(String name, LeavePolicy policy) {
            this.name = name;
            this.policy = policy;
        }

        boolean canTakeLeave(int days) {
            return policy.canTakeLeave(days);
        }

        String getName() {
            return name;
        }
    }

    enum Status {
        PENDING, APPROVED, REJECTED
    }

    static class LeaveRequest {
        private final Employee employee;
        private final LocalDate from;
        private final LocalDate to;
        private Status status = Status.PENDING;

        LeaveRequest(Employee employee, LocalDate from, LocalDate to) {
            this.employee = employee;
            this.from = from;
            this.to = to;
        }

        void approve() {
            if (status != Status.PENDING) {
                throw new IllegalStateException("Request is already reviewed");
            }

            int days = (int) (to.toEpochDay() - from.toEpochDay() + 1);
            if (!employee.canTakeLeave(days)) {
                throw new IllegalStateException("Leave policy limit exceeded");
            }

            status = Status.APPROVED;
        }

        void reject() {
            if (status != Status.PENDING) {
                throw new IllegalStateException("Request is already reviewed");
            }
            status = Status.REJECTED;
        }

        Status getStatus() {
            return status;
        }
    }

    static class ApprovalService {
        void approve(LeaveRequest request) {
            request.approve();
        }

        void reject(LeaveRequest request) {
            request.reject();
        }
    }
}
