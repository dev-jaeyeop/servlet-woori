package service.main;

import dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCreate   {

    public String process(HttpServletRequest request, HttpServletResponse response) {
        new UserDAO().createUser(
                request.getParameter("joinAccount"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("phoneNumber"),
                request.getParameter("location")
        );

        return "/";
    }
}
