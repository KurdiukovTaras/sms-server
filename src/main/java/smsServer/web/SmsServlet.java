package smsServer.web;

import smsServer.model.SmsUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SmsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //чтение параметры action, если ноль - показать все смс
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("smsList", SmsUtil.SMS_LIST);
            request.getRequestDispatcher("smsList.jsp").forward(request, response);
        }
        else if(action == "showsms"){
            int id = getId(request);

        }
    }
    //чтоб не повторяться, чтение параметра id из request
    private int getId(HttpServletRequest request) {
        String paramId = request.getParameter("id");
        return Integer.valueOf(paramId);
    }
}
