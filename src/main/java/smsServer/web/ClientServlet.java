package smsServer.web;

import smsServer.model.SmsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clientList", SmsUtil.CLIENT_LIST);
        request.getRequestDispatcher("clientList.jsp").forward(request,response);
    }

}
