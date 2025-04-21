package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class GymSystemDatabase {
    protected ArrayList<GymSystemData> temp;
    protected String filename;

    public GymSystemDatabase(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.temp = new ArrayList<>();
        readFromFile();
    }

    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);

        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            GymSystemData T = createRecordFrom(line);
            temp.add(T);
        }
        scan.close();
    }

    public void saveToFile() throws IOException {
        File f = new File(filename);
        PrintWriter pw = new PrintWriter(f);


        for (GymSystemData i : temp) {
            pw.println(i.lineRepresentation());
        }
        pw.close();
    }


    public ArrayList<GymSystemData> returnAllRecords() {
        return temp;
    }

    public boolean contains(String key) {
        for (GymSystemData record : temp) {
            if (record.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public GymSystemData getRecord(String key) {
        for (GymSystemData record : temp) {
            if (record.getKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public void insertRecord(GymSystemData record) {
        if (contains(record.getKey())) {
            System.out.println("Record with key " + record.getKey() + " already exists.");
        } else {
            temp.add(record);
        }
    }

    public void deleteRecord(String key) throws IOException {
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getKey().equals(key)) {
                temp.remove(i);
            }
        }

    }
    protected abstract GymSystemData createRecordFrom(String line);

}

