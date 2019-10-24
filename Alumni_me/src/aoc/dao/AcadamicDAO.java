package aoc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import core.util.DataObject;
import core.util.LoggerManager;
import aoc.dto.*;



public class AcadamicDAO extends DataObject{
	  
	Connection con;
	public AcadamicDAO()
	{
		con=getConnection();
	}
	
	public List<AcademicDTO> getAllAlumni() throws SQLException
	{
		List<AcademicDTO> list = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myStmt = con.createStatement();
			myRs = myStmt.executeQuery("select * from alumni");
			
			while (myRs.next()) {
				AcademicDTO alum = convertRowToAlumni(myRs);
				list.add(alum);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
		//return list;
	
	}
	
	private AcademicDTO convertRowToAlumni(ResultSet myRs) throws SQLException {
		
		String rollno = myRs.getString("rollno");
		String loginname = myRs.getString("loginname");
		String gender = myRs.getString("gender");
		String email = myRs.getString("email");
		long phoneno = myRs.getLong("phoneno");
		int yearofjoin = myRs.getInt("yearofjoin");
		int yearofpass = myRs.getInt("yearofpass");
		String profession = myRs.getString("profession");
		String pass = myRs.getString("pass");
		
		AcademicDTO alum = new AcademicDTO(rollno,loginname,gender,email,phoneno,yearofjoin,yearofpass,profession,pass);
		
		return alum;
	}
	
	public List<AcademicDTO> searchAlumni(String lastName) throws Exception {
		List<AcademicDTO> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			lastName += "%";
			myStmt = con.prepareStatement("select * from alumni where loginname like ?");
			
			myStmt.setString(1, lastName);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				AcademicDTO alum = convertRowToAlumni(myRs);
				list.add(alum);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	//Registering acadamic details
	public boolean registerAcadamicDetails(AcademicDTO adto)
	{
		Statement st;
		boolean flag = false;
		
		try {
              String loginname=adto.getLoginname();
              int yearofpass=adto.getYearofpass();
              int yearofjoin=adto.getYearofjoin();
              String profession=adto.getProfession();
              String rollno=adto.getRollno();
              String gender = adto.getGender();
              
              PreparedStatement pst = con.prepareStatement("insert into alumni(loginname,yearofpass,yearofjoin,profession,rollno,gender) values(?,?,?,?,?,?)");
              
              pst.setString(1, loginname);
              pst.setInt(2, yearofpass);
              pst.setInt(3, yearofjoin);
              pst.setString(4,profession);
              pst.setString(5, rollno);
              pst.setString(6,gender);
              
              int i=pst.executeUpdate();
              //System.out.println("Hello");
              
              if(i!=0)
              {
            	      st=con.createStatement();
                      st.executeUpdate("update alumni set firstlogin=1 where loginname='"+loginname+"'");
                      flag=true; 
           	  
              }
              else
            	  flag=false;
              
              
		} catch (SQLException e) {
			flag=false;
			LoggerManager.writeLogSevere(e);
		}
		return flag;
	}
	
	//checking acadamic details
	public boolean checkAcadamicDetails(String loginname,String pass)
	{
		Statement st;
		boolean flag = false;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select loginname,pass from alumni where loginname='"+loginname+"'");
			if(rs.next())
			{
				
				if(rs.getString(1).contentEquals(loginname) && rs.getString(2).contentEquals(pass))
					flag = true;
			}
				
		} catch (SQLException e) {
			LoggerManager.writeLogSevere(e);
		}
		return flag;
	}
	
	//get Acadamic details
	
	public AcademicDTO getAcademicDetails(String loginname)
	{
		AcademicDTO acdto=null;
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select yearofpass,yearofjoin,profession,rollno,gender,email,phoneno,pass from alumni where loginname='"+loginname+"'");
			if(rs.next())
			{
				acdto = new AcademicDTO();
			    acdto.setYearofpass(rs.getInt(1));
			    acdto.setYearofjoin(rs.getInt(2));
			    acdto.setProfession(rs.getString(3));
			    acdto.setRollno(rs.getString(4));
			    acdto.setGender(rs.getString(5));
			    acdto.setEmail(rs.getString(6));
			    acdto.setPhone(rs.getLong(7));
			    acdto.setPass(rs.getString(8));
			    acdto.setLoginname(loginname);
			}
		}
		catch(SQLException sex)
		{
			LoggerManager.writeLogSevere(sex);
		}
		return acdto;
	}
	
	//Updating acadamic details
	public boolean updateAcadamicDetails(AcademicDTO adto)
	{
		@SuppressWarnings("unused")
		Statement st;
		boolean flag = false;
		
		try {
              String loginname=adto.getLoginname();
              int yearofpass=adto.getYearofpass();
              int yearofjoin=adto.getYearofjoin();
              String profession=adto.getProfession();
              String rollno=adto.getRollno();
              String gender = adto.getGender();
              String email = adto.getEmail();
              
              PreparedStatement pst = con.prepareStatement("update alumni set yearofpass=?,yearofjoin=?,profession=?,rollno=?,gender=?,email=? where loginname=?");
              
              pst.setInt(1, yearofpass);
              pst.setInt(2, yearofjoin);
              pst.setString(3,profession);
              pst.setString(4, rollno);
              pst.setString(5,gender);
              pst.setString(6, loginname);
              pst.setString(7,email);
              
              int i=pst.executeUpdate();
              System.out.println("-------"+loginname);
              if(i!=0)
              {
            	  flag = true;
              }
		}
		catch(Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return flag;
	}
	
	public static void main(String[] args) throws Exception
	{
		AcadamicDAO ob = new AcadamicDAO();
		System.out.println(ob.searchAlumni("Meenu"));
		System.out.println(ob.getAllAlumni());
	}
}
