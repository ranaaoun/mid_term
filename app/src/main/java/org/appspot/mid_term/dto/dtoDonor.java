package org.appspot.mid_term.dto;

public class dtoDonor {
    private String name;
    private String bloodGroup;

    @Override
    public String toString() {
        return "dtoDonor{" +
                "name='" + name + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }

    public dtoDonor(String name, String bloodGroup) {
        this.name = name;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
