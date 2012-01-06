package storage.staff;

import java.util.*;

/**
 * entity兼control?
 * 存員工資料的資料庫
 */
public class StaffStorage extends HashMap<String, Staff> {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public boolean validate(String id, String password) {
        if (this.containsKey(id) && this.get(id).password().equals(password)) return true;
        return false;
    }
}

/**
 * 以下這兩個class沒有標籤
 * 一個檔案只能有一個public class
 * 沒有標籤的，在同一個package下的class看的到。萬一哪天要整理package，這兩個必須拿出去「自立門戶」
 * 並加上public才行。
 */

/**
 * 已經搬出去囉^^
 */
