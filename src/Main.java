public class Main {
    public static void main(String[] args){
        TaskFactory factory = new TaskFactory();
        TaskProgressCallBack callBack = factory::updateTask;
        EmployeeChain chain = new EmployeeChain(new Designer(callBack, "Alycia"));
        EmployeeChain next = new EmployeeChain(new Programmer(callBack, "John"));
        EmployeeChain last = new EmployeeChain(new Tester(callBack, "Steve"));
        chain.setNextEmployeeChain(next);
        next.setNextEmployeeChain(last);
        while(true){
            if(!chain.doTask(factory.getTask())){
                break;
            }
        }
    }
}
