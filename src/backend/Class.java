package backend;

public class Class implements GymSystemData {
    public String classID;
    public String className;
    public String trainerID;
    public int duration;
    public int availableSeats;
    public int maxParticipants = availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = Math.max(availableSeats, 0);
        maxParticipants = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = Math.max(availableSeats, 0);
    }

    @Override
    public String lineRepresentation() {
        return classID + "," + className + "," + trainerID + "," + duration + "," + availableSeats;
    }

    @Override
    public String getKey() {
        return classID;
    }
}
