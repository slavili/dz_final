import java.sql.*;

public class ConnectionDB {
    private Connection connectToDb;

    public ConnectionDB(String host, int port, String dbName, String login, String password) throws SQLException {
        this.connectToDb = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbName+"?serverTimezone=UTC", login, password);
    }

    public ResultSet selectFromTable() throws SQLException {
        String sql = "SELECT\n" +
                "      ID -- идентификатор\n" +
                "    , password -- пароль\n" +
                "    , hash -- хэш пароля\n" +
                "    , cost -- стоимость\n" +
                "    , times -- время выполнения\n" +
                "FROM testhashe";
        PreparedStatement select = connectToDb.prepareStatement(sql);
        return select.executeQuery();
    }
    public void createTable() {
        String createTableSql1 = "CREATE TABLE IF NOT EXISTS instructionset " +
                "(     IDSource INT UNSIGNED NOT NULL\n" +
                "    , nameofinstruction varchar(255) NOT NULL\n" +
                "    , tableStore varchar(255) NOT NULL" +
                "    , CONSTRAINT PK_IDAnimal PRIMARY KEY (IDSource, nameofinstruction)\n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";

        String createTableSql2 = "CREATE TABLE IF NOT EXISTS `animals` (\n" +
                "    `ID` int unsigned NOT NULL AUTO_INCREMENT\n" +
                "  , `Parent` INT UNSIGNED NULL \n" +
                "  , `Name` varchar(64) NOT NULL \n" +
                "  , `class` varchar(255) NOT NULL\n" +
                "  , PRIMARY KEY (`ID`) \n" +
                "  , CONSTRAINT UX_parent_name UNIQUE KEY (`Parent`, `Name`) \n" +
                "  , INDEX `Animals_Parent` (`Parent`) \n" +
                "  , CONSTRAINT `FK_parent` FOREIGN KEY (`Parent`) REFERENCES `animals` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";
        String createTableSql3 = "insert ignore into `animals` (ID, `Name`) values (1, 'Домашние животные'),(2,'Вьючные животные');";
        String createTableSql4 = "insert ignore into `animals` (Parent, `Name`, `class`) values (1,'Кошки','cat'),(1,'Собаки', 'dog'),(1,'Хомяки', 'hamster'),(2,'Лошади', 'horse'),(2,'Верблюды','camel'),(2,'Ослы','donkey');";

        String createTableSql5 = "CREATE TABLE IF NOT EXISTS `cats` \n" +
                "(     ID INT UNSIGNED NOT NULL AUTO_INCREMENT \n" +
                "    , `IDAnimals` INT UNSIGNED NOT NULL \n" +
                "    , `name` varchar(255) NOT NULL \n" +
                "    , `birthday` varchar(255) NOT NULL\n" +
                "    , CONSTRAINT UX_name UNIQUE KEY (name)\n" +
                "    , INDEX `Animals_Source_cats` (`IDAnimals`) \n" +
                "    , CONSTRAINT `FK_Source_cats` FOREIGN KEY (`IDAnimals`) REFERENCES `animals` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    , CONSTRAINT PK_articles_id PRIMARY KEY (ID)\n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";
        String createTableSql6 = "CREATE TABLE IF NOT EXISTS `dogs` \n" +
                "(     ID INT UNSIGNED NOT NULL AUTO_INCREMENT \n" +
                "    , `IDAnimals` INT UNSIGNED NOT NULL \n" +
                "    , `name` varchar(255) NOT NULL \n" +
                "    , `birthday` varchar(255) NOT NULL\n" +
                "    , CONSTRAINT UX_name UNIQUE KEY (name)\n" +
                "    , INDEX `Animals_Source_dogs` (`IDAnimals`) \n" +
                "    , CONSTRAINT `FK_Source_dogs` FOREIGN KEY (`IDAnimals`) REFERENCES `animals` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    , CONSTRAINT PK_articles_id PRIMARY KEY (ID)\n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";
        String createTableSql7 = "CREATE TABLE IF NOT EXISTS `hamsters` \n" +
                "(     ID INT UNSIGNED NOT NULL AUTO_INCREMENT \n" +
                "    , `IDAnimals` INT UNSIGNED NOT NULL \n" +
                "    , `name` varchar(255) NOT NULL \n" +
                "    , `birthday` varchar(255) NOT NULL\n" +
                "    , CONSTRAINT UX_name UNIQUE KEY (name)\n" +
                "    , INDEX `Animals_Source_hamsters` (`IDAnimals`) \n" +
                "    , CONSTRAINT `FK_Source_hamsters` FOREIGN KEY (`IDAnimals`) REFERENCES `animals` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    , CONSTRAINT PK_articles_id PRIMARY KEY (ID)\n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";
        String createTableSql8 = "CREATE TABLE IF NOT EXISTS `camels` \n" +
                "(     ID INT UNSIGNED NOT NULL AUTO_INCREMENT \n" +
                "    , `IDAnimals` INT UNSIGNED NOT NULL \n" +
                "    , `name` varchar(255) NOT NULL \n" +
                "    , `birthday` varchar(255) NOT NULL\n" +
                "    , CONSTRAINT UX_name UNIQUE KEY (name)\n" +
                "    , INDEX `Animals_Source_camels` (`IDAnimals`) \n" +
                "    , CONSTRAINT `FK_Source_camels` FOREIGN KEY (`IDAnimals`) REFERENCES `animals` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    , CONSTRAINT PK_articles_id PRIMARY KEY (ID)\n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";
        String createTableSql9 = "CREATE TABLE IF NOT EXISTS `donkeys` \n" +
                "(     ID INT UNSIGNED NOT NULL AUTO_INCREMENT \n" +
                "    , `IDAnimals` INT UNSIGNED NOT NULL \n" +
                "    , `name` varchar(255) NOT NULL \n" +
                "    , `birthday` varchar(255) NOT NULL\n" +
                "    , CONSTRAINT UX_name UNIQUE KEY (name)\n" +
                "    , INDEX `Animals_Source_donkeys` (`IDAnimals`) \n" +
                "    , CONSTRAINT `FK_Source_donkeys` FOREIGN KEY (`IDAnimals`) REFERENCES `animals` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    , CONSTRAINT PK_articles_id PRIMARY KEY (ID)\n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";
        String createTableSql10 = "CREATE TABLE IF NOT EXISTS `horses` \n" +
                "(     ID INT UNSIGNED NOT NULL AUTO_INCREMENT \n" +
                "    , `IDAnimals` INT UNSIGNED NOT NULL \n" +
                "    , `name` varchar(255) NOT NULL \n" +
                "    , `birthday` varchar(255) NOT NULL\n" +
                "    , CONSTRAINT UX_name UNIQUE KEY (name)\n" +
                "    , INDEX `Animals_Source_horses` (`IDAnimals`) \n" +
                "    , CONSTRAINT `FK_Source_horses` FOREIGN KEY (`IDAnimals`) REFERENCES `animals` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    , CONSTRAINT PK_articles_id PRIMARY KEY (ID)\n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";

        String createTableSql11 = "CREATE TABLE IF NOT EXISTS `youngAnimals` \n" +
                "(     ID INT UNSIGNED NOT NULL\n" +
                "    , `name` varchar(255) NOT NULL \n" +
                "    , `ageInMonths` INT NOT NULL \n" +
                "    , `sourceTable` varchar(255) NOT NULL \n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";

        String createTableSql12 = "CREATE TABLE IF NOT EXISTS `horsesanddonkeys` \n" +
                "(      ID INT UNSIGNED NOT NULL\n" +
                "    , `IDAnimals` INT UNSIGNED NOT NULL \n" +
                "    , `name` varchar(255) NOT NULL \n" +
                "    , `birthday` varchar(255) NOT NULL\n" +
                "    , INDEX `Animals_Source_horsesanddonkeys` (`IDAnimals`) \n" +
                "    , CONSTRAINT `FK_Source_horsesanddonkeys` FOREIGN KEY (`IDAnimals`) REFERENCES `animals` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ")  engine=innodb default charset=utf8mb4 collate=utf8mb4_general_ci;";

        try {
            PreparedStatement createTable = this.connectToDb.prepareStatement(createTableSql1);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql2);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql3);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql4);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql5);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql6);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql7);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql8);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql9);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql10);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql11);
            createTable.executeUpdate();
            createTable = this.connectToDb.prepareStatement(createTableSql12);
            createTable.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void insert(Animal animal, String table) {
        String sql = "INSERT INTO `" + table + "` (IDAnimals, name, birthday) VALUES (?, ?, ?)";
        try {
            PreparedStatement insert = this.connectToDb.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            insert.setInt(1, animal.getIDAnimals());
            insert.setString(2, animal.getName());
            insert.setString(3, animal.getBirthDay());
            int affectedRows = insert.executeUpdate();
            if(affectedRows == 1){
                ResultSet generatedKeys = insert.getGeneratedKeys();
                if(generatedKeys.next()){
                    long lastId = generatedKeys.getLong(1);
//                    System.out.println(lastId);
                    sql = "INSERT INTO `instructionset` (IDSource, nameofinstruction, tableStore) VALUES (?, ?, ?)";
                    for (String item: animal.getInstructions()) {
                        insert = this.connectToDb.prepareStatement(sql);
                        insert.setLong(1, lastId);
                        insert.setString(2, item);
                        insert.setString(3, animal.getTableStore());
                        insert.executeUpdate();
                    }

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet select() throws SQLException {
        String sql = "SELECT\n" +
                "ID\n" +
                ", Name\n" +
                "FROM animals WHERE Parent IS NULL";
        PreparedStatement select = connectToDb.prepareStatement(sql);
        return select.executeQuery();
    }
    public ResultSet select(Integer id) throws SQLException {
        String sql = "SELECT\n" +
                "ID\n" +
                ", Name\n" +
                ", class\n" +
                "FROM animals\n" +
                "WHERE Parent = ?";
        PreparedStatement select = connectToDb.prepareStatement(sql);
        select.setInt(1, id);
        return select.executeQuery();
    }
    public ResultSet selectClass(Integer id) throws SQLException {
        String sql = "SELECT\n" +
                "ID\n" +
                ", Name\n" +
                ", class\n" +
                "FROM animals\n" +
                "WHERE ID = ?";
        PreparedStatement select = connectToDb.prepareStatement(sql);
        select.setInt(1, id);
        return select.executeQuery();
    }
    public ResultSet selectAnimals(Integer id) throws SQLException {
        ResultSet tempResult;
        String sql = "SELECT\n" +
                "ID\n" +
                ", Name\n" +
                ", class\n" +
                "FROM animals\n" +
                "WHERE ID = ?";
        PreparedStatement select = connectToDb.prepareStatement(sql);
        select.setInt(1, id);
        tempResult = select.executeQuery();
        if(tempResult.next()){
            String tbl = tempResult.getString("class")+"s";
            sql = "SELECT\n" +
                    "ID" +
                    ", name\n" +
                    ", birthday\n" +
                    ", \"" + tbl + "\" as class\n"+
                    "FROM " + tbl;
            select = connectToDb.prepareStatement(sql);
            return select.executeQuery();
        }
        return null;
    }

    public ResultSet selectInstructions(Integer id, String classOfAnimal) throws SQLException {
        String sql = "SELECT\n" +
                    "ID\n" +
                    ", name\n" +
                    ", birthday\n" +
                    ", nameofinstruction\n" +
                    "FROM " + classOfAnimal +" s\n" +
                    "LEFT JOIN instructionset i ON i.IDSource = s.ID AND i.tableStore = ?\n" +
                "WHERE s.id = ?\n";
        PreparedStatement select = connectToDb.prepareStatement(sql);
        select.setString(1, classOfAnimal);
        select.setInt(2, id);
//        System.out.println(select);
            return select.executeQuery();
    }

    public Integer insertInstruction(Integer id, String instruction, String tableStore) throws SQLException {
        String sql = "INSERT IGNORE INTO instructionset (IDSource, nameofinstruction, tableStore) VALUES(?, ?, ?)";
        PreparedStatement insert = connectToDb.prepareStatement(sql);
        insert.setInt(1, id);
        insert.setString(2, instruction);
        insert.setString(3, tableStore);
        insert.executeUpdate();
        return insert.getUpdateCount();
    }

    public ResultSet selectYoungAnimal() throws SQLException {
//        String sql = "SELECT class+\"s\" as class FROM animals";
        Integer yearInMonths = 12;
        String sql = "SELECT CONCAT(class, 's') AS class " +
                "FROM animals " +
                "WHERE class <> \"\" ";

        PreparedStatement select = connectToDb.prepareStatement(sql);
        ResultSet resultSelect =  select.executeQuery();
        select = connectToDb.prepareStatement("truncate table younganimals;");
        select.executeUpdate();
        String ResultSql = "INSERT INTO younganimals (ID, name, ageInMonths, sourceTable) \n" +
                "WITH src AS (";

        while(resultSelect.next()){
            String tableName = resultSelect.getString("class");
            ResultSql += "SELECT ID" +
                    ", name" +
                    ", PERIOD_DIFF(CONCAT(YEAR(now()), DATE_FORMAT(now(), '%m')),CONCAT(YEAR(birthday), DATE_FORMAT(birthday, '%m'))) AS ageInMonths" +
                    ", \"" + tableName + "\" AS sourceTable\n" +
                    "FROM " + tableName + "\n";
            if(!resultSelect.isLast())
                ResultSql += "UNION \n";
            else {
                ResultSql += ")\n" +
                        "SELECT ID, name, ageInMonths, sourceTable \n" +
                        "FROM src \n" +
                        "WHERE ageInMonths > ? AND ageInMonths < (?*3);";
            }

        }
        select = connectToDb.prepareStatement(ResultSql);
        select.setInt(1, yearInMonths);
        select.setInt(2, yearInMonths);
        select.executeUpdate();
        sql = "SELECT ID, name, ageInMonths, sourceTable FROM younganimals;";
        select = connectToDb.prepareStatement(sql);
        return select.executeQuery();
    }

    public ResultSet unionHorsesDonkeys()  throws SQLException {
        String sql = "TRUNCATE TABLE horsesanddonkeys";
        PreparedStatement truncate = connectToDb.prepareStatement(sql);
        truncate.executeUpdate();

        sql = "INSERT INTO horsesanddonkeys (ID, IDAnimals, name, birthday)\n" +
                "SELECT ID, IDAnimals, name, birthday FROM horses\n" +
                "UNION\n" +
                "SELECT ID, IDAnimals, name, birthday FROM donkeys\n";
        PreparedStatement insert = connectToDb.prepareStatement(sql);
        insert.executeUpdate();
        sql = "SELECT ID, IDAnimals, name, birthday FROM horsesanddonkeys";
        PreparedStatement select = connectToDb.prepareStatement(sql);
        return select.executeQuery();
    }

    public void deleteCamels() throws SQLException {
        String sql = "DELETE FROM instructionset \n" +
                "WHERE IDSource IN (SELECT ID FROM camels)\n" +
                "AND tableStore = ? ";
        PreparedStatement delete = connectToDb.prepareStatement(sql);
        delete.setString(1, "camels");
        delete.executeUpdate();
        sql = "TRUNCATE TABLE camels";
        PreparedStatement truncate = connectToDb.prepareStatement(sql);
        truncate.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        this.connectToDb.close();
    }


}
