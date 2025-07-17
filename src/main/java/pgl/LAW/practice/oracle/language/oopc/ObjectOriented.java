package pgl.LAW.practice.oracle.language.oopc;

public class ObjectOriented {
    class Bicycle {
        int cadence = 0;
        int speed  = 0;
        int gear = 1;
        void changeCadence(int newValue) {
            cadence = newValue;
        }
    }

    class MountainBike extends Bicycle {
        //
    }
}



