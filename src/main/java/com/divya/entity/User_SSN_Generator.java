package com.divya.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class User_SSN_Generator implements IdentifierGenerator {
	
	
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		Integer seqval1=null;
		Integer seqval2=null;
		Integer seqval3=null;
		Connection con=null;
		con=session.connection();
		try {
			Statement st=con.createStatement();
			Statement st1=con.createStatement();
			Statement st2=con.createStatement();
			ResultSet rs=st.executeQuery("select USER_SEQ.NEXTVAL from DUAL");
			if(rs.next()) {
				seqval1=rs.getInt(1);
			}
			ResultSet rs1=st1.executeQuery("select USER_SEQ1.NEXTVAL from DUAL");
			if(rs1.next()) {
				seqval2=rs1.getInt(1);
			}
			ResultSet rs2=st2.executeQuery("select USER_SEQ2.NEXTVAL from DUAL");
			if(rs2.next()) {
				seqval3=rs2.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String ssn=seqval1+"-"+seqval2+"-"+seqval3;
		return ssn;
	}

}
