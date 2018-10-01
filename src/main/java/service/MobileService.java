package service;


import pojo.Mobile;
import repository.mobile.MobileDao;
import repository.mobile.MobileDaoImpl;

import java.util.List;

public class MobileService {
    private MobileDao mobileDao = new MobileDaoImpl();

    public List<Mobile> getAllWithManufacturers(Integer manufacutrerId) {
        return mobileDao.getAllWithManufacturers(manufacutrerId);
    }

}
