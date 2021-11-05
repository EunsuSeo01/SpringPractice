package com.umc.instagramdemo;

import com.umc.instagramdemo.reelsTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ReelsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int addReels(PostReelsReq postReelsReq){
        String createReelsQuery = "insert into Reels (userId, videoUrl, audioIdx) VALUES (?,?,?)";
        Object[] createReelsParams = new Object[]{
                postReelsReq.getUserId(), postReelsReq.getVideoUrl(), postReelsReq.getAudioIdx()
        };
        this.jdbcTemplate.update(createReelsQuery, createReelsParams);  // 쿼리랑 파라미터를 통해 update.

        return this.jdbcTemplate.queryForObject("select last_insert_id()", int.class);  // 자동으로 맨 마지막 인덱스값에서 1 증가된 인덱스가 리턴됨.
        /* last_insert_id 함수는 테이블의 마지막 auto_increment 값을 리턴한다!!! */
    }

    // Put
    public int putReels(PutReelsReq putReelsReq, int reelsIdx) {
        // reelsIdx가 어떤 값인 컬럼을 찾아서 userId, videoUrl, audioIdx 값을 지정된 값으로 수정한다.
        String putReelsQuery = "update Reels set userId = ?, videoUrl = ?, audioIdx = ? where reelsIdx = ?";
        Object[] updateReelsParams = new Object[]{
                putReelsReq.getUserId(), putReelsReq.getVideoUrl(), putReelsReq.getAudioIdx(), reelsIdx
        };
        this.jdbcTemplate.update(putReelsQuery, updateReelsParams);

        return reelsIdx;
    }

    // Delete
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
