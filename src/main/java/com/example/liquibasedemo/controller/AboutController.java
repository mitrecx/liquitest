package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.config.BuildConfig;
import com.example.liquibasedemo.util.ConfigUtil;
import com.example.liquibasedemo.util.TimeFormatUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        version.put("builtAt",
                TimeFormatUtil.timeInCST(ConfigUtil.parseLongOr(build.getTimestamp(), 0), TimeFormatUtil.DEFAULT_FORMATTER));

        ObjectNode r = om.createObjectNode();
        r.set("version", version);
        String upTime = ConfigUtil.millisToDuration(System.currentTimeMillis() - startTime);
        r.put("upTime", upTime);
        return r;
    }
}
