package backend;

import static constants.FileNames.CLASS_FILENAME;
import static constants.FileNames.MEMBER_FILENAME;
import static constants.FileNames.REGISTRATION_FILENAME;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;

public class TrainerRole {

    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() throws FileNotFoundException {
        this.memberDatabase = new MemberDatabase(MEMBER_FILENAME);
        this.classDatabase = new ClassDatabase(CLASS_FILENAME);
        this.registrationDatabase = new MemberClassRegistrationDatabase(REGISTRATION_FILENAME);
    }

    public boolean addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if (memberDatabase.contains(memberID)) {
            
            return false;
        }
        Member newMember = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(newMember);
        return true;
    }

    public ArrayList<Member> getListOfMembers() {
        ArrayList<Member> memberList = new ArrayList<>();
        for (GymSystemData record : memberDatabase.returnAllRecords()) {
            memberList.add((Member) record);
        }
        return memberList;
    }

    public boolean addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        if (classDatabase.contains(classID)) {
            return false;
        }
        Class newClass = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(newClass);
        return true;
    }

    public ArrayList<Class> getListOfClasses() {
        ArrayList<Class> classList = new ArrayList<>();
        for (GymSystemData record : classDatabase.returnAllRecords()) {
            classList.add((Class) record);
        }
        return classList;
    }

    public int registerMemberForClass(String memberID, String classID, LocalDate registrationDate) throws IOException {
        if (!memberDatabase.contains(memberID)) {

            return 1;
        }
        Class gymClass = (Class) classDatabase.getRecord(classID);
        if (gymClass == null) {
            return 2;
        }

        if (gymClass.getAvailableSeats() <= 0) {
            return 3;
        }

        String registrationKey = memberID + classID;
        if (registrationDatabase.contains(registrationKey)) {
            return 4;
        }

        MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, "active", registrationDate);
        registrationDatabase.insertRecord(registration);
        gymClass.setAvailableSeats(gymClass.getAvailableSeats() - 1);

        return 10;
    }


    public int cancelRegistration(String memberID, String classID) throws IOException {
        String registrationKey = memberID + classID;
        MemberClassRegistration registration = (MemberClassRegistration) registrationDatabase.getRecord(registrationKey);

        if (registration == null) {
            return 1;
        }

        LocalDate now = LocalDate.now();
        LocalDate registrationDate = registration.getRegistrationDate();
        if (now.isAfter(registrationDate.plusDays(3))) {
            return 2;
        }
        registration.setRegistrationStatus("canceled");

        Class gymClass = (Class) classDatabase.getRecord(classID);
        if (gymClass != null) {
            gymClass.setAvailableSeats(gymClass.getAvailableSeats() + 1);
        }

        return 10;
    }

    public AbstractList<MemberClassRegistration> getListOfRegistrations() {
        ArrayList<MemberClassRegistration> registrationList = new ArrayList<>();
        for (GymSystemData record : registrationDatabase.returnAllRecords()) {
            registrationList.add((MemberClassRegistration) record);
        }
        return registrationList;
    }

    public void logout() throws IOException {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }
}
