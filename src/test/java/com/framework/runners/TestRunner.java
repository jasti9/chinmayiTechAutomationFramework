package com.framework.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@chatGPT",
		glue = {"com.framework.stepDefinitions"},
	    features={"src/test/resources/features/"},
	    plugin = { "me.jvt.cucumber.report.PrettyReports:target/cucumber" },
	    monochrome = true
	    )
public class TestRunner {
	
}
