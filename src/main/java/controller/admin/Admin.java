package controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Admin", urlPatterns = "/")
public class Admin extends HttpServlet {
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
                case "/update":
                    response.sendRedirect(new AdminUpdate().process(request, response));
                    break;
                case "/delete":
                    response.sendRedirect(new AdminDelete().process(request, response));
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
