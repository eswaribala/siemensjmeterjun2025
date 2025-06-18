package com.siemens;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class LoginSampler implements JavaSamplerClient {

    @Override
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("username", "admin");
        params.addArgument("password", "admin123");
        return params;
    }

    @Override
    public void setupTest(JavaSamplerContext context) {}

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.sampleStart();

        String username = context.getParameter("username");
        String password = context.getParameter("password");

        try {
            boolean success = "admin".equals(username) && "admin123".equals(password);
            result.setSuccessful(success);
            result.setResponseMessage(success ? "Login Success" : "Login Failed");
            result.setResponseCode("200");
            result.setResponseData("Test result for " + username, "UTF-8");
        } catch (Exception e) {
            result.setSuccessful(false);
            result.setResponseCode("500");
            result.setResponseMessage("Error: " + e.getMessage());
        } finally {
            result.sampleEnd();
        }

        return result;
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {}
}
