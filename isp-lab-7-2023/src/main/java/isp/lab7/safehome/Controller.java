package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ControllerInterface {
    private static final String MASTER_KEY = "1234";
    private final Door door;
    private final List<Tenant> tenants;
    private int wrongPinAttempts;

    public Controller() {
        door = new Door();
        tenants = new ArrayList<>();
        wrongPinAttempts = 0;
    }

    public DoorStatus enterPin(String pin) throws Exception, TooManyAttemptsException {
        if (pin.equals(MASTER_KEY)) {
            wrongPinAttempts = 0;
            toggleDoor();
        } else {
            Tenant tenant = getTenantByPin(pin);
            if (tenant == null) {
                wrongPinAttempts++;
                throw new InvalidPinException();
            }
            wrongPinAttempts = 0;
            toggleDoor();
            logAccess(tenant.getName(), "enterPin", door.getStatus(), null);
        }

        if (wrongPinAttempts >= 3) {
            door.lockDoor();
            throw new TooManyAttemptsException();
        }

        return door.getStatus();
    }

    public void addTenant(String pin, String name) throws Exception {
        if (getTenantByName(name) != null) {
            throw new TenantAlreadyExistsException();
        }
        tenants.add(new Tenant(name, pin));
    }

    public void removeTenant(String name) throws Exception, TenantNotFoundException {
        Tenant tenant = getTenantByName(name);
        if (tenant == null) {
            throw new TenantNotFoundException();
        }
        tenants.remove(tenant);
    }

    private Tenant getTenantByName(String name) {
        for (Tenant tenant : tenants) {
            if (tenant.getName().equals(name)) {
                return tenant;
            }
        }
        return null;
    }

    private Tenant getTenantByPin(String pin) {
        for (Tenant tenant : tenants) {
            if (tenant.getPin().equals(pin)) {
                return tenant;
            }
        }
        return null;
    }

    private void toggleDoor() {
        if (door.getStatus() == DoorStatus.CLOSE) {
            door.unlockDoor();
        } else {
            door.lockDoor();
        }
    }

    private void logAccess(String tenantName, String operation, DoorStatus doorStatus, String errorMessage) {
        final List<AccessLog> accessLogList = new ArrayList<>();
        AccessLog accessLog = new AccessLog(tenantName, LocalDateTime.now(), operation, doorStatus, errorMessage);
        accessLogList.add(accessLog);
    }

    public List<AccessLog> getAccessLog() {
        List<AccessLog> accessLogList = null;
        return accessLogList;
    }
}
