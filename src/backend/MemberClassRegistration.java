package backend;

import java.time.LocalDate;

public class MemberClassRegistration implements GymSystemData{

    public String memberID;
    public String classID;
    public String status;
    public LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, String status, LocalDate registrationDate) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }


    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationStatus(String status) {
        this.status = status;
    }

    @Override
    public String getKey() {
        return memberID + classID;
    }

    @Override
    public String lineRepresentation() {
        String line = memberID + "," + classID + "," + status + "," + registrationDate;
        return line;
    }
}
