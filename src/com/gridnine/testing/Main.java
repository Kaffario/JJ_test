package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {


        System.out.println("Полный список полётов");
        System.out.println(FlightBuilder.createFlights());


        System.out.println(Rules.DEPDATE.rulename);
        System.out.println(Filter.filter(FlightBuilder.createFlights(), Rules.DEPDATE));

        System.out.println(Rules.SEGMENTCONTROL.rulename);
        System.out.println(Filter.filter(FlightBuilder.createFlights(), Rules.SEGMENTCONTROL));

        System.out.println(Rules.GROUNDCONTROL_2H.rulename);
        System.out.println(Filter.filter(FlightBuilder.createFlights(), Rules.GROUNDCONTROL_2H));

    }
}
