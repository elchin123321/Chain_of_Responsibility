public class EmployeeChain implements TaskHandler {
    private final Employee employee;
    private EmployeeChain nextEmployeeChain;

    public EmployeeChain(Employee employee) {
        this.employee = employee;
    }
    public boolean doTask(Task task){
        if(employee.canHandleTask(task)){
            employee.doTask(task);
            return true;
        }else if(nextEmployeeChain != null){
            nextEmployeeChain.doTask(task);
            return true;
        }else {
            return false;
        }
    }

    public void setNextEmployeeChain(EmployeeChain nextEmployeeChain){
        this.nextEmployeeChain = nextEmployeeChain;
    }
}
