package org.example;

public class User implements AutoCloseable{
    String family;
    String name;
    String last_name;
    String dateOfBirth;
    String phone_number;
    char sex;

    public boolean isAlpha(String name) {
        return name.matches("[а-яА-Я]+");
    }
    public boolean isNumeric(String name) {
        return name.matches("[0-9.]+");
    }

    public boolean isData(String date) {
        if (!isNumeric(date)) return false;
        String[] num = date.split("\\.");
        if (num.length != 3){return false;}
        for(String str: num)
            if (str.length() != 2) {
                return false;
            }
        return true;
        }

    public User(String str) throws UserException {
        String[] fields = str.split(" ");
        if (fields.length != 6){
            throw new UserException("Количество полей данных не соответсвует требованиям");
        }
        if(isAlpha(fields[0])){
            this.family = fields[0];}
        else throw new UserException("Фамилия должна состоять из букв");
        if(isAlpha(fields[1])){
            this.name = fields[1];}
        else throw new UserException("Имя должно состоять из букв");
        if(isAlpha(fields[2])){
            this.last_name = fields[2];}
        else throw new UserException("Отчество должно состоять из букв");
        if(isData(fields[3])){
            this.dateOfBirth = fields[3];}
        else throw new UserException("Неверный формат дня рождения");
        if(fields[4].matches("[0-9.]+")){
            this.phone_number = fields[4];}
        else throw new UserException("Номер может состоять только из цифр");
        if(fields[5].matches("[fm]")){
            this.sex = fields[5].charAt(0);}
        else throw new UserException("Неверно указан пол");

    }

    @Override
    public String toString() {
        return  "<" + family + ">" +
                "<" + name + ">" +
                "<" + last_name + ">" +
                "<" + dateOfBirth + ">" +
                "<" + phone_number + ">" +
                "<" + sex +
                ">";
    }

    @Override
    public void close() throws UserException {

    }
}
