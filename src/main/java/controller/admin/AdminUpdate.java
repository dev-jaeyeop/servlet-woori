package controller.admin;

import model.dao.BandDAO;
import model.dao.CategoryDAO;
import model.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminUpdate {
    public String process(HttpServletRequest request, HttpServletResponse response) {
        switch (request.getParameter("type")) {
            case "user":
                new UserDAO().updateUser(
                        request.getParameter("id"),
                        request.getParameter("role"),
                        request.getParameter("password"),
                        request.getParameter("name"),
                        request.getParameter("email"),
                        request.getParameter("phoneNumber"),
                        request.getParameter("updatedBy")
                );
                break;
            case "band":
                new BandDAO().updateBand(
                        request.getParameter("id"),
                        request.getParameter("name"),
                        request.getParameter("location"),
                        request.getParameter("capacity"),
                        request.getParameter("updatedBy")
                );
                break;
            case "category":
                new CategoryDAO().updateCategory(
                        request.getParameter("id"),
                        request.getParameter("name")
                );
                break;
        }

        return "/admin";
    }
}
