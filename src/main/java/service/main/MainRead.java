package service.main;

import dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainRead {

    public String process(HttpServletRequest request, HttpServletResponse response) {
        UserDAO userDAO = new UserDAO();
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if (userDAO.existUser(account, password)) {
            switch (userDAO.selectUserByAccount(account).getRole()) {
                case "admin":
                    request.getSession().setAttribute("loginUser", userDAO.selectUserByAccount(account));
                    return "/admin";
                case "user":
                    request.getSession().setAttribute("loginUser", userDAO.selectUserByAccount(account));
                    return "/user";
            }
        }
        return "/main";
    }
}
