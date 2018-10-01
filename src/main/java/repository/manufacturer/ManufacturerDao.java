package repository.manufacturer;

import pojo.Manufacturer;

import java.util.List;

public interface ManufacturerDao {

    boolean add(Manufacturer manufacture);

    Manufacturer getById(Integer id);

    boolean update(Manufacturer mobile);

    boolean deleteById(Integer id);

    List<Manufacturer> getAll();
}
