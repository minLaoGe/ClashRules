package cn.minfengyu.eneity.convert;

import java.util.ArrayList;
import java.util.List;

public class StrArray {
    private List<String> list = new ArrayList<>();

    public StrArray() {}

    public void add(String str) {
        list.add(str);
    }

    public int size() {
        return list.size();
    }

    public String get(int index) {
        return list.get(index);
    }

    // other methods as needed
}
