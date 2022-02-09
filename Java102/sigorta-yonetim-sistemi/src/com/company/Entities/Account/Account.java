package com.company.Entities.Account;

import com.company.Entities.Account.Adress.Address;
import com.company.Entities.Account.Insurance.Insurance;
import com.company.Handles.CustomException.InvalidAuthenticationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {
    private User user;
    private List<Insurance> insurances = new ArrayList<>();
    private AuthenticationStatus authenticationStatus;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public final void showUserInfo() {
        System.out.println("User bilgileri :");
        System.out.println("First Name : " + user.getFirstName() + "\n" +
                "Last Name : " + user.getLastName() + "\n" +
                "Email : " + user.getEmail() + "\n" +
                "Job : " + user.getJob() + "\n" +
                "Age : " + user.getAge() + "\n" +
                "Last Login Date : " + user.getLastLoginDate());
        for (Address address:
             user.getAdresses()) {
            System.out.println("Address : " + address.getAddress());
        }

    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }


    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    private void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public void loginUser(String email,String password) throws InvalidAuthenticationException {

        if(user.getEmail().equals(email) && user.getPassword().equals(password)){
            setAuthenticationStatus(AuthenticationStatus.SUCCESS);
            System.out.println("Login olundu");
        }else{
            setAuthenticationStatus(AuthenticationStatus.FAIL);
            throw new InvalidAuthenticationException("Email veya şifre hatalı");
        }

    }

    public void addAddress(Address address){
        var addressesList = this.user.getAdresses();
        addressesList.add(address);
        this.user.setAdresses(addressesList);
    }
    public void deleteAddress(Address address){
        var addressList = this.user.getAdresses();
        addressList.remove(address);
        this.user.setAdresses(addressList);
    }

    public abstract void addInsurance(Insurance insurance);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(user, account.user) && Objects.equals(insurances, account.insurances) && authenticationStatus == account.authenticationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, insurances, authenticationStatus);
    }
}
