package project;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AdminTest.class, Doctor.class, BookingTest.class, PatientTest.class})
public class AllTests {
	
}
