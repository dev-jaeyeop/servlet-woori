package service.admin;

import dao.BandDAO;
import dao.BoardDAO;
import dao.CategoryDAO;
import dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminRead {

    public String process(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", new UserDAO().selectUserAll());
        request.setAttribute("bands", new BandDAO().selectBandAll());
        request.setAttribute("categories", new CategoryDAO().selectCategoryAll());
        request.setAttribute("boards", new BoardDAO().selectBoardAll());

        return "/WEB-INF/view/admin/admin.jsp";
    }
}
