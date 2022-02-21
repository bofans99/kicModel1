package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Board;
import util.JdbcConnection;

public class BoardDao {

	public int insertBoard(Board board) {
			Connection con= JdbcConnection.getConnection();
			PreparedStatement pstmt = null;
			String sql = "insert into board" 
					+ " values (boardseq.nextval,?,?,?,?,?,?,sysdate,?,0,?,?,?)";
			//column name을 생략하면 create table column 순으로 입력한다
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getWriter());
				pstmt.setString(2, board.getPass());
				pstmt.setString(3, board.getSubject());
				pstmt.setString(4, board.getContent());
				pstmt.setString(5, board.getFile1());
				pstmt.setString(6, board.getBoardid());
				pstmt.setString(7, board.getIp());
				pstmt.setInt(8, board.getRef());
				pstmt.setInt(9, board.getReflevel1()); 
				pstmt.setInt(10, board.getRefstep());
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcConnection.close(con, pstmt, null);	
			}
		return 0;
	}
	
	public int boardCount(String boardid) {
		Connection con= JdbcConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "select count(*) from board where boardid= ?";
		ResultSet rs= null;
		//column name을 생략하면 create table column 순으로 입력한다
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardid);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(con, pstmt, rs);	
		}
	return 0;
	}
	
	
	public List<Board> boardList(int pageInt, int limit, int boardcount, String boardid) {
		Connection con= JdbcConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from(" + "select rownum rnum, a.* from("+"select * from board where boardid = ? "+
				"order by num desc) a)" + "where rnum BETWEEN ? and ?";
		
		
		ResultSet rs= null;
		
		List<Board> list = new ArrayList<>(); 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardid);
			pstmt.setInt(2, (pageInt-1)*limit+1);
			pstmt.setInt(3, pageInt*limit); //(pageInt-1)*limit+1 +limit-1
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setNum(rs.getInt("num"));
				b.setWriter(rs.getString("writer"));
				b.setPass(rs.getString("pass"));
				b.setSubject(rs.getString("subject"));
				b.setContent(rs.getString("content"));
				b.setFile1(rs.getString("file1"));
				b.setRef(rs.getInt("ref"));
				b.setRefstep(rs.getInt("refstep"));
				b.setReflevel1(rs.getInt("reflevel1"));
				b.setReadcnt(rs.getInt("readcnt"));
				b.setRegdate(rs.getDate("regdate"));
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(con, pstmt, rs);	
		}
	return list;
	}
	
	public Board boardOne(int num) {
		Connection con= JdbcConnection.getConnection();
		PreparedStatement pstmt = null; 
		String sql = "select * from board where num = ?"; 
		ResultSet rs = null; //column name을 생략하면 create table column 순으로 입력한다. 
		try {		
			pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, num); 
			rs = pstmt.executeQuery(); 
			while (rs.next()) {
				Board b = new Board(); 
				b.setNum(rs.getInt("num")); 
				b.setWriter(rs.getString("writer"));
				b.setPass(rs.getString("pass")); 
				b.setSubject(rs.getString("subject")); 
				b.setContent(rs.getString("content")); 
				b.setFile1(rs.getString("file1")); 
				b.setRef(rs.getInt("ref")); 
				b.setRefstep(rs.getInt("refstep")); 
				b.setReflevel1(rs.getInt("reflevel1")); 
				b.setReadcnt(rs.getInt("readcnt")); 
				b.setRegdate(rs.getDate("regdate")); 
				return b;
				}
			}catch (SQLException e) {
				e.printStackTrace(); 
			} finally {
				JdbcConnection.close(con, pstmt, rs);
			}
				return null;
	}

}

	
	

