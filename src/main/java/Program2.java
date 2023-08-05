import javax.crypto.SealedObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Boolean startLoop = true;
        try{
            ConnectionDB cdb = new ConnectionDB("localhost", 3315,"mansfriends","root","");
            cdb.createTable();

            while(startLoop) {
                Scanner in = new Scanner(System.in);
                System.out.print("Введите комманду: ");
                String cmd = in.nextLine();
                switch(cmd){
                    case "select" -> {
                        System.out.println("Выберите (id) тип животных для просмотра:");
                        ResultSet result = cdb.select();
                        while (result.next()) {
                            int id = result.getInt("ID");
                            String name = result.getString("name");
                            System.out.printf("id:%d ### %s", id, name);
                            System.out.println();
                        }

                        in = new Scanner(System.in);
                        System.out.print("Введите id: ");
                        cmd = in.nextLine();

                        result = cdb.select(Integer.parseInt(cmd));

                        while (result.next()) {
                            int id = result.getInt("ID");
                            String name = result.getString("name");
                            System.out.printf("id:%d ### %s", id, name);
                            System.out.println();
                        }

                        in = new Scanner(System.in);
                        System.out.print("Введите id: ");
                        cmd = in.nextLine();

                        result = cdb.selectAnimals(Integer.parseInt(cmd));

                        if(result.next()){
                            result.beforeFirst();
                            String classOfAnimal = null;
                            while (result.next()) {
                                int id = result.getInt("ID");
                                String name = result.getString("name");
                                String birthday = result.getString("birthday");
                                classOfAnimal = result.getString("class");
                                System.out.printf("id:%d ### %s ### %s", id, name, birthday);
                                System.out.println();
                            }

                            in = new Scanner(System.in);
                            System.out.print("Введите id животного: ");
                            cmd = in.nextLine();

                                result = cdb.selectInstructions(Integer.parseInt(cmd), classOfAnimal);
                                if(result.next()){
                                    String nameOfAnimal = result.getString("name");
                                    System.out.println(nameOfAnimal + " умеет:" );
                                    String inst = result.getString("nameofinstruction");
                                    if(inst != null){
                                        result.beforeFirst();
                                        while (result.next()) {
                                            String nameofinstruction = result.getString("nameofinstruction");
                                            System.out.printf("\t%s",  nameofinstruction);
                                            System.out.println();
                                        }
                                    }else {
                                        System.out.println("\tУмения отсуствуют!");
                                    }
                                }
                        } else {
                            System.out.println("Животных в данной категории нет!");
                        }
                    }
                    case "addAnim" -> {
                        System.out.println("Выберите (id) тип животных для просмотра:");
                        ResultSet result = cdb.select();
                        while (result.next()) {
                            int id = result.getInt("ID");
                            String name = result.getString("name");
                            System.out.printf("id:%d ### %s", id, name);
                            System.out.println();
                        }
                        in = new Scanner(System.in);
                        System.out.print("Введите id: ");
                        cmd = in.nextLine();

                        result = cdb.select(Integer.parseInt(cmd));

                        while (result.next()) {
                            int id = result.getInt("ID");
                            String name = result.getString("name");
                            String classAnimal = result.getString("class");
                            System.out.printf("id:%d ### %s", id, name);
//                            System.out.printf("id:%d ### %s ### %s", id, name, classAnimal);
                            System.out.println();
                        }

                        in = new Scanner(System.in);
                        System.out.print("Введите id животного, которого нужно создать: ");
                        cmd = in.nextLine();

                        result = cdb.selectClass(Integer.parseInt(cmd));

                        if (result.next()) {
                            int id = result.getInt("ID");
                            String name = result.getString("name");
                            String classAnimal = result.getString("class");
                            //System.out.printf("Вы создаёте животное класса %s его класс %s", name, classAnimal);
                            System.out.println();

                            switch(classAnimal) {
                                case "cat" -> {
                                    Animal cat = new Cat(id);
                                    cat.setTableStore(classAnimal+"s");
                                    System.out.print("Введите имя кота(кошки): ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    cat.setName(cmd);
                                    System.out.print("Введите дату рождения кота(кошки) в формате: 2020-12-31: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    cat.setBirthDay(cmd);
                                    while(true){
                                        System.out.print("Введите умение кота(кошки) (q - выход и запись в базу): ");
                                        in = new Scanner(System.in);
                                        cmd = in.nextLine();
                                        if(cmd.equals("q"))
                                            break;
                                        cat.setInstruction(cmd);
                                    }
                                    cdb.insert(cat, classAnimal+"s");

                                }
                                case "dog" -> {
                                    Animal dog = new Dog(id);
                                    dog.setTableStore(classAnimal+"s");
                                    System.out.print("Введите имя собаки: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    dog.setName(cmd);
                                    System.out.print("Введите дату рождения собаки в формате: 2020-12-31: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    dog.setBirthDay(cmd);
                                    while(true){
                                        System.out.print("Введите умение собаки (q - выход и запись в базу): ");
                                        in = new Scanner(System.in);
                                        cmd = in.nextLine();
                                        if(cmd.equals("q"))
                                            break;
                                        dog.setInstruction(cmd);
                                    }
                                    cdb.insert(dog, classAnimal+"s");

                                }
                                case "hamster" -> {
                                    Animal hamster = new Hamster(id);
                                    hamster.setTableStore(classAnimal+"s");
                                    System.out.print("Введите имя хомяка: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    hamster.setName(cmd);
                                    System.out.print("Введите дату рождения хомяка в формате: 2020-12-31: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    hamster.setBirthDay(cmd);
                                    while(true){
                                        System.out.print("Введите умение хомяка (q - выход и запись в базу): ");
                                        in = new Scanner(System.in);
                                        cmd = in.nextLine();
                                        if(cmd.equals("q"))
                                            break;
                                        hamster.setInstruction(cmd);
                                    }
                                    cdb.insert(hamster, classAnimal+"s");

                                }
                                case "camel" -> {
                                    Animal camel = new Camel(id);
                                    camel.setTableStore(classAnimal+"s");
                                    System.out.print("Введите имя верблюда: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    camel.setName(cmd);
                                    System.out.print("Введите дату рождения верблюда в формате: 2020-12-31: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    camel.setBirthDay(cmd);
                                    while(true){
                                        System.out.print("Введите умение верблюда (q - выход и запись в базу): ");
                                        in = new Scanner(System.in);
                                        cmd = in.nextLine();
                                        if(cmd.equals("q"))
                                            break;
                                        camel.setInstruction(cmd);
                                    }
                                    cdb.insert(camel, classAnimal+"s");

                                }
                                case "horse" -> {
                                    Animal horse = new Horse(id);
                                    horse.setTableStore(classAnimal+"s");
                                    System.out.print("Введите имя коня(лошади): ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    horse.setName(cmd);
                                    System.out.print("Введите дату рождения коня(лошади) в формате: 2020-12-31: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    horse.setBirthDay(cmd);
                                    while(true){
                                        System.out.print("Введите умение коня(лошади) (q - выход и запись в базу): ");
                                        in = new Scanner(System.in);
                                        cmd = in.nextLine();
                                        if(cmd.equals("q"))
                                            break;
                                        horse.setInstruction(cmd);
                                    }
                                    cdb.insert(horse, classAnimal+"s");

                                }
                                case "donkey" -> {
                                    Animal donkey = new Donkey(id);
                                    donkey.setTableStore(classAnimal+"s");
                                    System.out.print("Введите имя осла: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    donkey.setName(cmd);
                                    System.out.print("Введите дату рождения осла в формате: 2020-12-31: ");
                                    in = new Scanner(System.in);
                                    cmd = in.nextLine();
                                    donkey.setBirthDay(cmd);
                                    while(true){
                                        System.out.print("Введите умение осла (q - выход и запись в базу): ");
                                        in = new Scanner(System.in);
                                        cmd = in.nextLine();
                                        if(cmd.equals("q"))
                                            break;
                                        donkey.setInstruction(cmd);
                                    }
                                    cdb.insert(donkey, classAnimal+"s");

                                }
                            }

                        } else {
                            System.out.println("Такой группы животных не существует");
                        }

                    }
                    case "addInstr" -> {
                        System.out.println("Выберите (id) тип животных для просмотра:");
                        ResultSet result = cdb.select();
                        while (result.next()) {
                            int id = result.getInt("ID");
                            String name = result.getString("name");
                            System.out.printf("id:%d ### %s", id, name);
                            System.out.println();
                        }
                        in = new Scanner(System.in);
                        System.out.print("Введите id: ");
                        cmd = in.nextLine();

                        result = cdb.select(Integer.parseInt(cmd));

                        while (result.next()) {
                            int id = result.getInt("ID");
                            String name = result.getString("name");
                            System.out.printf("id:%d ### %s", id, name);
                            System.out.println();
                        }

                        in = new Scanner(System.in);
                        System.out.print("Введите id: ");
                        cmd = in.nextLine();

                        result = cdb.selectAnimals(Integer.parseInt(cmd));

                        if(result.next()){
                            result.beforeFirst();
                            String classOfAnimal = null;
                            while (result.next()) {
                                int id = result.getInt("ID");
                                String name = result.getString("name");
                                String birthday = result.getString("birthday");
                                classOfAnimal = result.getString("class");
                                System.out.printf("id:%d ### %s ### %s", id, name, birthday);
                                System.out.println();
                            }

                            in = new Scanner(System.in);
                            System.out.print("Введите id: ");
                            cmd = in.nextLine();

                            result = cdb.selectInstructions(Integer.parseInt(cmd), classOfAnimal);
                            if(result.next()){
                                while(true){
                                    int id = result.getInt("ID");
                                    in = new Scanner(System.in);
                                    System.out.print("Введите умение(q - завершение работы с умениями): ");
                                    cmd = in.nextLine();
                                    if(cmd.equals("q"))
                                        break;
                                    System.out.printf("Количество введённых умений равно: %d", cdb.insertInstruction(id, cmd, classOfAnimal));
                                    System.out.println();
                                }
                            }
                        } else {
                            System.out.println("Животных в данной категории нет!");
                        }
                    }
                    case "youngAnimal" -> {
                        System.out.println("Работа с молодыми животными!");
                        ResultSet select =  cdb.selectYoungAnimal();
                        while(select.next()){
                            int id = select.getInt("ID");
                            String name = select.getString("name");
                            int ageInMonths = select.getInt("ageInMonths");
                            String sourceTable = select.getString("sourceTable");
                            System.out.printf("%d ### %s ### %d ### %s", id, name, ageInMonths, sourceTable);
                            System.out.println();
                        }
                    }
                    case "unionHorsesDonkeys" -> {
                        System.out.println("Объединение лошадей и ослов!");
                        ResultSet select =  cdb.unionHorsesDonkeys();
                        while(select.next()){
                            int id = select.getInt("ID");
                            String name = select.getString("name");
                            String birthday = select.getString("birthday");
                            System.out.printf("%d ### %s ### %s", id, name, birthday);
                            System.out.println();
                        }
                    }
                    case "deleteCamels" -> {
                        System.out.println("Перемещение верблюдов куда-то!");
                        cdb.deleteCamels();
                    }
                    case "help" -> {
                        System.out.println("Команды для работы с программой:");
                        System.out.println("help - помощь по командам");
                        System.out.println("select - вывести список всех животных");
                        System.out.println("addAnim - добавить животное");
                        System.out.println("addInstr - добавить навыки животных");
                        System.out.println("youngAnimal - добавить молодых животных в другую таблицу");
                        System.out.println("unionHorsesDonkeys - лошади и ослы добавить в отдельную таблицу");
                        System.out.println("deleteCamels - удалить верблюдов");
                        System.out.println("q - завершение работы программы");
                    }
                    case "q" -> {
                        System.out.println("Работа с программой завершена!");
                        startLoop = false;
                    }
                    default -> System.out.println("Неизвестная комманда");
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
