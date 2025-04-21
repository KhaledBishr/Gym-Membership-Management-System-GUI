package backend;

public class Trainer implements GymSystemData{
    public String trainerId;
    public String name;
    public String email;
    public String speciality;
    public String phoneNumber;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        String line;
        line = trainerId + "," + name + "," + email + "," + speciality + "," + phoneNumber;
        return line;
    }

    @Override
    public String getKey() {
        return trainerId;
    }
}