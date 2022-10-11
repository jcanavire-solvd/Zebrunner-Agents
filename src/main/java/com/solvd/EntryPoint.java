package com.solvd;

import com.google.gson.JsonObject;
import com.solvd.utils.AgentFileNotFound;

public class EntryPoint {
    public static void main(String[] args) throws AgentFileNotFound {

        ZebrunnerAPI API = ZebrunnerAPI.getInstance();

        try {
            API.tokenGeneration();
        } catch (AgentFileNotFound e) {
            System.out.println(e.getMessage());
        }

        JsonObject testDataStart = new JsonObject();
        testDataStart.addProperty("name", "Headless");
        testDataStart.addProperty("framework", "testng");

        try {
            API.testStartRequest(testDataStart);
        } catch (AgentFileNotFound e) {
            System.out.println(e.getMessage());
        }


        //region HEADLESS REQUESTS
        JsonObject endpointTSH = new JsonObject();
        endpointTSH.addProperty("name", "Test headless");

        API.testStartRequestHeadless(endpointTSH);

        JsonObject endpointTSEH = new JsonObject();
        endpointTSEH.addProperty("name", "Test headless");
        endpointTSEH.addProperty("className", "com.name.class");
        endpointTSEH.addProperty("methodName", "methodName()");

        API.testExecutionStartHeadless(endpointTSEH);

        JsonObject testEFDH = new JsonObject();
        testEFDH.addProperty("result", "PASSED");

        API.testExecutionFinishRequest(testEFDH, true);
        //endregion

        //region Test execution start
        JsonObject endpointTSE = new JsonObject();
        endpointTSE.addProperty("name", "Test l2");
        endpointTSE.addProperty("className", "com.name.class");

        endpointTSE.addProperty("methodName", "methodName()");

        API.testExecutionStart(endpointTSE);
        //endregion

        //region TestExecutionFinishRequest
        JsonObject testEFD = new JsonObject();
        testEFD.addProperty("result", "PASSED");

        API.testExecutionFinishRequest(testEFD, false);
        //endregion

        API.testRunFinishRequest();
    }
}
