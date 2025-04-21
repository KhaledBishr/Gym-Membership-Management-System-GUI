package backend;

public class Member implements GymSystemData{

    public String memberID;
    public String name;
    public String membershipType;
    public String email;
    public String phoneNumber;
    public String status;

    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        this.memberID = memberID;
        this.name = name;
        this.membershipType = membershipType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }
    


    @Override
    public String lineRepresentation() {
        String line = memberID + "," + name + "," + membershipType + "," + email + "," + phoneNumber + "," + status;
        return line;
    }

    @Override
    public String getKey() {
        return memberID;
    }
}