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
 * 커뮤니티 게시판 게시글을 수정하는 클래스입니다.
 * @author 노푸른
 *
 */
@WebServlet("/Myhome/user/boardcommunityedit.do")
public class BoardCommunityEdit extends HttpServlet {

	/**
	 * 클라이언트 웹브라우저에 DB결과를 전달하는 메소드입니다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		BoardCommunityDAO dao = new BoardCommunityDAO();
		BoardCommunityDTO dto = dao.get(seq);

		HttpSession session = req.getSession();

		// if (dto.getSeqAllUser() !=
		// String.valueOf(session.getAttribute("seqAllUser"))) {
		if (!dto.getSeqAllUser().equals(String.valueOf(session.getAttribute("seqAllUser")))) {
			// 권한 없음 -> 쫓아내기
			PrintWriter writer = resp.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");

			writer.close();

			return;// *** 쫓아내고 메소드 쫑내기
		}

		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/board-community-edit.jsp");
		dispatcher.forward(req, resp);

	}

}
