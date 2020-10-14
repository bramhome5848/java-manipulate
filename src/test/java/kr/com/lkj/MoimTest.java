package kr.com.lkj;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MoimTest {

    @Test
    public void isFull() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfCurrentEnrollment = 10;
        assertFalse(moim.isEnrollmentFull());
    }
}