package com.umc.instagramdemo;

import com.umc.instagramdemo.model.*;
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

    public int addUser(PostUserReq postuserReq){
        String createUserQuery = "insert into Person (phoneNumber, gender, birth) VALUES (?,?,?)";
        Object[] createUserParams = new Object[]{
                postuserReq.getPhoneNumber(), postuserReq.getGender(), postuserReq.getBirth()
        };
        this.jdbcTemplate.update(createUserQuery, createUserParams);

        return this.jdbcTemplate.queryForObject("select last_insert_id()",int.class);
        /* last_insert_id 함수는 테이블의 마지막 auto_increment 값을 리턴한다!!! */
    }

    public int putReels(PutReelsReq putReelsReq, int reelsIdx) {
        // reelsIdx가 어떤 값인 컬럼을 찾아서 userId, videoUrl, audioIdx 값을 지정된 값으로 수정한다.
        String putReelsQuery = "update Reels set userId = ?, videoUrl = ?, audioIdx = ? where reelsIdx = ?";
        Object[] updateReelsParams = new Object[]{
                putReelsReq.getUserId(), putReelsReq.getVideoUrl(), putReelsReq.getAudioIdx(), reelsIdx
        };
        this.jdbcTemplate.update(putReelsQuery, updateReelsParams);

        return reelsIdx;
    }

    public List<DeleteReelsRes> reelsRes(int reelsIdx){
        return this.jdbcTemplate.query("Select * from Reels where reelsIdx = ?",
                (rs, rowNum) -> new DeleteReelsRes(
                        rs.getInt("reelsIdx"),
                        rs.getString("userId"),
                        rs.getString("videoUrl"),
                        rs.getInt("audioIdx")), reelsIdx

        );
    }

    // Delete User's Reels
    public void removeReels(int reelsIdx) {
        String deleteReelsQuery = "delete from Reels where reelsIdx = ?";
        this.jdbcTemplate.update(deleteReelsQuery, reelsIdx);
    }
}
