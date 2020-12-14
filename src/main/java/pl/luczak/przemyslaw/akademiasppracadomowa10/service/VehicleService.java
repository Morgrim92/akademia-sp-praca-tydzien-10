package pl.luczak.przemyslaw.akademiasppracadomowa10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.luczak.przemyslaw.akademiasppracadomowa10.model.Vehicle;
import pl.luczak.przemyslaw.akademiasppracadomowa10.repository.VehicleRepository;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }

    public boolean updateVehicle(Vehicle vehicle) {
        return vehicleRepository.updateVehicle(vehicle);
    }

    public boolean addVehicle(Vehicle vehicle) {
        return vehicleRepository.addVehicle(vehicle);
    }

    public boolean removeVehicle(long id) {
        return vehicleRepository.removeVehicle(id);
    }

}
