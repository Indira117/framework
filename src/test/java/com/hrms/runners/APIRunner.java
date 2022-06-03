package com.hrms.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", //need to give path for feature file
                  glue = "com/hrms/Api/Final/steps", //we need to glue our step definition for execute code
                   dryRun = false//when it's true give unimplemented snipped , not run whole  project. when its false it skips unimplemented step
                    , tags = {"@APIworkflow"} // for all smoke test
                    , strict = false // when its true it failed whole project cause undefined step
                    ,plugin = {"pretty", // will print executed steps inside console
                                "html:target/cucumber-default-reports" //generate html reports
                               ,"rerun:target/FailedTest.txt" // generate a txt file with failed file only
                               , "json:target/cucumber.json" //generate json report
                              }

          )

public class APIRunner {







}
