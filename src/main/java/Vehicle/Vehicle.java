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

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
