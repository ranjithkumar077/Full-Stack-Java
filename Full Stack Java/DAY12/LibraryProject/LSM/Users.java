package LSM;

public class Users {
    String Username ;
    String password;
    long contactNumber;
    String emailId;
    String role;
    String Id;
    Address address;
    public Users(String username, String password, long contactNumber, String emailId, String role, String id, Address address,
        String doorNumber, String street, String city, String state, String country, String pinCode) {
        Username = username;
        this.password = password;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.role = role;
        Id = id;
        this.address = address;
    Address address2=new Address(doorNumber, street, city, state, country, pinCode);
    this.address=address2;

    }
}
