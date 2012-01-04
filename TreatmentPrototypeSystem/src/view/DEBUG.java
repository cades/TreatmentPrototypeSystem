package view;



public class DEBUG {
    final int DEBUG_LEVEL = 0;
    public DEBUG(int level, String str) {
        if (level >= DEBUG_LEVEL)
            System.out.println(str);
    }
}
