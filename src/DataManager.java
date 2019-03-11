import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<State> states;

    public DataManager() {
        states = new ArrayList<State>();

    }
    public List<State> getStates() {
        return states;
    }

    public void addState(State s){
        states.add(s);
    }
    public void removeState( int index){
        states.remove(index);
    }
    public void removeState(State s){
        states.remove(s);
    }
    public void setStates(List<State> states) {
        this.states = states;
    }


}
