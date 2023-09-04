package meteo;

import java.time.LocalDateTime;

public class SensorAdapter implements MeteoSensor {
    private final ST500Info st500Info;

    public SensorAdapter(ST500Info st500Info) {
        this.st500Info = st500Info;
    }

    @Override
    public int getId() {
        // Используем метод identifier() из ST500Info в качестве идентификатора
        return st500Info.getData().identifier();
    }

    @Override
    public Float getTemperature() {
        // Используем метод temperature() из ST500Info в качестве температуры
        return (float) st500Info.getData().temperature();
    }

    @Override
    public Float getHumidity() {
        // ST500Info не предоставляет влажность, поэтому возвращаем null
        return null;
    }

    @Override
    public Float getPressure() {
        // ST500Info не предоставляет давление, поэтому возвращаем null
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        // Создаем LocalDateTime на основе year(), day() и second() из ST500Info
        int year = st500Info.getData().year();
        int day = st500Info.getData().day();
        int second = st500Info.getData().second();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime result = LocalDateTime.of(year, 1, 1, 0, 0)
                .plusDays(day - 1)
                .plusSeconds(second);

        return result;
    }
}