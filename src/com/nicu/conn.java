package com.nicu;

import java.sql.*;


public class conn {
    private Connection conn;
    private Statement statmt;
    private PreparedStatement pstmt;

    
    public conn() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\SweetMilk\\Desktop\\ReadCSV\\sqlite\\X.db");
        conn.setAutoCommit(false);
           }

    
    public void CreateDB() throws SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'X' ('A' text , 'B' text, 'C' text,'D' text,'E' text,'F' text, 'G' text, 'H' text, 'I' text, 'J' text);");
       
    }

  
    public void WriteDB(String A, String B, String C, String D, String E, String F, String G, String H, String I, String J) throws SQLException {
        String sql = "INSERT INTO X(A,B,C,D,E,F,G,H,I,J) VALUES (?,?,?,?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, A);
        pstmt.setString(2, B);
        pstmt.setString(3, C);
        pstmt.setString(4, D);
        pstmt.setString(5, E);
        pstmt.setString(6, F);
        pstmt.setString(7, G);
        pstmt.setString(8, H);
        pstmt.setString(9, I);
        pstmt.setString(10, J);
        pstmt.executeUpdate();
    }

    
    public void CloseDB() throws SQLException {
        conn.commit();
        conn.close();
        statmt.close(); 
    }

}
