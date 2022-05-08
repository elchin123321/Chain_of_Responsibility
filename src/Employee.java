public abstract class Employee implements TaskHandler{
    private final TaskProgressCallBack callBack;
    private final String name;
    private final Task.Status taskStatus;

    public Employee(TaskProgressCallBack callBack, String name, Task.Status taskStatus) {
        this.callBack = callBack;
        this.name = name;
        this.taskStatus = taskStatus;
    }
    public boolean doTask(Task task){
        boolean canHandle = taskStatus == task.getStatus();
        if(canHandle) {
            System.out.println(getClass().getSimpleName() + " " + name + " is doing task" + getDetails(task));
            callBack.updateTask(getTaskWhenDone(task));
        }
        return canHandle;
    }
    public boolean canHandleTask(Task task){
        return taskStatus == task.getStatus();
    }
    public Task.Status getTaskStatus(){
        return taskStatus;
    }

    protected abstract Task getTaskWhenDone(Task task);
    protected abstract String getDetails(Task task);
}
