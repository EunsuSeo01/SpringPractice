package com.umc.instagramdemo.heartTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetHeartRes {
    private int heartIdx;
    private int postIdx;
    private String heartUserId;
    private String status;
}
