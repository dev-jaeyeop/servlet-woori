package controller;

import controller.admin.AdminCreate;
import controller.admin.AdminDelete;
import controller.admin.AdminSelect;
import controller.admin.AdminUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) {
        try {
            switch (request.getRequestURI()) {
                case "/admin":
                    request.getRequestDispatcher(new AdminSelect().process(request, response)).forward(request, response);
                    break;
                case "/admin/create":
                    response.sendRedirect(new AdminCreate().process(request, response));
                    break;
                case "/admin/update":
                    response.sendRedirect(new AdminUpdate().process(request, response));
                    break;
                case "/admin/delete":
                    response.sendRedirect(new AdminDelete().process(request, response));
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
