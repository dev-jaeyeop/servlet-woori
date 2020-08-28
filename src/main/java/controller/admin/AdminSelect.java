package controller.admin;

import model.dao.BandDAO;
import model.dao.CategoryDAO;
import model.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminSelect {
    public String process(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", new UserDAO().selectUserAll());
        request.setAttribute("bands", new BandDAO().selectBandAll());
        request.setAttribute("categories", new CategoryDAO().selectCategoryAll());
        return "WEB-INF/view/admin/admin.jsp";
    }
}
