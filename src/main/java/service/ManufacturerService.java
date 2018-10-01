package service;

import pojo.Manufacturer;
import repository.manufacturer.ManufacturerDao;
import repository.manufacturer.ManufacturerDaoImpl;

import java.util.List;

public class ManufacturerService {
    private ManufacturerDao manufacturerDao;

    public ManufacturerService() {
        manufacturerDao = new ManufacturerDaoImpl();
    }

    public ManufacturerService(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }
}
