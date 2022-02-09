package com.company.Services;

import com.company.Entities.Account.Adress.Address;
import com.company.Entities.Account.User;

public class AddressManager {
    public static User add(User user, Address address){
        var addressesList = user.getAdresses();
        addressesList.add(address);
        user.setAdresses(addressesList);
        return user;
    }
    public static User delete(User user,Address address){
        var addressList = user.getAdresses();
        addressList.remove(address);
        user.setAdresses(addressList);
        return user;
    }
}
