package com.abc.comment.service;

import com.abc.commons.result.LivegoodsResult;

public interface CommentService {

    /**
     * query for list of comments
     * @param itemId
     * @param page
     * @param size
     * @return
     */
    LivegoodsResult selectCommentList(String itemId, int page, int size);
}
