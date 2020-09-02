package controller.handler.admin;

import controller.handler.ServletHandler;
import dao.CategoryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminCreate implements ServletHandler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        switch (request.getParameter("type")) {
            case "category":
                new CategoryDAO().createCategory(
                        request.getParameter("name"),
                        request.getParameter("icon"),
                        request.getParameter("createdBy")
                );
                break;
        }

        return "/admin";
    }
}
