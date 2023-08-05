import java.util.ArrayList;

public class InstructionSet {
    private ArrayList<String> Instruction;

    public InstructionSet() {
        this.Instruction = new ArrayList<>();
    }

    public ArrayList<String> getInstruction() {
        return this.Instruction;
    }

    public void setInstruction(String instruction) {
        this.Instruction.add(instruction);
    }
}
