package com.company.Database;

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

public class UserDb {
    JSONArray userList;
    public UserDb() {
       this.userList = getList();
    }

    public JSONArray getList(){
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("src/users.json");
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

    public boolean add(User user){
        JSONObject userJson = new JSONObject();
        userJson.put("Id",user.getId());
        userJson.put("TC",user.getTc_number());
        userJson.put("Name",user.getName());
        userJson.put("BirthDate",user.getBirth_date());
        userJson.put("Pass",user.getPass());

        this.userList.add(userJson);

        try {
            FileWriter writer = new FileWriter("src/users.json");
            writer.write(this.userList.toJSONString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public User getByTcNumber(String tc_number){
        Iterator<JSONObject> allData= this.userList.iterator();
        User user = new User();
        while(allData.hasNext()){
            JSONObject obj = allData.next();
            String objTc = (String) obj.get("TC");
            if(objTc.equals(tc_number)){
                user.setId((Long) obj.get("Id"));
                user.setTc_number((String) obj.get("TC"));
                user.setName((String) obj.get("Name"));
                user.setBirth_date((String) obj.get("BirthDate"));
                user.setPass((String) obj.get("Pass"));
                break;
            }
        }

        return user;
    }
}
