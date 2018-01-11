package com.weibo.dashboard.dao;

import org.apache.ibatis.annotations.Param;

import com.weibo.dashboard.entity.Comment;

public interface CommentMapper {
	
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	int insert(Comment comment);
	
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	int delete(@Param("id") int id);
	
	
}
