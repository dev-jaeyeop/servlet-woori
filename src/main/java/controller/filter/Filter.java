package controller.filter;

import model.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter", urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Object loginUser = ((HttpServletRequest) request).getSession().getAttribute("loginUser");
        if (loginUser == null) {
            ((HttpServletResponse) response).sendRedirect("/");
        } else {
            switch (((User) loginUser).getRole()) {
                case "admin":
                    ((HttpServletResponse) response).sendRedirect("/admin");
                    break;
                case "user":
                    chain.doFilter(request, response);
                    break;
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
