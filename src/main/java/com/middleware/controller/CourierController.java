package com.middleware.controller;

import com.middleware.dto.CourierPrice;
import com.middleware.model.Courier;
import com.middleware.repository.CourierRepository;
import com.middleware.service.DataLoadService;
import com.middleware.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourierController {
    private static final Logger log = LoggerFactory.getLogger(CourierController.class);

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private DataLoadService dataLoadService;

    @GetMapping("/getAll/courier-price")
    @PreAuthorize("@userAuthenticService.getUserPermission(#userName, #password)")
    public Map<String, Object> getAllCourierPrice(@RequestParam String userName, @RequestParam String password) {
        List<Courier> courierList = courierRepository.getAllByIsActive(true);

        log.info("Total Invoked Courier Data: " + courierList.size() + ", User Name: " + userName);

        List<CourierPrice> courierPriceList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();

        courierList.forEach(courier -> {
            CourierPrice courierPrice = new CourierPrice();

            courierPrice.setName(courier.getName());
            courierPrice.setRate(setPrecisionInRate(courier.getRate()));

            courierPriceList.add(courierPrice);
        });
        historyService.saveHistory("Get-Courier-Rate-Details", userName, courierPriceList);
        response.put("data", courierPriceList);

        return response;
    }

    public Double setPrecisionInRate(Double rate) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return Double.parseDouble(decimalFormat.format(rate));
    }

    @GetMapping("/load/courier-price")
    @PreAuthorize("@userAuthenticService.getUserPermission(#userName, #password)")
    public String loadCourierData(@RequestParam String courierName) {
        try {
            dataLoadService.LoadCourierDetails(courierName);
            log.info("Completed Process");
            return "Completed";
        } catch (Exception exception) {
            log.error("Exception: " + exception.getMessage());
            return "Error";
        }
    }
}
