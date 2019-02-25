package Util;

import java.util.ArrayList;
import java.util.List;

public class Dir {

    public String name;
    public List<Dir> children;

    public Dir() {
        children = new ArrayList<>();
    }
}
