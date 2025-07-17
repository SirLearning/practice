package pgl.LAW.practice.oracle.language.co;

public class MoreOnClasses {
    private class Rectangle2 {
        private int x, y;
        private int width, height;

        private Rectangle2() {
            this(0, 0, 1, 1);
        }
        private Rectangle2(int width, int height) {
            this(0, 0, width, height);
        }
        private Rectangle2(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

//    public class Bicycle {
//
//        private int cadence;
//        private int gear;
//        private int speed;
//        private int id;
//        private static int numberOfBicycles = 0;
//
//        static final double PI = 3.141592653589793;
//
//        public Bicycle(int startCadence, int startSpeed, int startGear){
//            gear = startGear;
//            cadence = startCadence;
//            speed = startSpeed;
//            // increment number of Bicycles
//            // and assign ID number
//            id = ++numberOfBicycles;
//        }
//
//        // new method to return the ID instance variable
//        public int getID() {
//            return id;
//        }
//
//        public static int getNumberOfBicycles() {
//            return numberOfBicycles;
//        }
//    }
}

