package example.day02_practice.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import example.day02_practice.model.dto.CustomerDto;

public class CustomerDao extends BaseDao{
    private CustomerDao(){};
    private static final CustomerDao instance = new CustomerDao();
    public static CustomerDao getInstance(){return instance;}



    public boolean reserve(CustomerDto customerDto){
        try{
            String sql = "INSERT INTO customer(phone, people) VALUES( ? , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerDto.getPhone());
            ps.setInt(2, customerDto.getPeople());

            int result = ps.executeUpdate();
            
            if (result == 1){
                return true;
            }
        }catch(SQLException e){System.out.println(e);}

        return false;
    }

    public ArrayList<CustomerDto> findAll(){
        ArrayList <CustomerDto> customerDtos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM customer;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                CustomerDto customerDto = new CustomerDto(rs.getInt("no"), rs.getString("phone"), rs.getInt("people"));
                customerDtos.add(customerDto);
            }
        }catch(SQLException e){System.out.println(e);}

        return customerDtos;
    }

    public boolean update(String phone, int people){
        try{
            String sql = "UPDATE customer SET people = ? WHERE phone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(2, phone);
            ps.setInt(1, people);

            int result = ps.executeUpdate();

            if (result == 1){
                return true;
            }
        }catch(SQLException e){System.out.println(e);}

        return false;
    }

    public boolean delete(String phone){
        try{
            String sql = "DELETE FROM customer where phone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            int result = ps.executeUpdate();

            if (result == 1){
                return true;
            }
        }catch(SQLException e){System.out.println(e);}

        return false;
    }
}
