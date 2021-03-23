package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
*/

/**
 * Q&A 게시판 게시글 등록을 DB에 요청하는 클래스입니다.
 * @author 노푸른
 *
 */
@WebServlet("/Myhome/user/boardqnawriteok.do")
public class BoardQnAWriteOk extends HttpServlet {

	/**
	 * 클라이언트 웹브라우저에 DB결과를 전달하는 메소드입니다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		// 1.
		req.setCharacterEncoding("UTF-8");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String seqAllUser = String.valueOf(session.getAttribute("seqAllUser"));
		String seqQnAType  = req.getParameter("seqQnAType");
			

		// 2.
		BoardQnADAO dao = new BoardQnADAO();
		BoardQnADTO dto = new BoardQnADTO();

		dto.setTitle(title);
		dto.setContent(content);
//		dto.setSeqUser(seqUser);
		// 수정하기**
		dto.setSeqAllUser(seqAllUser);
		dto.setSeqQnAType(seqQnAType);
		
		
		int result = dao.write(dto);

		
		if (result == 1) {
			resp.sendRedirect("/Myhome_project/Myhome/user/boardqnalist.do");
		} else {
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