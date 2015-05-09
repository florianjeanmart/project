package be.flo.project.util;

/**
 * Created by florian on 9/05/15.
 */
public enum AppStatusEnum {

    TEST("test"),
    PRODUCTION("production"),
    LOCAL("local");


    private final String s;

    AppStatusEnum(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public static AppStatusEnum getByString(String s) {
        for (AppStatusEnum appStatusEnum : AppStatusEnum.values()) {
            if (appStatusEnum.getS().equals(s)) {
                return appStatusEnum;
            }
        }
        return LOCAL;
    }
}
