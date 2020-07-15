package com.ur.thph.urcap;

public class ProgramNodeClassModel extends NodeClassModel{

    private String contributionClassName;
    private String serviceClassName;
    private String viewClassName;
    private String isChildrenAllowed;
    private String nodeId;
    private String nodeTitle;

    public ProgramNodeClassModel(String contributionClassName,String serviceClassName,String viewClassName,String isChildrenAllowed,String nodeId,String nodeTitle){
        this.contributionClassName = contributionClassName;
        this.serviceClassName = serviceClassName;
        this.viewClassName = viewClassName;
        this.isChildrenAllowed = isChildrenAllowed;
        this.nodeId = nodeId;
        this.nodeTitle = nodeTitle;
    }

    public String getContributionClassName() {
        return contributionClassName;
    }

    public void setContributionClassName(String contributionClassName) {
        this.contributionClassName = contributionClassName;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public void setServiceClassName(String serviceClassName) {
        this.serviceClassName = serviceClassName;
    }

    public String getViewClassName() {
        return viewClassName;
    }

    public void setViewClassName(String viewClassName) {
        this.viewClassName = viewClassName;
    }

    public String getIsChildrenAllowed() {
        return isChildrenAllowed;
    }

    public void setIsChildrenAllowed(String isChildrenAllowed) {
        this.isChildrenAllowed = isChildrenAllowed;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeTitle() {
        return nodeTitle;
    }

    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }
}
