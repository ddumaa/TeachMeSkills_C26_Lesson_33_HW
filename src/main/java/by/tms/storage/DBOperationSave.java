package by.tms.storage;

import by.tms.model.Operation;
import by.tms.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperationSave {
    public static void operationSave (Operation operation){
        String n1 = String.valueOf(operation.getNum1());
        String o = String.valueOf(operation.getType());
        String n2 = String.valueOf(operation.getNum2());
        String r = String.valueOf(operation.getResult());
        String all = n1 + " " + o + " " + n2 + " = " + r;
        long id = operation.getAuthor().getId();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "NetLove62");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into archive_operation values (?, default, ?)");
            preparedStatement.setString(1, all);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
