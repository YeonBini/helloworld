package com.sds.comLocal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sds.comLocal.dto.BDto;

public class BDao {
	
//    private DataSource ds;
    
	public ArrayList<BDto> list() {
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:beans.xml");
		DataSource ds = context.getBean("dataSource", org.springframework.jdbc.datasource.DriverManagerDataSource.class);
		
		ArrayList<BDto> dto = new ArrayList<BDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select bid, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent"
				+ " from mvc_board order by bGroup desc";
		
		try {
            conn = ds.getConnection();
			System.out.println("\n >>>>>>>>>> Connection 출력 : " + conn + "\n");
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				int bid = rset.getInt("bid");
				String bName = rset.getString("bName");
				String bTitle = rset.getString("bTitle");
				String bContent = rset.getString("bContent");
				Timestamp bDate = rset.getTimestamp("bDate");
				int bHit = rset.getInt("bHit");
				int bGroup = rset.getInt("bGroup");
				int bStep= rset.getInt("bStep");
				int bIndent = rset.getInt("bIndent");
				
				BDto bDto = new BDto(bid, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dto.add(bDto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		
		return dto;
	}

    
    
	
}
