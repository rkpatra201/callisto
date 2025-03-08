package org.test.shared;

import org.testng.annotations.Test;

public class PerformAdminActionTest {
    @Test
    public void testMethod1() {
        ManageTeamSuite obj = ManageTeamSuite.getInstance();
        System.out.println("running test: edited solution name: "+obj.getSolutionId());
    }
}
