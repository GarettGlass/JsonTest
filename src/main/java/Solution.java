import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/*{
  "className" : "ParkingLot",
  "name" : "Super ParkingLot",
  "city" : "Kyiv",
  "vehicles" : [ {
    "className" : "RacingBike",
    "name" : "Simba",
    "owner" : "Peter",
    "age" : 2
  }, {
    "className" : "Motorbike",
    "name" : "Manny",
    "owner" : null
  }, {
    "className" : "Car"
  } ]
}

Process finished with exit code 0
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ParkingLot parkingLot = new ParkingLot("Super ParkingLot", "Kyiv");
        RacingBike racingBike = new RacingBike("Simba", "Peter", 2);
        Motorbike motorbike = new Motorbike("Manny");
        Car car = new Car();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(racingBike);
        vehicles.add(motorbike);
        vehicles.add(car);
        parkingLot.setVehicles(vehicles);
        convertToJson(parkingLot);
    }

    public static void convertToJson(ParkingLot parkingLot) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, parkingLot);
        System.out.println(writer.toString());
    }
}
