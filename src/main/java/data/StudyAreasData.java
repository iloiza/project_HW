package data;

public enum StudyAreasData {
    TESTING("Тестирование"),
    PROGRAMMING("Программирование"),
    ARCHITECTURE("Архитектура"),
    INFRASTRUCTURE("Инфраструктура"),
    DATA_SCIENCE("Data Science"),
    GAME_DEV("GameDev"),
    MANAGEMENT("Управление"),
    ANALYSIS("Аналитика"),
    CORPORATE_STUDY("Корпоративные курсы"),
    ALL_AREAS("Все направления"),
    SECURITY("Безопасность");

    private String name = "";

    StudyAreasData(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
