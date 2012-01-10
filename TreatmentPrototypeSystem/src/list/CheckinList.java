package list;

import java.util.LinkedList;

public class CheckinList extends LinkedList<String> {
    private static CheckinList _instance;
    protected CheckinList() { super(); }
    public static CheckinList Instance() {
        if (_instance == null) {
            _instance = new CheckinList();
        }
        return _instance;
    }
}
