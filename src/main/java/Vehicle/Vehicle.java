package Vehicle;

public class Vehicle {
    private int vehicleID;
    private String vehicleBrand;
    private String vehicleModel;
    private String color;
    private int seatNo;
    private int milage;
    private String category;
    private String image;
    private boolean isAvailable; // New field added

    // Constructor
    public Vehicle(int vehicleID, String vehicleBrand, String vehicleModel, String color,
                   int seatNo, int milage, String category, String image, boolean isAvailable) {
        this.vehicleID = vehicleID;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.color = color;
        this.seatNo = seatNo;
        this.milage = milage;
        this.category = category;
        this.image = image;
        this.isAvailable = isAvailable; // Initialize the new field
    }

    // Getters and Setters
    public int getVehicleID() {
        return vehicleID;
    }
    
    public String getVehicleBrand() {
        return vehicleBrand;
    }
    
    public String getVehicleModel() {
        return vehicleModel;
    }
    
    public String getColor() {
        return color;
    }
    
    public int getSeatNo() {
        return seatNo;
    }
    
    public int getMilage() {
        return milage;
    }
    
    public String getCategory() {
        return category;
    }
    
    public String getImage() {
        return image;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }



    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", color='" + color + '\'' +
                ", seatNo=" + seatNo +
                ", milage=" + milage +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
