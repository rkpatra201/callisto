package org.test.shared;

import org.testng.annotations.Test;

public class EditTeamActionTest {
    @Test
    public void testMethod1() {
        ManageTeamSuite obj = ManageTeamSuite.getInstance();
        System.out.println("running test: team edited for solution: "+ obj.getSolutionId());
    }
}
