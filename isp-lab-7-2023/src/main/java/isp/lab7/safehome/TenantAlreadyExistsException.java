package isp.lab7.safehome;

public class TenantAlreadyExistsException extends Exception {
    public TenantAlreadyExistsException() {
        super("Tenant already exists");
    }
}
