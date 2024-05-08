package com.softtech.galaxyairservices.Adapaters;

import com.softtech.galaxyairservices.Models.GetterSetter;

import java.util.List;

public class GroupMembersResponse {

    private String message;
    private List<GetterSetter> groups;

    public GroupMembersResponse(String message, List<GetterSetter> groups) {
        this.message = message;
        this.groups = groups;
    }

    public String getMessage() {
        return message;
    }

    public List<GetterSetter> getGroups() {
        return groups;
    }
}
