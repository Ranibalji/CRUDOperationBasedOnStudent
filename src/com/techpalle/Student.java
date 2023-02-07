package com.techpalle;
import java.sql.*;

public class Student 
{	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs = null;
	
	private static final String url= "jdbc:mysql://localhost:3306/palle";
	private static final String username= "root";
	private static final String password = "admin";
	
	
public void creating()
{
	try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
			s=con.createStatement();
			
			
		    s.executeUpdate("create table student(sno int primary key auto_increment, "
				+ "sname varchar(50), sub varchar(40), email varchar(50))");		    
		    
		} 
		catch (ClassNotFoundException e) 
		{			
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(s!=null)
			{
				try 
				{
					s.close();
				} 
				catch (SQLException e)
				{
					
					e.printStackTrace();
				}
			}
		
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void inserting(String sname, String sub, String email) 
	{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);				
				ps = con.prepareStatement("insert into student(sname, sub, email) values(?,?,?)");
				
				ps.setString(1, sname);
				ps.setString(2, sub);                                                                                                          
				ps.setString(3, email);
				
				ps.executeUpdate();
				
			}
			catch (ClassNotFoundException e)
			{
				
				e.printStackTrace();
			}
			
		   catch (SQLException e)
			{
				
				e.printStackTrace();
			}
			
			finally
			{
				if(ps!=null)
				{
					try 
					{
						ps.close();
					}
					catch (SQLException e)
					{
						
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try 
					{
						con.close();
					}
					catch (SQLException e)
					{
						
						e.printStackTrace();
					}
				 }	
			 }		
	     }
	
	
	public void updating(int sno,String sname, String sub, String email) 
	{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				ps = con.prepareStatement("update student set sname=?, sub=?, email=? where sno=?");
				
				ps.setString(1, sname);
				ps.setString(2, sub);
				ps.setString(3, email);
				ps.setInt(4, sno);
				
				ps.executeUpdate();
			} 
			catch (ClassNotFoundException e) 
			{
				
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
			
			finally
			{
				if(ps!=null)
				{
					try 
					{
						ps.close();
					}
					catch (SQLException e)
					{
						
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try 
					{
						con.close();
					}
					catch (SQLException e)
					{
						
						e.printStackTrace();
					}
				}
			}
	}
	
	public void delete(int sno) 
	{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				ps = con.prepareStatement("delete from student where sno=?");
				
				ps.setInt(1, sno);
				
				ps.executeUpdate();
			} 
			catch (ClassNotFoundException e) 
			{			
				e.printStackTrace();
			}
	
			catch (SQLException e) {
				
				e.printStackTrace();
			}

			finally
			{
				if(ps!=null)
				{
					try 
					{
						ps.close();
					}
					catch (SQLException e)
					{
						
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try 
					{
						con.close();
					}
					catch (SQLException e)
					{
						
						e.printStackTrace();
					}
				}
			}			
	}
	
	public void read()
	{

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			s=con.createStatement();
			
            rs = s.executeQuery("select * from student");
            while(rs.next())
            {
            	System.out.println("sno ="+rs.getInt("sno"));
            	System.out.println("sname ="+rs.getString("sname"));
            	System.out.println("sub ="+rs.getString("sub"));
            	System.out.println("email ="+rs.getString("email"));
            }
			
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
			
		catch (SQLException e) 
		{
			
				e.printStackTrace();
		}
			
		finally
		{
			if(rs!=null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(s!=null)
			{
				try 
				{
					s.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		 }
	   }	
    }





