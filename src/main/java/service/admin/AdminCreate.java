package service.admin;

import dao.BoardDAO;
import dao.CategoryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminCreate {

    public String process(HttpServletRequest request, HttpServletResponse response) {
        switch (request.getParameter("type")) {
            case "category":
                new CategoryDAO().createCategory(
                        request.getParameter("name"),
                        request.getParameter("icon"),
//                        request.getParameter("createdBy")
                        "test"
                );
                break;
            case "board":
                break;
        }

        return "/admin";
    }
}
