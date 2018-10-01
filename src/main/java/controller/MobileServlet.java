package controller;

import pojo.Mobile;
import repository.mobile.MobileDao;
import repository.mobile.MobileDaoImpl;
import service.MobileService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MobileServlet extends HttpServlet {
    private MobileService mobileService;

    @Override
    public void init() throws ServletException {
        super.init();
        mobileService = new MobileService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Mobile> mobiles = mobileService.getAllWithManufacturers(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("mobiles", mobiles);
        req.getRequestDispatcher("/mobiles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
