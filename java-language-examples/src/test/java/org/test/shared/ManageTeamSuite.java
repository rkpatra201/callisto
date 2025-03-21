package org.test.shared;

import java.util.UUID;


public class ManageTeamSuite {
    private static ManageTeamSuite instance;

    private String solutionId;
    private String componentId;

    private ManageTeamSuite() {
        solutionId = UUID.randomUUID().toString();
        componentId = UUID.randomUUID().toString();
        System.out.println("solution and component created");
    }

    public static ManageTeamSuite getInstance() {
        if (instance == null) {
            instance = new ManageTeamSuite();
        }
        return instance;
    }

    public void destroy() {
        System.out.println("Destroyed SuiteObject");
    }

    public String getSolutionId() {
        return solutionId;
    }

    public String getComponentId() {
        return componentId;
    }
}
