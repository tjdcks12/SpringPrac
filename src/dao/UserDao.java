package dao;

import model.User;

import java.sql.*;

public abstract class UserDao {

    // 초난감 DAO

    // 이 UserDao가 아주 유명해져서 N사와 D사가 구매의지가 있다. But 각 개발사는 다른 DB를 사용하고 있다면??
    // DB 커넥션을 가져오는데 있어 독자적으로 만든 방법을 적용하고 싶어한다면?
    // 상속을 통한 확장을 적용해보자.


    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;


}
