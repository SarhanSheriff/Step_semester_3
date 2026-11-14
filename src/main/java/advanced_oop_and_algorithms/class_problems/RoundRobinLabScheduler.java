package advanced_oop_and_algorithms.class_problems;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class RoundRobinLabScheduler {
    static class Job {
        String name;
        int remainingTime;
        Job(String name, int remainingTime) {
            this.name = name;
            this.remainingTime = remainingTime;
        }
    }
    static class Finish {
        String name;
        int time;
        Finish(String name, int time) { this.name = name; this.time = time; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantum = sc.nextInt();
        int n = sc.nextInt();
        Queue<Job> jobs = new ArrayDeque<>();
        for (int i = 0; i < n; i++) jobs.offer(new Job(sc.next(), sc.nextInt()));
        List<Finish> finished = new ArrayList<>();
        StringBuilder timeline = new StringBuilder();
        int currentTime = 0;
        while (!jobs.isEmpty()) {
            Job job = jobs.poll();
            int runTime = Math.min(quantum, job.remainingTime);
            int start = currentTime;
            currentTime += runTime;
            job.remainingTime -= runTime;
            if (timeline.length() > 0) timeline.append(" ");
            timeline.append(job.name).append("(").append(start).append("-").append(currentTime).append(")");
            if (job.remainingTime > 0) jobs.offer(job);
            else finished.add(new Finish(job.name, currentTime));
        }
        System.out.println(timeline);
        System.out.print("finish ");
        for (int i = 0; i < finished.size(); i++) {
            if (i > 0) System.out.print(", ");
            Finish item = finished.get(i);
            System.out.print(item.name + " " + item.time);
        }
        System.out.println();
        // Time is O(total executed time slices); queue space is O(n).
    }
}