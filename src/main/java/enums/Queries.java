 package enums;
    public enum Queries {

        CREATE_CAR_TABLE("CREATE TABLE cars(" +
                "id BIGINT PRIMARY KEY Not NULL," +
                "name VARCHAR(30) NOT NULL," +
                "speed INT NOT NULL," +
                "releaseDate INT NOT NULL," +
                "engine INT NOT NULL," +
                "color VARCHAR(30) NOT NULL)"),

        INSERT_CAR("INSERT INTO cars(id,name,speed,releaseDate,engine,color)" +
                "VALUES(?,?,?,?,?,?)"),
        FIND_BY_ID("SELECT * FROM cars WHERE id = ?"),
        UPDATE_CAR_NAME("UPDATE cars SET name = ? WHERE id = ?"),
        DELETE_CAR("DELETE FROM cars WHERE id = ?"),
        GET_ALL_CARS("SELECT * FROM cars");

        private final String query;

        Queries(String query) {
            this.query = query;
        }

        public String getQuery() {
            return this.query;
        }
    }

