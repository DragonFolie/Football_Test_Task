package com.synergyway.service;


import com.synergyway.entity.Flight;
import com.synergyway.repository.FlightRepository;
import jdk.jfr.Description;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class FlightService {



    private FlightRepository flightRepository;




    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public List<Flight> findAllFlights(){

        return flightRepository.findAll();

    }


    public List<Flight> allActiveFlightLessThan24Hour(String newNameOfAirCompany)throws ParseException{

        int airCompanyId =  flightRepository.getAirplaneIdByName(newNameOfAirCompany);
        List<Flight> list = new ArrayList<>();
        list = flightRepository.getFlightWithActiveStatusAndLessThan24Hour(airCompanyId);
        List<Flight> activeFlightList = new ArrayList<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeNow =  dtf.format(now);

        for (int i = 0; i < list.size(); i++) {


           String dateTimeFrom =  list.get(i).getCreatedAt();

           if( !isMoreThan24Hour(dateTimeFrom,dateTimeNow) ){
               activeFlightList.add(list.get(i));
           }

        }

       return activeFlightList;


    }

    @Description("Format of date is  yyyy-MM-dd hh:mm:ss")
    public boolean isMoreThan24Hour(String dateTimeFrom,String dateTimeNow) throws ParseException{

        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = sdf.parse(dateTimeNow);
        Date date2 = sdf.parse(dateTimeFrom);

        return Math.abs(date1.getTime() - date2.getTime()) > MILLIS_PER_DAY;
    }





}
