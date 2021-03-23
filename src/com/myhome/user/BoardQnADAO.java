package com.myhome.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/**
 * Q&A 게시판 DB작업을 요청하는 클래스입니다.
 * @author 노푸른
 *
 */
public class BoardQnADAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement ct;
	
	/**
	 * DB 연결하는 메소드입니다.
	 */
	public BoardQnADAO() {
		conn = DBUtil.open();
	}
	
	/**
	 * DB 연결을 해제하는 메소드입니다.
	 */
	public void close() {
		
		try {
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("BoardQnADAO.close()");
			e.printStackTrace();
		}
	}
	
	/**
	 * 게시글 목록을 배열에 넣습니다.
	 * @param map 게시글 검색어 등을 담은 배열입니다.
	 * @return Q&A 게시판 게시글 목록을 반환합니다.
	 */
	public ArrayList<BoardQnADTO> list(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if (map.get("search") != null) {
				
				//관리자가 쓴 글이라 제목과 내용에 포함되는 것만 검색되도록 설정했음
				
				where = String.format("where title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"));
			}
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwQnAUserVer %s order by seqQnA desc) a) where rnum between %s and %s", where, map.get("begin"), map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BoardQnADTO> list = new ArrayList<BoardQnADTO>();
			
			while (rs.next()) {
				
				BoardQnADTO dto = new BoardQnADTO();
				
				dto.setSeqQnA(rs.getString("seqQnA"));
				dto.setTitle(rs.getString("title"));
				dto.setNickName(rs.getString("nickName"));

				dto.setCategory(rs.getString("category"));
				dto.setState(rs.getString("state"));
				dto.setWriteDate(rs.getString("writeDate"));
				
				list.add(dto);
				
			}
			
			return list;	
			
		} catch (Exception e) {
			System.out.println("BoardQnADAO.list()");
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 게시글 목록보기에서 전체 페이지를 계산합니다.
	 * @param map 검색어 등을 담은 배열입니다.
	 * @return 전체 페이지 수를 반환합니다.
	 */
	public int getTotalCount(HashMap<String, String> map) {

		try {
			String where = "";
			
			if (map.get("search") != null) {
				where = String.format("where title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"));
			}
			
			String sql = String.format("select count(*) as cnt from tblQnA %s", where);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("BoardQnADAO.getTotalCount()");
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Q&A 게시판 게시글 하나를 출력합니다.
	 * @param seq 게시글 번호를 담은 변수입니다.
	 * @return 게시글 하나를 반환합니다.
	 */
	public BoardQnADTO get(String seq) {

		try {
			
			String sql = "select a.*, (select nickName from tblAllUser where seqAllUser = a.seqUser) as nickName from vwQnAUserVer a where seqQnA = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				BoardQnADTO dto = new BoardQnADTO();
				
				dto.setSeqQnA(rs.getString("seqQnA"));
				dto.setTitle(rs.getString("title"));
				dto.setNickName(rs.getString("nickName"));
				dto.setCategory(rs.getString("category"));

				dto.setContent(rs.getString("content"));
				dto.setState(rs.getString("state"));
				dto.setWriteDate(rs.getString("writeDate"));
				//dto.setGap(rs.getInt("gap"));
				
				dto.setId(rs.getString("id"));//관리자 ID
				dto.setSeqQnAComment(rs.getString("seqQnAComment"));				
				dto.setcContent(rs.getString("cContent"));
				dto.setcWriteDate(rs.getString("cWriteDate"));
				

				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println("BoardQnADAO.get()");
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 게시글을 작성합니다.
	 * @param dto 게시글 작성에 필요한 정보를 담고있는 객체입니다.
	 * @return 작성한 게시글을 목록에 추가합니다.
	 */
	public int write(BoardQnADTO dto) {
		//public int write(String  seqQnACategory, String  seqUser, String  title, String  content) {

		try {
			
			String sql = "insert into tblQnA (seqQnA, seqUser, seqQnAType, title, writeDate, content) values (seqQnA.nextVal, ?, ?, ?, sysdate, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqAllUser());
			pstat.setString(2, dto.getSeqQnAType());
			pstat.setString(3, dto.getTitle());
			pstat.setString(4, dto.getContent());
			
			return pstat.executeUpdate();
						
		} catch (Exception e) {
			System.out.println("BoardQnADAO.write()");
			e.printStackTrace();
			System.out.println("write : "+e );
		
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	
}
