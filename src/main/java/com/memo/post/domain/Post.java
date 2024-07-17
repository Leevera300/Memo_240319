package com.memo.post.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString // 안쪽 내용 보는 용도
@Data // getter setter
public class Post {

	private int id;
	private int userId;
	private String subject;
	private String content;
	private String imagePath;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
