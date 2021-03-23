package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 커뮤니티 게시판 게시글을 작성하는 클래스입니다.
 * 
 * @author 노푸른
 *
 */
@WebServlet("/Myhome/user/boardcommunitywrite.do")
public class BoardCommunityWrite extends HttpServlet {

	/**
	 * 클라이언트 웹브라우저에 DB결과를 전달하는 메소드입니다.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 로그인 연동 완료되면 수정하기*****
		if (session.getAttribute("name") == null) {

			PrintWriter writer = response.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('로그인이 필요합니다.');");
			writer.print("location.href='/Myhome_project/Myhome/user/boardcommunitylist.do';");
			writer.print("</script>");
			writer.print("</body></html>");

			writer.close();

			return;

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/board-community-write.jsp");
		dispatcher.forward(request, response);

	}
}
