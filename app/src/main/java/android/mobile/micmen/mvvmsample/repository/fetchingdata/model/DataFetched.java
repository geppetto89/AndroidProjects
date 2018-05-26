package android.mobile.micmen.mvvmsample.repository.fetchingdata.model;

/**
 * <h1>Data Fetched Model</h1>
 *
 * model object dispatched to the view
 * provides the value fetched from the server and the times it has been updated
 * it has a status for notifying the view about the fetching operation progress
 *
 * @author Michele Meninno
 */
public class DataFetched {

    private String value;
    private Status status;
    private int timesFetched;

    public void setTimesFetched(int timesFetched) {
        this.timesFetched = timesFetched;
    }

    public int getTimesFetched() {
        return timesFetched;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DataFetched(String value, Status status, int timesFetched) {
        this.value = value;
        this.status = status;
        this.timesFetched = timesFetched;
    }

    public DataFetched(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public enum Status {EMPTY, LOADING, SUCCESS, ERROR}
}
