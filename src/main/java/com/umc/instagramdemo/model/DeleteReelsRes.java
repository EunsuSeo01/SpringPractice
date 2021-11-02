package com.umc.instagramdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
public class DeleteReelsRes {
    private int reelsIdx;
    private String userId;
    private String videoUrl;
    private int audioIdx;
    //private String status;
    //private Date createAt;
    //private Date UpdateAt;
}
