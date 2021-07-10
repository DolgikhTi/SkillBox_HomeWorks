import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.

        LocalDateTime dateNow = LocalDateTime.now();
        return airport.getTerminals().stream()
        .flatMap(terminal -> terminal.getFlights().stream())
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> f.getDate()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().isAfter(dateNow) && f.getDate()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().isBefore(dateNow.plusHours(2)))
                .collect(Collectors.toList());
    }

}