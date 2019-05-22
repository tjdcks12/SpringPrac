package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {

    /*
    슈퍼클래스에 기본적인 로직의 흐름을 만들고
    그 기능의 일부를 추상 메소드나 오버라이딩 가능한 protected 메소드 등으로 만든
    뒤 서브 클래스에서 이런 메소드를 필요에 맞게 구현해서 사용하도록 하는 방법을
    디자인 패턴에서 템플릿 메소드 패턴이라고 한다.

    또한 서브 클래스에서 구체적인 오브젝트 생성 방법을 결정하게 하는 것을
    팩토리 메소드 패턴 이라고 한다.
     */

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        //N사 커넥션 코드
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8&serverTimezone=UTC", "root", "tjdals5124");

        return c;
    }
}