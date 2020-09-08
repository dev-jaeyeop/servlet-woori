package service.main;

import dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainCheckAccount {
    String message;

    public void process(HttpServletRequest request, HttpServletResponse response) {
        if (new UserDAO().existAccount(request.getParameter("joinAccount"))) {
            message = "사용 불가";
        } else {
            message = "사용 가능";
        }

        try {
            response.getWriter().write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
