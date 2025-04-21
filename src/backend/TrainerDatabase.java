package backend;

import java.io.FileNotFoundException;

public class TrainerDatabase extends GymSystemDatabase{

    public TrainerDatabase(String filename) throws FileNotFoundException {
        super(filename);
        
    }

@Override
    public Trainer createRecordFrom(String line) {

        String[] temp = line.split(",");

        return  new Trainer(temp[0], temp[1], temp[2], temp[3], temp[4]);
    }

}
