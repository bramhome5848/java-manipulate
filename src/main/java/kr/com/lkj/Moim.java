package kr.com.lkj;

public class Moim {

    int maxNumberOfAttendees;

    int numberOfCurrentEnrollment;

    public boolean isEnrollmentFull() {
        if(maxNumberOfAttendees == 0 ) {
            return false;
        }

        if(numberOfCurrentEnrollment < maxNumberOfAttendees) {
            return false;
        }

        return true;
    }
}
