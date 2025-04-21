package backend;

import static constants.FileNames.TRAINER_FILENAME;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminRole {
    private TrainerDatabase database;

    public AdminRole() throws FileNotFoundException {
        this.database = new TrainerDatabase(TRAINER_FILENAME);
    }

    public boolean addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        if (database.contains(trainerId)) {
            return false;
        }
        Trainer newTrainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        database.insertRecord(newTrainer);
        return true;
    }

    public ArrayList<Trainer> getListOfTrainers() {
        ArrayList<Trainer> trainerList = new ArrayList<>();
        for (GymSystemData record : database.returnAllRecords()) {
            trainerList.add((Trainer) record);
        }
        return trainerList;
    }

    public boolean removeTrainer(String key) throws IOException {
        if (!database.contains(key)) {
            System.out.println("Trainer does not exist!");
            return false;
        }
        database.deleteRecord(key);
        return true;
    }

    public void logout() throws IOException {
        database.saveToFile();
    }
}
