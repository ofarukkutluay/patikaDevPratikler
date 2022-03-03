package com.company.Database;

import com.company.Model.Bank;
import com.company.Model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class BankDb {
    JSONArray bankList;
    public BankDb() {
        this.bankList = getList();
    }

    public JSONArray getList(){
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("src/banks.json");
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Bank bank){
        JSONObject bankJson = new JSONObject();
        bankJson.put("UserId",bank.getUserId());
        bankJson.put("Credit",bank.getCredit());
        bankJson.put("CreditCard",bank.getCreditCard());
        bankJson.put("Safe",bank.getSafe());
        this.bankList.add(bankJson);

        try {
            FileWriter writer = new FileWriter("src/banks.json");
            writer.write(this.bankList.toJSONString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Bank getByUserId(long userId){
        Iterator<JSONObject> allData= this.bankList.iterator();
        Bank bank = new Bank();
        while(allData.hasNext()){
            JSONObject obj = allData.next();
            Long objId = (Long) obj.get("UserId");
            if(objId == userId){
                bank.setUserId(userId);
                bank.setCredit((Double) obj.get("Credit"));
                bank.setCreditCard((Double) obj.get("CreditCard"));
                bank.setSafe((Double) obj.get("Safe"));
                break;
            }
        }

        return bank;
    }

    public boolean update(long userId,Bank bank){
        Iterator<JSONObject> allData= this.bankList.iterator();
        while(allData.hasNext()){
            JSONObject obj = allData.next();
            Long objId = (Long) obj.get("UserId");
            if(objId == userId){
                this.bankList.remove(obj);
                break;
            }
        }
        JSONObject bankJson = new JSONObject();
        bankJson.put("UserId",bank.getUserId());
        bankJson.put("Credit",bank.getCredit());
        bankJson.put("CreditCard",bank.getCreditCard());
        bankJson.put("Safe",bank.getSafe());
        this.bankList.add(bankJson);

        try {
            FileWriter writer = new FileWriter("src/banks.json");
            writer.write(this.bankList.toJSONString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
