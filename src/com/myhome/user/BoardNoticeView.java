package com.myhome.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 공지사항 게시판 게시글 상세페이지를 출력하는 클래스입니다.
 * 
 * @author 노푸른
 *
 */
@WebServlet("/Myhome/user/boardnoticeview.do")
public class BoardNoticeView extends HttpServlet {

	/**
	 * get 방식으로 게시글을 호출하는 메소드입니다.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String seq = request.getParameter("seq"); // 오류나면 여기 수정하기*****
		String search = request.getParameter("search"); // 검색어
		String page = request.getParameter("page");

		BoardNoticeDAO dao = new BoardNoticeDAO();

		if (session.getAttribute("read") == null || (boolean) session.getAttribute("read") == false) {

			dao.updateViewCount(seq);
			session.setAttribute("read", true);
		}

		BoardNoticeDTO dto = dao.get(seq);

		dao.close();
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));

		request.setAttribute("dto", dto);
		request.setAttribute("search", search);
		request.setAttribute("page", page);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/board-notice-view.jsp");
		dispatcher.forward(request, response);

	}

}
