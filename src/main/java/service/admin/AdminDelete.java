package service.admin;

import dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminDelete  {

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
            case "board":
                new ReplyDAO().deleteReplyByBoardId(request.getParameter("id"));
                new BoardDAO().deleteBoardById(request.getParameter("id"));
                break;
        }

        return "/admin";
    }
}
