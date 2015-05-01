package com.example.duy.tryout;

/**
 * Created by Duy on 4/30/2015.
 */
public class PersonalInfo {
    private int _id;
    private String _email;
    private String _password;

    public PersonalInfo(){

    }

    public PersonalInfo(String email,String password){
        this._email = email;
        this._password = password;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
