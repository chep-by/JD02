package by.itacademy;

public class UserService {
    public int userPlusOne() {
        return new UserDao().getNum() + 1;
    }
}
