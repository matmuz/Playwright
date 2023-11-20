package org.example.options;

import com.microsoft.playwright.Tracing;

import java.nio.file.Path;

import static org.example.config.Constants.TRACES_DIR_PATH;
import static org.example.config.Constants.ZIP_EXTENSION;

public class TracingOptionsFactory {

    public static Tracing.StartOptions getStartOptions() {
        return new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false);
    }

    public static Tracing.StopOptions getStopOptions(String testName) {
        return new Tracing.StopOptions().setPath(Path.of(TRACES_DIR_PATH + testName + ZIP_EXTENSION));
    }
}
