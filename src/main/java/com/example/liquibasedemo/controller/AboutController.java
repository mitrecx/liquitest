package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.config.BuildConfig;
import com.example.liquibasedemo.util.ConfigUtil;
import com.example.liquibasedemo.util.TimeFormatUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Properties;

@RestController
@Api(tags = "about")
@RequestMapping("/v1/about")
public class AboutController {
    @Autowired
    private BuildConfig build;

    private final long startTime = System.currentTimeMillis();


    @GetMapping
    public ObjectNode test() {
        ObjectMapper om = new ObjectMapper();
        ObjectNode version = om.createObjectNode();
        version.put("name", build.getProject());
        version.put("version", build.getVersion());
        version.put("buildNumber", build.getBuildNumber());
        version.put("branch", build.getBranch());
        version.put("builtAt", TimeFormatUtil.timeInCST(
                ConfigUtil.parseLongOr(build.getTimestamp(), 0),
                TimeFormatUtil.DEFAULT_FORMATTER));

        version.put("builtAt2", TimeFormatUtil.timeInUTC(
                ConfigUtil.parseLongOr(build.getTimestamp(), 0),
                TimeFormatUtil.DEFAULT_FORMATTER));

        ObjectNode r = om.createObjectNode();
        r.set("version", version);
        // r.put("env", EnvironUtils.isDogfood() ? "dogfood" : "prod");

        r.put("upTime", ConfigUtil.millisToDuration(
                System.currentTimeMillis() - startTime));
        return r;
    }
}
