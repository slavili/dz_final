import java.util.ArrayList;
import java.util.Date;

class Animal {
    private String name;
    private InstructionSet instruction;
    private String birthDay;
    private String tableStore;
    private Integer IDAnimals;

    public Integer getIDAnimals() {
        return IDAnimals;
    }


    public Animal(Integer IDAnimals){
        this.instruction = new InstructionSet();
        this.IDAnimals = IDAnimals;
    }

    protected void setName(String name){
        this.name = name;
    }

    protected void setBirthDay(String birthDay){
        this.birthDay = birthDay;
     }

    protected String getName() {
        return this.name;
    }



    protected String getBirthDay() {
        return this.birthDay;
    }

    public void setTableStore(String tableStore) {
        this.tableStore = tableStore;
    }

    public String getTableStore() {
        return this.tableStore;
    }

    public InstructionSet getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction.setInstruction(instruction);
    }

    public ArrayList<String> getInstructions(){
        return this.instruction.getInstruction();
    }
}
