package backend;

import java.io.FileNotFoundException;

public class ClassDatabase extends GymSystemDatabase{

    public ClassDatabase(String filename) throws FileNotFoundException {
        super(filename);
    }
@Override
    public Class createRecordFrom(String line) {
        String[] seperatedLine = line.split(",");

        int duration = Integer.parseInt(seperatedLine[3]);
        int availableSeats = Integer.parseInt(seperatedLine[4]);
        return new Class(seperatedLine[0],seperatedLine[1],seperatedLine[2], duration, availableSeats);
    }

}


