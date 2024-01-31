package feature

import io.cucumber.core.options.Constants
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("cucumber/feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "cucumber.feature")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "property")
class RunCucumberTest