package com.kookee.generator.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kuki on 2015-11-01.
 */
public class JDBCExceptionGenerator implements ExceptionGenerator {
	//komentarz
    public void generate() {
        try {
            Connection con = DriverManager.getConnection("asd");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
