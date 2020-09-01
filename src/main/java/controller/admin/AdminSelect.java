package controller.admin;

import controller.servlet.ServletInterface;
import dao.BandDAO;
import dao.CategoryDAO;
import dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminSelect implements ServletInterface {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", new UserDAO().selectUserAll());
        request.setAttribute("bands", new BandDAO().selectBandAll());
        request.setAttribute("categories", new CategoryDAO().selectCategoryAll());

        return "WEB-INF/view/admin/admin.jsp";
    }
}
