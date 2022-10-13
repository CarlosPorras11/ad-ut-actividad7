package org.iesfm.entity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileInfoEntity {
    private String name;
    private String type;
    private List<String> permissions;
    private long size;

    public FileInfoEntity() {
        super();
        permissions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String toPrint() {
        return getName() + ";" +
                getType() + ";" +
                Arrays.toString(getPermissions().toArray()) + ";" +
                getSize();
    }
}
