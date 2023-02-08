package com.middleware.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.middleware.repository.HistoryRepository;
import com.middleware.model.History;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
@EnableAsync
public class HistoryService {

    private static final Logger log = LoggerFactory.getLogger(HistoryService.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HistoryRepository historyRepository;

    private void save(History history) {
        log.info("Saving history: {}", history);
        historyRepository.save(history);
    }

    private void saveHistory(String actionName, String userName, String resultBody) {

        History history = new History();
        history.actionName = actionName;
        history.userName = userName;
        history.resultBody = resultBody;
        history.logTime = LocalDateTime.now();

        save(history);
    }

    @Async
    public void saveHistory(String actionName, String userName) {

        Map<String, String> map = new HashMap<>();
        JSONObject json = new JSONObject(map);
        saveHistory(actionName, userName, json.toString());
    }

    @Async
    public void saveHistory(String actionName, String userName, Object reqObj) {

        try {
            String req = objectMapper.writeValueAsString(reqObj);
            saveHistory(actionName, userName, req);
        } catch (Exception e) {
            log.error("Could not write history for action : {} by user: {} to DB because {}", actionName, userName, e.getMessage(), e);
        }
    }

    @Async
    public void saveHistory(String actionName, String userName, String ... args) throws Exception {

        if(args.length % 2 == 1) {
            throw new Exception("The number of arguments should be even, not odd");
        }

        Map<String, String> map = new HashMap<>();
        for(int i=0; i<args.length-1; i+=2) {

            String key = args[i];
            String val = args[i+1];

            map.put(key, val);
        }

        JSONObject json = new JSONObject(map);
        saveHistory(actionName, userName, json.toString());
    }
}
