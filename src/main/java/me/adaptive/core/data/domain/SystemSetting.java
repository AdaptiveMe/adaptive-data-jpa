package me.adaptive.core.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by panthro on 27/08/15.
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "system_setting")
public class SystemSetting extends BaseEntity {

    @NotNull
    @Column(name = "keyname")
    private String key;

    @NotNull
    @Column(name = "value")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemSetting)) return false;
        if (!super.equals(o)) return false;

        SystemSetting that = (SystemSetting) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        return !(value != null ? !value.equals(that.value) : that.value != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }


    public int getInt() {
        return Integer.parseInt(value);
    }

    public float getFloat() {
        return Float.parseFloat(value);
    }

    public boolean getBoolean() {
        return Boolean.getBoolean(value);
    }

    public long getLong() {
        return Long.parseLong(value);
    }
}
