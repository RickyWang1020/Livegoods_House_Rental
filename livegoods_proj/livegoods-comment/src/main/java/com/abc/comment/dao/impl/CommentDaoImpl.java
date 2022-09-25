package com.abc.comment.dao.impl;

import com.abc.comment.dao.CommentDao;
import com.abc.pojo.Comment;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * query for list of comments
     * @param query
     * @return
     */
    @Override
    public List<Comment> selectCommentList(Query query) {
        return mongoTemplate.find(query, Comment.class);
    }

    /**
     * query for the number of comments for the current product
     * @param itemId
     * @return
     */
    @Override
    public Long countByComment(String itemId) {
        TypedAggregation<Comment> typedAggregation = new TypedAggregation<>(
                // input type
                Comment.class,
                // aggregation: group by itemId and count, the result is aliased as count
                Aggregation.group("itemId").count().as("count")
        );
        AggregationResults<Map> results = mongoTemplate.aggregate(typedAggregation, Map.class);
        ArrayList<Document> resultList = (ArrayList<Document>) results.getRawResults().get("results");
        for (Document res : resultList) {
            if (itemId.equals(res.get("_id"))) {
                return Long.parseLong(String.valueOf(res.get("count")));
            }
        }
        return 0L;
    }
}
