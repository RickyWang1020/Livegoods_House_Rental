package com.abc.comment.service.impl;

import com.abc.comment.dao.CommentDao;
import com.abc.comment.service.CommentService;
import com.abc.commons.result.LivegoodsResult;
import com.abc.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    /**
     * query for list of comments
     * @param itemId
     * @param page
     * @param size
     * @return
     */
    @Override
    public LivegoodsResult selectCommentList(String itemId, int page, int size) {

        // query for the list of comments
        Query query = new Query();
        // condition: where itemId = ...
        query.addCriteria(Criteria.where("itemId").is(itemId));
        // split by pages
        query.with(PageRequest.of(page, size));
        List<Comment> list = commentDao.selectCommentList(query);
        // hide the middle 4 digits of user phone number: 135 1234 4321 -> 135 **** 4321
//        for (Comment comment : list) {
//            String username = comment.getUsername()
//                    .replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
//            comment.setUsername(username);
//        }
        list.forEach(comment ->
                comment.setUsername(comment.getUsername()
                        .replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"))
        );
        LivegoodsResult livegoodsResult = LivegoodsResult.success("successful query", list);

        // query for the total number of comments
        Long count = commentDao.countByComment(itemId);
        // check if there are more entries after this page
        if (count > (page + 1) * size) {
            livegoodsResult.setHasMore(true);
        }

        return livegoodsResult;
    }
}
