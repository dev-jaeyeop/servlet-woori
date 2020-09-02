package controller.servlet;

import controller.handler.main.MainCreate;

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
                case "/main/login":
                    request.getRequestDispatcher("/WEB-INF/view/main/login.jsp").forward(request, response);
                    break;
                case "/main/join":
                    request.getRequestDispatcher("/WEB-INF/view/main/join.jsp").forward(request, response);
                    break;
                case "/main/join/checkAccount":
                    request.getRequestDispatcher("/WEB-INF/view/main/checkAccount.jsp").forward(request, response);
                    break;
                case "/main/join/process":
                    request.getRequestDispatcher(new MainCreate().process(request, response)).forward(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
