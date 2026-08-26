package example.day02_practice.model.dto;

public class CustomerDto {
    private int no;
    private String phone;
    private int people;

    public CustomerDto(){}
    
    public CustomerDto(int no, String phone, int people){
        this.no = no;
        this.phone = phone;
        this.people = people;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getPeople() {
        return people;
    }
    public void setPeople(int people) {
        this.people = people;
    }

    
}
