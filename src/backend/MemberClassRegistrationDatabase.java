package backend;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends GymSystemDatabase{

    public MemberClassRegistrationDatabase(String filename) throws FileNotFoundException {
        super(filename);
    }
@Override
    public GymSystemData createRecordFrom(String line) {

        String[] seperatedLine = line.split(",");

        LocalDate registrationDate = LocalDate.parse(seperatedLine[3]);
        return new MemberClassRegistration(seperatedLine[0],seperatedLine[1],seperatedLine[2], registrationDate);
    }

}
