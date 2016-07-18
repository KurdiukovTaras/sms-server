package smsServer.web;

import smsServer.model.Sms;
import smsServer.model.SmsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SmsServlet extends HttpServlet {
    int clientId;
    private SmsUtil repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        repository=new SmsUtil();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("writesms")) {
            String message=request.getParameter("message");
            repository.addSms(message,clientId);
            request.getRequestDispatcher("writeSms.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //чтение параметры action, если ноль - показать все смс
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("smsList", repository.getAll(repository.SMS_LIST));
            request.getRequestDispatcher("smsList.jsp").forward(request, response);
        }
        else if(action.equals("showsmsbyid")){
            int id = getId(request);
            clientId=id;
            request.setAttribute("smsList", repository.getById(repository.SMS_LIST,id));
            request.getRequestDispatcher("smsList.jsp").forward(request, response);
        }
    }
    //чтоб не повторяться, чтение параметра id из request
    private int getId(HttpServletRequest request) {
        String paramId = request.getParameter("id");
        return Integer.valueOf(paramId);
    }
}
