package com.umc.instagramdemo.instaDao;


import com.umc.instagramdemo.commentTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CommentDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // GET
    public List<GetCommentRes> cmtRes(int postIdx) {
        return this.jdbcTemplate.query("SELECT * FROM Comment WHERE postIdx = ?",
                (rs, rowNum) -> new GetCommentRes(
                        rs.getInt("cmtIdx"),
                        rs.getInt("postIdx"),
                        rs.getString("cmtUserId"),
                        rs.getString("comment"),
                        rs.getString("status")
                ), postIdx);
    }

    // POST
    public PostCommentRes addComment(PostCommentReq postCmtReq, int postIdx) {
        String createCmtQuery = "INSERT INTO Comment (postIdx, cmtUserId, comment) VALUES (?,?,?)";
        Object[] createCmtParam = new Object[] {
                postCmtReq.getPostIdx(), postCmtReq.getCmtUserId(), postCmtReq.getComment()
        };
        this.jdbcTemplate.update(createCmtQuery, createCmtParam);

        return new PostCommentRes(this.jdbcTemplate.queryForObject("SELECT last_insert_id()", int.class));
    }
}
