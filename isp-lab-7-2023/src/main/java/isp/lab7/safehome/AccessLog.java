package isp.lab7.safehome;
import java.time.LocalDateTime;

public class AccessLog {
    private final String tenantName;
    private final LocalDateTime dateTime;
    private final String operation;
    private final DoorStatus doorStatus;
    private final String errorMessage;

    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus, String errorMessage) {
        this.tenantName = tenantName;
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        this.errorMessage = errorMessage;
    }

    // getters for the instance variables
    public String getTenantName() {
        return tenantName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getOperation() {
        return operation;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
