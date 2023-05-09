package isp.lab7.safehome;

public class Door {
    private DoorStatus status;

    public Door() {
        status = DoorStatus.CLOSE;
    }

    public DoorStatus getStatus() {
        return status;
    }

    public boolean isOpen() {
        return status == DoorStatus.OPEN;
    }

    public void lockDoor() {
        status = DoorStatus.CLOSE;
    }

    public void unlockDoor() {
        status = DoorStatus.OPEN;
    }
}
