public class Tester extends Employee{
    public Tester(TaskProgressCallBack callBack, String name) {
        super(callBack, name, Task.Status.READY_FOR_TESTING);
    }

    @Override
    protected Task getTaskWhenDone(Task task) {
        return new Task(
                task.getId(),
                Task.Status.DONE,
                task.getDescription(),
                task.getDesignLink(),
                task.getTestCase(),
                task.getBuildLink()
        );
    }

    @Override
    protected String getDetails(Task task) {
        return "with id " + task.getId() + " and testCase " + task.getTestCase();
    }
}
