package pl.luczak.przemyslaw.akademiasppracadomowa10.model;

public class Vehicle {
    private long id;
    private String vehicleBrand;
    private String model;
    private String color;

    public Vehicle() {
    }

    public Vehicle(long id, String vehicleBrand, String model, String color) {
        this.id = id;
        this.vehicleBrand = vehicleBrand;
        this.model = model;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

