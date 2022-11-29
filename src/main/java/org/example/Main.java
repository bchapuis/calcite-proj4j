package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {
    var connection = DriverManager.getConnection("jdbc:calcite:fun=spatial");

    var sql1 = "SELECT 1";
    var rs1 = connection.createStatement().executeQuery(sql1);
    while (rs1.next()) {
      System.out.println(rs1.getString(1));
    }
    rs1.close();

    var sql2 = "SELECT ST_Transform(ST_GeomFromText('POINT(0 0)', 4326), 2163)";
    var rs2 = connection.createStatement().executeQuery(sql2);
    while (rs2.next()) {
      System.out.println(rs2.getString(1));
    }
    rs2.close();
  }
}
