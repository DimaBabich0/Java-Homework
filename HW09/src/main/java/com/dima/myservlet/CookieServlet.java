package com.dima.myservlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int COOKIE_MAX_AGE = 1 * 60;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String theme = "light"; // значение по умолчанию
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("theme".equals(c.getName())) {
                    theme = c.getValue();
                    break;
                }
            }
        }
        String json = String.format("{\"theme\": \"%s\"}", theme);
        response.getWriter().write(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String theme = request.getParameter("theme");
        if (theme != null && !theme.trim().isEmpty()) {
            Cookie cookie = new Cookie("theme", theme);
            cookie.setPath("/");
            cookie.setMaxAge(COOKIE_MAX_AGE);
            response.addCookie(cookie);
        }
        response.getWriter().write("{\"status\": \"ok\"}");
	}
}
