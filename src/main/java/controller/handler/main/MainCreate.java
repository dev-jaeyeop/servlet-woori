package controller.handler.main;

import controller.handler.ServletHandler;
import dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCreate implements ServletHandler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        new UserDAO().createUser(
                request.getParameter("account"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("phoneNumber"),
                request.getParameter("location")
        );

        return "/";
    }
}
