package com.company;

import java.util.List;

public class MobilePhoneManager implements ProductService<MobilePhone> {
    @Override
    public boolean create(MobilePhone entity) {
        return InMemoryDB.mobilePhones.add(entity);
    }

    @Override
    public List<MobilePhone> getAll() {
        return InMemoryDB.mobilePhones;
    }

    @Override
    public MobilePhone getById(int id) {
        MobilePhone mobilePhone = null;
        for (MobilePhone x :
                InMemoryDB.mobilePhones) {
            if (x.getId() == id) {
                mobilePhone = x;
                break;
            }
        }
        return mobilePhone;
    }

    @Override
    public boolean delete(int id) {
        var mobilePhone = getById(id);
        return InMemoryDB.mobilePhones.remove(mobilePhone);
    }
}
