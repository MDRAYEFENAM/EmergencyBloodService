package md_rayef_enam.emergencybloodservice.model;

/**
 * Created by Md_Rayef_Enam on 05-Jun-18.
 */

public class Student {
    private String name;
    private String password;
    private String phone;
    private String bloodGroup;
    private String address;

    public Student(String name, String password, String phone, String bloodGroup,String address) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.bloodGroup = bloodGroup;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                "name: " + name + '\n'+
                "phone" + phone + '\n'+
                "blood group"+ bloodGroup;
    }

    public String toStringForDialog() {
        return  "Name: "+name+"\n"+
                "Password: "+password+"\n"+
                "Phone No: "+phone+"\n"+
                "Address: "+address;
    }
}
