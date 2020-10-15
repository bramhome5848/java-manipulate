package kr.com.lkj.jacoco;

import kr.com.lkj.jacoco.Moim;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * jacoco example
 */
public class MoimTest {

    @Test
    public void isFull() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfCurrentEnrollment = 10;
        assertTrue(moim.isEnrollmentFull());
    }

    @Test
    public void isNoEnrollment() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 0;
        assertFalse(moim.isEnrollmentFull());
    }

    @Test
    public void isEnrollment() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 20;
        moim.numberOfCurrentEnrollment = 20;
        assertFalse(moim.isEnrollmentFull());
    }
}