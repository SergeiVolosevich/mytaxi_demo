package by.mytaxi.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

@WebServlet("/timeaction")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String time = req.getParameter("time");
        GregorianCalendar calendar = new GregorianCalendar();
        long end= calendar.getTimeInMillis();
        long start = Long.parseLong(time);
        double result =((double)(end - start))/1_000;
        req.setAttribute("result",result);
        req.getRequestDispatcher("/pages/result.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String time = req.getParameter("time");
        GregorianCalendar calendar = new GregorianCalendar();
        long end= calendar.getTimeInMillis();
        long start = Long.parseLong(time);
        double result =((double)(end - start))/1_000;
        req.setAttribute("result",result);
        req.getRequestDispatcher("/pages/result.jsp").forward(req,resp);
        req.getRemoteAddr();
    }
}
