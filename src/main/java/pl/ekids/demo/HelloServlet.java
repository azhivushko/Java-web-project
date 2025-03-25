package pl.ekids.demo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
// хотим получить "hello-servlet"
// пишем запрос - GET "hello-servlet"
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    //обязательный синтаксис - doGet(HttpServletRequest request, HttpServletResponse response)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    } // -> отправиться объект HttpServletResponse к которому мы обращались по имени response

    public void destroy() {
    }
}