package org.test.shared;

import org.testng.IExecutionListener;

public class ManageTeamSuiteListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.out.println("Test Suite Execution Started...");
        // Ensure Singleton Suite Object is initialized
        ManageTeamSuite.getInstance();
    }

    @Override
    public void onExecutionFinish() {
        ManageTeamSuite.getInstance().destroy(); // cleanup
        System.out.println("Test Suite Execution Finished...");
    }
}
