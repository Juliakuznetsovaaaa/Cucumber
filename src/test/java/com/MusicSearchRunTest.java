package com;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="C:\\Users\\Julia\\IdeaProjects\\Cucumber\\src\\test\\resources\\com\\musicSearch.feature",
        glue = {"Steps"},
        monochrome = true
)
public class MusicSearchRunTest {
}
