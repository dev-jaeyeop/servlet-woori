package controller.servlet;

import service.admin.AdminCreate;
import service.admin.AdminDelete;
import service.admin.AdminRead;
import service.admin.AdminUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Admin", urlPatterns = "/admin/*")
public class Admin extends HttpServlet {
    AdminCreate adminCreate = new AdminCreate();
    AdminRead adminRead = new AdminRead();
    AdminUpdate adminUpdate = new AdminUpdate();
    AdminDelete adminDelete = new AdminDelete();

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
                    request.getRequestDispatcher(adminRead.process(request, response)).forward(request, response);
                    break;
                case "/admin/create":
                    response.sendRedirect(adminCreate.process(request, response));
                    break;
                case "/admin/update":
                    response.sendRedirect(adminUpdate.process(request, response));
                    break;
                case "/admin/delete":
                    response.sendRedirect(adminDelete.process(request, response));
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
