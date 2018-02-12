package by.itacademy.dao;

import by.itacademy.entity.VehicleCategory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VehicleCategoryDao extends BaseDao<VehicleCategory> {

    public VehicleCategoryDao() {
        super(VehicleCategory.class);
    }

}
