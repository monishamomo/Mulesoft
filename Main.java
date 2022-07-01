package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert("  SINGAM ","  Surya ","Anushka Shetty",2010,"Hari");
	insert("  ETHIR NEECHAL ","SivaKarthikeyan","Priya Anand",2013,"R.S Durai Senthilkumar");
	insert("MASTER "," Vijay","Malavika Mohanan",2021,"Lokesh Kanagaraj");
	insert("VELAILLA PATTADHARI","Dhanush   ","Amala paul ",2014,"Velraj");
	insert("LAABAM","Vijay Sethupahi","Shruti Haasan ",2021,"S.P Jananathan");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
