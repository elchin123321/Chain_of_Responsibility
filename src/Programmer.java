public class Programmer extends Employee {

    public Programmer(TaskProgressCallBack callBack, String name) {
        super(callBack, name, Task.Status.READY_TO_DO);
    }

    @Override
    protected Task getTaskWhenDone(Task task) {
        return new Task(
                task.getId(),
                Task.Status.READY_FOR_TESTING,
                task.getDescription(),
                task.getDesignLink(),
                task.getTestCase(),
                getBuildLinlForTask(task.getId())
        );
    }

    private String getBuildLinlForTask(int taskId) {
        return "project/link_for_build_with_id" + taskId;
    }

    @Override
    protected String getDetails(Task task) {
        return  "with task id " + task.getId() + " and design link " + task.getDesignLink() + " \nand testCase" + task.getTestCase();
    }
}
