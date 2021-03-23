package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 커뮤니티 게시판 댓글 삭제를 DB에 요청하는 클래스입니다.
 * @author 노푸른
 *
 */
@WebServlet("/Myhome/user/commentcommunitydeleteok.do")
public class CommentCommunityDeleteOk extends HttpServlet {
	
	/**
	 * 클라이언트 웹브라우저에 DB결과를 전달하는 메소드입니다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq"); //삭제 댓글 번호
		String seqCommunity = req.getParameter("seqCommunity");
		
		BoardCommunityDAO dao = new BoardCommunityDAO();
		int result = dao.deleteComment(seq);
		
		if (result == 1) {
			//댓글쓰기 성공 -> 뷰로 돌아와야 함
			resp.sendRedirect("/Myhome_project/Myhome/user/boardcommunityview.do?seq=" + seqCommunity); //현재 보고 있는 게시글 번호(bseq)
			
		} else {
			//글쓰기 실패 -> 경고 + 뒤로 가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}
	}

}
