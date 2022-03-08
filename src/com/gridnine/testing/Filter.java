package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Filter {

    //Общий метод, перключающий фильтрацию по принятому правилу.
    public static List<Flight> filter(List<Flight> flights, Rules rules) {


        switch (rules) {
            case DEPDATE : return depDateFilter(flights);
            case SEGMENTCONTROL : return segDateControl(flights);
            case GROUNDCONTROL_2H : return groundTime2H(flights);
            default : return flights;
        }

    }

    //На большом объеме данных пересборка нового ArrayList методом add должна показать сложноть О(1), в отличие от O(n) для реализации через удаление элементов из входящего списка
    private static List<Flight> depDateFilter (List<Flight> flights) {

        List<Flight> filteredflights = new ArrayList();

        for (Flight f:
             flights) {
            if (f.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now()))
                filteredflights.add(f);
        }

        return filteredflights;
    }


    private static List<Flight> segDateControl (List<Flight> flights) {

        List<Flight> filteredflights = new ArrayList();

        for (Flight f:
             flights) {
            boolean check = false;
            for (Segment s:
                    f.getSegments()) {
                if (s.getDepartureDate().isBefore(s.getArrivalDate())) check = true;
            }
            if (check) filteredflights.add(f);
        }

        return filteredflights;
    }


    private static List<Flight> groundTime2H (List<Flight> flights) {

        List<Flight> filteredflights = new ArrayList();

        for (Flight f:
             flights) {
            if (f.getSegments().size() == 1) filteredflights.add(f);
            else {
                long groundtime = 0;
                List<Segment> seg = f.getSegments();
                for (int i = 0; i < seg.size() - 1; i++) {
                    groundtime += Duration.between(seg.get(i).getArrivalDate(), seg.get(i + 1).getDepartureDate()).toSeconds();
                }
                if (groundtime < 7200) filteredflights.add(f);
            }
        }

        return filteredflights;

    }
}
