package org.example;
import java.sql.*;

import org.testng.annotations.Test;

import org.example.ConnectionBaseClass;

public class EmployeeDatabase extends ConnectionBaseClass{


    @Test(priority = 1)
    public void  test_DB_InsertData() throws SQLException {
        connection=super.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into Employee_Payroll values (?,?,?,?);");
        preparedStatement.setInt(1, 101);
        preparedStatement.setString(2, "Raj Sharma");
        preparedStatement.setDouble(3,30000);
        preparedStatement.setDate(4, Date.valueOf("2024-08-24"));
        preparedStatement.executeUpdate();
        System.out.println("The Value is inserted successfully");
        test_DB_SelectData();
    }
    @Test(priority = 2)
    public void test_DB_UpdateData() throws SQLException {
        connection=super.getConnection();
        PreparedStatement  preparedStatement = connection.prepareStatement("update employee_payroll set employeeName= ? where employeeId=?;");
        preparedStatement.setString(1, "Modi Ji");
        preparedStatement.setInt(2, 101);
        preparedStatement.executeUpdate();
        System.out.println("Employee is updated successfully");
        test_DB_SelectData();
    }

    @Test(priority = 3)
    public void test_DB_DeleteData() throws SQLException {
        connection=super.getConnection();
        PreparedStatement  preparedStatement = connection.prepareStatement("delete from employee_payroll where employeeId=?;");
        preparedStatement.setInt(1, 101);
        preparedStatement.executeUpdate();
        System.out.println("deleted successfully");
        test_DB_SelectData();
    }

    @Test(priority = 4)
    public void test_DB_SelectData() throws SQLException {
        System.out.println("Displaying all data present in the database");
        connection=super.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee_payroll;");
        while(resultSet.next()) {
            System.out.println("Employee_payroll Id is : "+resultSet.getInt(1)+" And the name is : "+resultSet.getString(2) +" salary is : "+resultSet.getString(3)+" role is : "+resultSet.getString(4));
        }


    }

}
