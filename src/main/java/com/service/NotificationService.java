package com.service;

import com.model.Comment;
import com.model.Response;
import com.utility.DatabaseManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotificationService {

    public ResponseEntity getNotifications(String userID) {
        Response<ArrayList<Comment>> response = DatabaseManager.shared.getNotifications(userID);
        if (!response.getStatus()) {
            return ResponseEntity
                    .badRequest()
                    .body(response);
        }
        return ResponseEntity
                .ok()
                .body(response);
    }
}
