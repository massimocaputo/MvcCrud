package com.acn.nemo.controller;

import com.acn.nemo.dto.LocationDto;
import com.acn.nemo.exception.LocationNotFoundException;
import com.acn.nemo.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/location")
@Slf4j
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/")
    public String showHomePage() {
        log.info("showHomePage");
        return "homePage";
    }

    @GetMapping("/getAllLocation")
    public String getAllInvoices(@RequestParam(value = "message", required = false) String message, Model model  ) {
        log.info("INIT getAllInvoices");
        List<LocationDto> locations= locationService.getLocations();
        model.addAttribute("list", locations);
        model.addAttribute("message", message);
        return "allLocationsPage";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Short id) {
        log.info("Init getEditPage");
        String page = null;
        try {
            if (id != null) {
                LocationDto locationDto = locationService.getLocationById(id);
                model.addAttribute("locationDto", locationDto);
                log.info("locationDto: {}", locationDto);
                page="editLocationPage";
            }
        } catch (LocationNotFoundException e) {
            log.error(e.getMessage());
            attributes.addAttribute("message", e.getMessage());
            page="redirect:getAllInvoices";
        }
        log.info("page: {}", page);
        return page;
    }


    @PostMapping("/update")
    public String updateInvoice(@ModelAttribute LocationDto locationDto, RedirectAttributes attributes
    ) {
//        service.updateInvoice(invoice);
//        Long id = invoice.getId();
//        attributes.addAttribute("message", "Invoice with id: '"+id+"' is updated successfully !");
        return "redirect:getAllInvoices";
    }



}
