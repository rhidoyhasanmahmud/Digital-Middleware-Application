package com.middleware.service;

import com.middleware.controller.CourierController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataLoadService {
    private static final Logger log = LoggerFactory.getLogger(DataLoadService.class);

    @Value("${courier.data.load.scheduler.cron}")
    private String courierDataLoadCornTime;

    @Bean
    public String getMailSchedulerCronExpression() {
        log.debug("Scheduler initiated with {}", courierDataLoadCornTime);
        return courierDataLoadCornTime;
    }

    @Scheduled(cron = "#{@getMailSchedulerCronExpression}")
    public void DataJob() {
        LoadCourierDetails("all");
    }

    public void LoadCourierDetails(String courierName){


        if (courierName.equals("citylink") || courierName.equals("all")){

            // [Step - 01] Call CityLink API/Service
            // [Step - 02] Store Data into Courier Table if rate update

        }
        if (courierName.equals("jti")|| courierName.equals("all")){
            // [Step - 01] Call jti API/Service
            // [Step - 02] Store Data into Courier Table if rate update
        }

        // We Can Add Courier Service As Per Requirement

    }


}
