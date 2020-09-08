package controller.servlet;

import service.main.MainCheckAccount;
import service.main.MainCreate;
import service.main.MainRead;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Main", urlPatterns = "/main/*")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) {
        try {
            switch (request.getRequestURI()) {
                case "/main":
                    response.sendRedirect("/WEB-INF/view/main/main.jsp");
                    break;
                case "/main/login":
                    response.sendRedirect(new MainRead().process(request, response));
                    break;
                case "/main/join":
                    response.sendRedirect(new MainCreate().process(request, response));
                    break;
                case "/main/checkAccount":
                    new MainCheckAccount().process(request, response);
                    break;
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
