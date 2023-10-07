package model;

public class Car {
    private Long id;
    private String name;
    private Integer speed;
    private Integer releaseDate;
    private Double engine;
    private String color;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public Double getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public Car(Long id, String name, Integer speed, Integer releaseDate, Double engine, String color) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.releaseDate = releaseDate;
        this.engine = engine;
        this.color = color;


    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", releaseDate=" + releaseDate +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                '}';
    }
}
