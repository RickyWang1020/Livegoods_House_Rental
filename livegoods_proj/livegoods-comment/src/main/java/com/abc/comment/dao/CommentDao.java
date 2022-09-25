package com.abc.comment.dao;

import com.abc.pojo.Comment;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface CommentDao {

    /**
     * query for list of comments
     * @param query
     * @return
     */
    List<Comment> selectCommentList(Query query);

    /**
     * query for the number of comments for the current product
     * @param itemId
     * @return
     */
    Long countByComment(String itemId);
}
