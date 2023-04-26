package cn.minfengyu.eneity.convert;

import java.util.Objects;

public class Tribool {

    private byte value;

    public Tribool() {
        clear();
    }


    public <T> Tribool(T value) {
        set(value);
    }

    public Tribool(Tribool value) {
        this.value = value.value;
    }

    public boolean isUndef() {
        return value <= 1;
    }

    public boolean isTrue() {
        return value == 3;
    }

    public Tribool reverse() {
        if (value > 1) {
            value = value > 2 ? (byte) 2 : (byte) 3;
        }
        return this;
    }

    public boolean get(boolean defValue) {
        if (value <= 1) {
            return defValue;
        }
        return isTrue();
    }

    public String getStr() {
        switch (value) {
            case 2:
                return "false";
            case 3:
                return "true";
        }
        return "undef";
    }

    public <T> Tribool define(T value) {
        if (value instanceof Boolean) {
            set((boolean) value);
        }
        return this;
    }

    public <T> Tribool parse(T value) {
        return define(value);
    }

    public Tribool clear() {
        value = 0;
        return this;
    }

    public <T> boolean set(T value) {
        if (value instanceof Boolean) {
            this.value = (byte) (((Boolean) value) ? 3 : 2);
            return isTrue();
        }
        return false;
    }

    public boolean set(String str) {
        Objects.requireNonNull(str);
        switch (str) {
            case "true":
            case "1":
                value = 3;
                break;
            case "false":
            case "0":
                value = 2;
                break;
            default:
                try {
                    if (Integer.parseInt(str) > 1) {
                        value = 3;
                    } else {
                        value = 0;
                    }
                } catch (NumberFormatException e) {
                    value = 0;
                }
        }
        return isTrue();
    }

    public boolean equals(Tribool other) {
        return value == other.value;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Tribool tribool = (Tribool) other;
        return value == tribool.value;
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
