package smsServer.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientServlet extends HttpServlet {
@Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //getting data from the browser
        String phonenumber=request.getParameter("phoneNumber");

        PrintWriter out=response.getWriter();
        response.setContentType("text/html");

    // send HTML text to browser
    out.print("<html><body>");
    out.print("<h2>"+phonenumber+"");
    out.print("</body></html>");
    }

}
