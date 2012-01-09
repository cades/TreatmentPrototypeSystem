package storage.casehistory;

import java.util.ArrayList;


public class CaseHistoryStorage extends ArrayList<CaseHistory>{

    /**
     * 
     */
    private static final long serialVersionUID = 2463390526952410522L;
    
    private static CaseHistoryStorage _instance = null;
    protected CaseHistoryStorage() { super(); }
    public static CaseHistoryStorage Instance() {
        if (_instance == null) {
            _instance = new CaseHistoryStorage();
        }
        return _instance;
    }

}
