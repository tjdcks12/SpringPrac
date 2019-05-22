import dao.NUserDao;
import dao.UserDao;
import model.User;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("!!");

        UserDao dao = new NUserDao();

        User user = new User();
        user.setId("kohen8");
        user.setName("강성찬");
        user.setPassword("wow");

        dao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + "조회 성공");
    }
}
