package backend;

import java.io.FileNotFoundException;

public class MemberDatabase extends GymSystemDatabase{


    public MemberDatabase(String filename) throws FileNotFoundException {
        super(filename);
    }

    @Override
    public Member createRecordFrom(String line) {
        String[] seperatedLine = line.split(",");

        return new Member(seperatedLine[0],seperatedLine[1],seperatedLine[2],seperatedLine[3],seperatedLine[4],seperatedLine[5]);
    }

}
