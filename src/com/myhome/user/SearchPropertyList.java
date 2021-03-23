package com.myhome.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * 방찾기(매물 목록 보기)를 출력하는 클래스입니다.
 * @author 노푸른
 *
 */
@WebServlet("/Myhome/user/searchpropertylist.do")
public class SearchPropertyList extends HttpServlet {
	
	/**
	 * 클라이언트 웹브라우저에 DB결과를 전달하는 메소드입니다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		SearchPropertyDAO dao = new SearchPropertyDAO();
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		String search = req.getParameter("search");
		//String[] search2 = req.getParameterValues("search2");
		
		String roomtypeopt = req.getParameter("roomtypeopt");
		String propertytypeopt = req.getParameter("propertytypeopt");
		//String maintenopt = req.getParameter("maintenopt");
		//String depositopt = req.getParameter("depositopt");
		String location = req.getParameter("location");
						
		if (!(search == null || search.equals(""))) {
			map.put("search", search);
		} 
//		if (!(roomtypeopt == null || roomtypeopt.equals(""))) {
//		map.put("roomtypeopt", roomtypeopt);
//	} else if (!(propertytypeopt == null || propertytypeopt.equals(""))) {
//		map.put("propertytypeopt", propertytypeopt);
//	} else if (!(maintenopt == null || maintenopt.equals(""))) {
//		map.put("maintenopt", maintenopt);
//	} else if (!(depositopt == null || depositopt.equals(""))) {
//		map.put("depositopt", depositopt);
//	} else if (!(location == null || location.equals(""))) {
//		map.put("location", location);
//	}

	
	if (!(roomtypeopt == null || roomtypeopt.equals("")) && !(propertytypeopt == null || propertytypeopt.equals("")) || !(location == null || location.equals(""))) {
		map.put("roomtypeopt", roomtypeopt);
		map.put("propertytypeopt", propertytypeopt);
		map.put("location", location);
	} 
		
						
						
		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 10;		//한페이지당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
						
						
		String page = req.getParameter("page");
						
		if (page == null || page == "") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
					

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize -1;
						
		//우리가만든 해쉬맵은 스트링이기 때문에 begin과 end도 문자열로 만들어서 넘기기.
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		ArrayList<SearchPropertyDTO> list = dao.contractorListUserVer(map);
		
		
		
		for (SearchPropertyDTO dto : list) {
			
			//제목 자르기
			if (dto.getTitle().length() > 30) {
				dto.setTitle(dto.getTitle().substring(0,30) + "...");
			}
		}
						
		totalCount = dao.getTotalCountContractor(map);
						
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
						
		String pagebar = "";
						
		loop = 1;
		n = ((nowPage -1) / blockSize) * blockSize +1;
						
						
		if ( n == 1 ) {
			pagebar += String.format("<li class='disabled'>"
									+ "            <a href=\"#!\" aria-label=\"Previous\">"
									+ "                <span aria-hidden=\"true\">&laquo;</span>"
									+ "            </a>"
									+ "        </li>");			
		} else {
			pagebar += String.format("<li>"
//					+ "            <a href=\"/Myhome_project/Myhome/user/searchpropertylist.do?page=%d\" aria-label=\"Previous\">"
					+ "            <a href=\"/Myhome_project/Myhome/user/searchpropertylist.do?page=%d&search=%s&location=%s&roomtypeopt=%s&propertytypeopt=%s\" aria-label=\"Previous\">"
									+ "                <span aria-hidden=\"true\">&laquo;</span>"
									+ "            </a>"
									+ "        </li>", n - 1, search, location, roomtypeopt, propertytypeopt);
							
		}
		
		
		
		
		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (nowPage == n) {
				pagebar += "<li class='active'>";				
			} else {
				pagebar += "<li>";								
			}
							
//			pagebar += String.format("<a href=\"/Myhome_project/Myhome/user/searchpropertylist.do?page=%d\">%d</a></li>", n, n);
			pagebar += String.format("<a href=\"/Myhome_project/Myhome/user/searchpropertylist.do?page=%d&search=%s&location=%s&roomtypeopt=%s&propertytypeopt=%s\">%d</a></li>", n, search, location, roomtypeopt, propertytypeopt ,n);
						
					loop++;
					n++;
		}

						
			//다음 10페이지로 이동
			if (n > totalPage) { //마지막에 끝난 n이 토탈페이지보다 크냐? 나의 경우엔 지금 n이 29냐? > 링크 안걸린 애를 만들기.
					//링크에 샵만 있으면 맨위로 올라가므로 #뒤에 ! 붙여주기.
				pagebar += String.format("<li class='disabled'>"
									+ "            <a href=\"#!\" aria-label=\"Next\">"
									+ "                <span aria-hidden=\"true\">&raquo;</span>"
									+ "            </a>"
									+ "        </li>");
							
			} else { //여전히 다음페이지가 존재하는 경우엔 링크 있는 애로 생성.			
				pagebar += String.format("<li>"
//						+ "            <a href=\"/Myhome_project/Myhome/user/searchpropertylist.do?page=%d\" aria-label=\"Next\">"
						+ "            <a href=\"/Myhome_project/Myhome/user/searchpropertylist.do?page=%d&search=%s&location=%s&roomtypeopt=%s&propertytypeopt=%s\" aria-label=\"Next\">"
									+ "                <span aria-hidden=\"true\">&raquo;</span>"
									+ "            </a>"
									+ "        </li>", n, search, location, roomtypeopt, propertytypeopt);
					//여기서 n은 위의 루프에서 10이 넘어가서 쫓겨난 애라 바로 다음애를 의미한다. 그래서 다음페이지의 첫번째 페이지의 이동하는 것!
			}
			
			
			
			
			//2.
			req.setAttribute("list", list);
			req.setAttribute("search", search);
			//req.setAttribute("search2", search2);
			req.setAttribute("pagebar", pagebar);
			req.setAttribute("nowPage", nowPage);
			
			req.setAttribute("roomtypeopt", roomtypeopt);
			req.setAttribute("propertytypeopt", propertytypeopt);
			//req.setAttribute("maintenopt", maintenopt);
			//req.setAttribute("depositopt", depositopt);
			req.setAttribute("location", location);
			//req.setAttribute("search2", search2);
		
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/search-property-list.jsp");
		dispatcher.forward(req, resp);
	}

}
