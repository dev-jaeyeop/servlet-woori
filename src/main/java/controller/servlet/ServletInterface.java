package controller.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletInterface {
    String process(HttpServletRequest request, HttpServletResponse response);
}
