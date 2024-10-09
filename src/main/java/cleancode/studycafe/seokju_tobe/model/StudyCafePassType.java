package cleancode.studycafe.seokju_tobe.model;

public enum StudyCafePassType {

    NONE("존재 하지 않음"),
    HOURLY("시간 단위 이용권"),
    WEEKLY("주 단위 이용권"),
    FIXED("1인 고정석");

    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }

}
