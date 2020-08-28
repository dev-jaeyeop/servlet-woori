package controller.admin;

import model.dao.BandDAO;
import model.dao.CategoryDAO;
import model.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminDelete {
    public String process(HttpServletRequest request, HttpServletResponse response) {
        switch (request.getParameter("type")) {
            case "user":
                new UserDAO().deleteUser(request.getParameter("id"));
                break;
            case "band":
                new BandDAO().deleteBand(request.getParameter("id"));
                break;
            case "category":
                new CategoryDAO().deleteCategory(request.getParameter("id"));
                break;
        }

        return "/admin";
    }
}
