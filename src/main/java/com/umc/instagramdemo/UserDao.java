package com.umc.instagramdemo;

import com.umc.instagramdemo.personTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetUserRes> userRes(){
        return this.jdbcTemplate.query("Select * from Person",
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("personIdx"),
                        rs.getString("phoneNumber"),
                        rs.getString("gender"),
                        rs.getString("birth"))

        );
    }

    public int addUser(PostUserReq postUserReq){
        String createUserQuery = "insert into Person (phoneNumber, gender, birth) VALUES (?,?,?)";
        Object[] createUserParams = new Object[]{
                postUserReq.getPhoneNumber(), postUserReq.getGender(), postUserReq.getBirth()
        };
        this.jdbcTemplate.update(createUserQuery, createUserParams);

        return this.jdbcTemplate.queryForObject("select last_insert_id()",int.class);
        /* last_insert_id 함수는 테이블의 마지막 auto_increment 값을 리턴한다!!! */
    }

}
