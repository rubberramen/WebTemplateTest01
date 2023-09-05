package com.webTest.model.board01;

import lombok.Data;

import java.sql.Date;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class BoardVO {

    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private int cnt;

    private String searchCondition;
    private String searchKeyword;
}
