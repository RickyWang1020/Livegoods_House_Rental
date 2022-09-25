package com.abc.comment.controller;

import com.abc.comment.service.CommentService;
import com.abc.commons.result.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * query for list of comments
     * @param itemId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("")
    public LivegoodsResult selectCommentList(@RequestParam("id") String itemId, int page, @RequestParam(defaultValue = "5") int size) {
        return commentService.selectCommentList(itemId, page, size);
    }
}
