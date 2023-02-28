package Objects;

import java.util.HashMap;

public class RegisterObject {

    private String name;
    private String email;
    private String password;
    private String message;

    public RegisterObject(HashMap<String, String> TestData){
        populateObject(TestData);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void populateObject(HashMap<String, String> TestData){
        for (String Key: TestData.keySet()){
            switch (Key){
                case "name":
                    setName(TestData.get(Key));
                    break;
                case "email":
                    setEmail(TestData.get(Key));
                    break;
                case "password":
                    setPassword(TestData.get(Key));
                    break;
                case "message":
                    setMessage(TestData.get(Key));
                    break;
            }
        }
    }


}
