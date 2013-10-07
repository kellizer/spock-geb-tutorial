package com.spockgeb.tutorial.spock;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Date;

/**
 * Samples for the Spock/Geb Tutorials
 *
 * @author Ian Kelly
 */
public class DateService {

    /**
     * Returns a persons age from their DOB
     *
     * @param dob - the date that they were born
     * @return their age (as of today)
     */
    public int ageFromDOB(Date dob) {
        LocalDate birthdate = new LocalDate(dob.getTime());
        DateTime now = new DateTime();
        return (Years.yearsBetween(birthdate.toDateTimeAtStartOfDay(), now)).getYears();
    }
}
