package me.Hackusate_PvP.FateHub.Utils;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemUtils {

    private static final Runtime runtime = Runtime.getRuntime();

    public static long getFreeMemory() {
        return calcMB(runtime.freeMemory());
    }

    public static long getMaximumMemory() {
        return calcMB(runtime.maxMemory());
    }

    public static long getTotalMemory() {
        return calcMB(runtime.totalMemory());
    }

    public static int getTotalProcessorCount() {
        return ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class).getAvailableProcessors();
    }

    private static long calcMB(long time) {
        return time / 1024 / 1024;
    }
}

