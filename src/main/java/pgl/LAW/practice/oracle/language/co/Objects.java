package pgl.LAW.practice.oracle.language.co;

public class Objects {
    class Point {
        public int x = 0;
        public int y = 0;
        // a constructor!
        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    class Rectangle {
        public int width = 0;
        public int height = 0;
        public Point origin;

        // four constructors
        public Rectangle() {
            origin = new Point(0, 0);
        }
        public Rectangle(Point p) {
            origin = p;
        }
        public Rectangle(int w, int h) {
            origin = new Point(0, 0);
            width = w;
            height = h;
        }
        public Rectangle(Point p, int w, int h) {
            origin = p;
            width = w;
            height = h;
        }

        // a method for moving the rectangle
        public void move(int x, int y) {
            origin.x = x;
            origin.y = y;
        }

        // a method for computing the area of the rectangle
        public int getArea() {
            return width * height;
        }
    }

    class CreateObjectDemo {

        public void main(String[] args) {

            // create a instance and get its height, then the instance is recycled by Java Virtual Machine
            int height = new Rectangle().height;

            // Declare and create a point object and two rectangle objects.
            Point originOne = new Point(23, 94);
            Rectangle rectOne = new Rectangle(originOne, 100, 200);
            Rectangle rectTwo = new Rectangle(50, 100);

            // display rectOne's width, height, and area
            System.out.println("Width of rectOne: " + rectOne.width);
            System.out.println("Height of rectOne: " + rectOne.height);
            System.out.println("Area of rectOne: " + rectOne.getArea());

            // set rectTwo's position
            rectTwo.origin = originOne;

            // display rectTwo's position
            System.out.println("X Position of rectTwo: " + rectTwo.origin.x);
            System.out.println("Y Position of rectTwo: " + rectTwo.origin.y);

            // move rectTwo and display its new position
            rectTwo.move(40, 72);
            System.out.println("X Position of rectTwo: " + rectTwo.origin.x);
            System.out.println("Y Position of rectTwo: " + rectTwo.origin.y);
        }
    }
}

