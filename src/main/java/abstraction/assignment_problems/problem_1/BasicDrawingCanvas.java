package abstraction.assignment_problems.problem_1;

public class BasicDrawingCanvas {
    static abstract class Shape {
        private static int nextId = 1001;
        private final String shapeId = "SH-" + nextId++;

        public abstract double calculateArea();

        public abstract void scale(double factor);

        public abstract void scale(double xFactor, double yFactor);

        public String getShapeId() {
            return shapeId;
        }
    }

    static class CircleShape extends Shape {
        private double radius;

        CircleShape(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public void scale(double factor) {
            radius *= factor;
        }

        @Override
        public void scale(double xFactor, double yFactor) {
            radius *= xFactor * yFactor;
        }
    }

    static class SquareShape extends Shape {
        private double side;

        SquareShape(double side) {
            this.side = side;
        }

        @Override
        public double calculateArea() {
            return side * side;
        }

        @Override
        public void scale(double factor) {
            side *= factor;
        }

        @Override
        public void scale(double xFactor, double yFactor) {
            side *= xFactor * yFactor;
        }
    }

    static void printArea(Shape shape) {
        System.out.println(shape.calculateArea());
    }
}
