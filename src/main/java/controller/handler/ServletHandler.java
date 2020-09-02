package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletHandler {
    String process(HttpServletRequest request, HttpServletResponse response);
}
