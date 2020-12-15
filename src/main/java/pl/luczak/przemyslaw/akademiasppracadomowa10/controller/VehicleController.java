package pl.luczak.przemyslaw.akademiasppracadomowa10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.luczak.przemyslaw.akademiasppracadomowa10.model.Vehicle;
import pl.luczak.przemyslaw.akademiasppracadomowa10.service.VehicleService;


import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle)
                ? new ResponseEntity<>(vehicle, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle)
                ? new ResponseEntity<>(vehicle, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeVehicle(@PathVariable long id) {
        return vehicleService.removeVehicle(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
