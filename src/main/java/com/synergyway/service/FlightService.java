package com.synergyway.service;


import com.synergyway.entity.Flight;
import com.synergyway.repository.AirplaneRepository;
import com.synergyway.repository.FlightRepository;
import jdk.jfr.Description;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.synergyway.classAssistants.TimeHelper.*;

@Service
@Data
@RequiredArgsConstructor
public class FlightService {

    private FlightRepository flightRepository;
    private AirplaneRepository airplaneRepository;


    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    @Autowired
    public void setAirplaneRepository(AirplaneRepository airplaneRepository) { this.airplaneRepository = airplaneRepository; }



    public List<Flight> findAllFlights(){ return flightRepository.findAll(); }




    public List<Flight> allActiveFlightLessThan24Hour(String newNameOfAirCompany)throws ParseException{

        int airCompanyId =  flightRepository.getAirplaneIdByName(newNameOfAirCompany);
        List<Flight> list = new ArrayList<>();
        list = flightRepository.getFlightWithActiveStatusAndLessThan24Hour(airCompanyId);
        List<Flight> activeFlightList = new ArrayList<>();
        String dateTimeNow = getCurrentDateTime();


        for (int i = 0; i < list.size(); i++) {

           String dateTimeFrom =  list.get(i).getCreatedAt();

           if( !isMoreThan24Hour(dateTimeFrom,dateTimeNow) ){
               activeFlightList.add(list.get(i));
           }

        }

       return activeFlightList;
    }







    public void addFlightToCompany(int factorySerialNumber , String companyName,   int distance ,   String departureCountry,
                                     String destinationCountry ,  String createdAt ,  String endedAt ,  String estimatedFlightTime ,  String delayStartedAt  ){

        int airCompanyId  = airplaneRepository.getAirCompanyByName(companyName);
        int airplaneId = airplaneRepository.getAirplaneByFactorySerialNumber(factorySerialNumber);

        flightRepository.addFlight(distance,departureCountry,destinationCountry,createdAt,endedAt,estimatedFlightTime,delayStartedAt,airplaneId,airCompanyId);

    }


    public void updateStatusToDelay(int idOfFlight,String delayDateTime){

        flightRepository.updateFlightStatusAndSetDelay(delayDateTime,idOfFlight);

    }

    public void updateFlightStatusToActive(int idOfFlight,String startDateTime){

        flightRepository.updateFlightStatusAndSetStartedTime(startDateTime,idOfFlight);

    }

    public void updateFlightStatusToCompleted(int idOfFlight){

        flightRepository.updateFlightStatusAndSetCompleteTime(idOfFlight);

    }






    public List<Flight> getAllFlightWithCompletedStatus(){
        List <Flight> list = flightRepository.getAllFlightWithCompletedStatus();
        List <Flight> newList = new ArrayList<>();

//

        for (int i = 0; i <list.size() ; i++) {

            if (list.get(i).getDelayStartedAt() == null) {

                String dateTimeOne = list.get(i).getCreatedAt();
                String dateTimeTwo = list.get(i).getEndedAt();
                long timeFlight =  findDifferentBetweenDateTime(dateTimeOne,dateTimeTwo);
                long estimateFlightTime = timeConvertToMinute( list.get(i).getEstimatedFlightTime());

                if (timeFlight > estimateFlightTime){
                    newList.add(list.get(i));
                }
            }

            if (list.get(i).getDelayStartedAt() != null) {
                String dateTimeOne = list.get(i).getDelayStartedAt();
                String dateTimeTwo = list.get(i).getEndedAt();
                String estimatedFlightTime = list.get(i).getEstimatedFlightTime();
                long timeFlight =  findDifferentBetweenDateTime(dateTimeOne,dateTimeTwo);
                long estimateFlightTime = timeConvertToMinute(estimatedFlightTime );

                if (timeFlight > estimateFlightTime){
                    newList.add(list.get(i));
                }
            }

        }


        return newList;
    }





}
