package Devices;

public class BilletDevice {
    private int id;

    public BilletDevice(int id) {
        this.id = id;
    }
    public BilletDevice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void scanDevices(){
        System.out.println("devices area scanning");
    }

    public boolean detectDoorsBlocked(){
        return true;
    }

    public BilletDevice getDevicesThatLeft(){
        return new BilletDevice();
    }

    public int calculateStopsTravelled(){
        return 10;
    }

}
