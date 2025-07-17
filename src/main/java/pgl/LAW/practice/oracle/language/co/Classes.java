package pgl.LAW.practice.oracle.language.co;

public class Classes {
    public double computePayment(
            double loanAmt,
            double rate,
            double futureValue,
            int numPeriods) {
        double interest = rate / 100.0;
        double partial1 = Math.pow((1 + interest),
                - numPeriods);
        double denominator = (1 - partial1) / interest;
        double answer = (-loanAmt / denominator)
                - ((futureValue * partial1) / denominator);
        return answer;
    }

    public Classes polygonFrom(String[] corners) {
        // method body goes here
        return null;
    }

    public int x = 0;
    public int y = 0;

    public Classes polygonFrom(Classes... corners) {
        int numberOfSides = corners.length;
        double squareOfSide1, lengthOfSide1;
        squareOfSide1 = (corners[1].x - corners[0].x)
                * (corners[1].x - corners[0].x)
                + (corners[1].y - corners[0].y)
                * (corners[1].y - corners[0].y);
        lengthOfSide1 = Math.sqrt(squareOfSide1);

        // more method body code follows that creates and returns a
        // polygon connecting the Points
        return null;
    }

    // parameters shadow fields
    public class Circle {
        private int x, y, radius;
        public void setOrigin(int x, int y) {}
    }

    class Bicycle1 {

        // the Bicycle class has
        // three fields
        public int cadence;
        public int gear;
        public int speed;

        // the Bicycle class has
        // one constructor
        public Bicycle1(int startCadence, int startSpeed, int startGear) {
            gear = startGear;
            cadence = startCadence;
            speed = startSpeed;
        }

        // the Bicycle class has
        // four methods
        public void setCadence(int newValue) {
            cadence = newValue;
        }

        public void setGear(int newValue) {
            gear = newValue;
        }

        public void applyBrake(int decrement) {
            speed -= decrement;
        }

        public void speedUp(int increment) {
            speed += increment;
        }

    }

    class MountainBike1 extends Bicycle1 {

        // the MountainBike subclass has
        // one field
        public int seatHeight;

        // the MountainBike subclass has
        // one constructor
        public MountainBike1(int startHeight, int startCadence,
                             int startSpeed, int startGear) {
            super(startCadence, startSpeed, startGear);
            seatHeight = startHeight;
        }

        // the MountainBike subclass has
        // one method
        public void setHeight(int newValue) {
            seatHeight = newValue;
        }

    }

    // overload mehtods
    class DataArtist {
        public void draw(String s) {}
        public void draw(int i) {}
        public void draw(double f) {}
        public void draw(int i, double f) {}
    }

    class PassPrimitiveByValue {

        public void main(String[] args) {
            int x = 3;
            // invoke passMethod() with
            // x as argument
            passMethod(x);
            // print x to see if its
            // value has changed
            System.out.println("After invoking passMethod, x = " + x);
        }

        // change parameter in passMethod()
        public void passMethod(int p) {
            p = 10;
        }
    }

    class Circle1 {

        int x, y, radius;

        public void main(String[] args) {
            Circle1 myCircle = new Circle1(10, 20);
            moveCircle(myCircle, 23, 56);
            System.out.println("After invoking moveCircle, x = " + myCircle.x);
            System.out.println("After invoking moveCircle, y = " + myCircle.y);
        }

        // method is transfered and the change is saved
        public void moveCircle(Circle1 circle, int deltaX, int deltaY) {
            // code to move origin of circle to x+deltaX, y+deltaY, persist
            circle.setX(circle.getX() + deltaX);
            circle.setY(circle.getY() + deltaY);
            // code to assign a new reference to circle, has no permanence
            circle = new Circle1(0, 0);
        }

        public Circle1(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int X) {this.x = X;}

        public void setY(int Y) {this.y = Y;}

        public int getX() {return x;}

        public int getY() {return y;}
    }
}



