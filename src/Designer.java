public class Designer extends Employee{
    public Designer(TaskProgressCallBack callBack, String name) {
        super(callBack, name, Task.Status.ASSEMBLING_REQUIREMENTS);
    }

    @Override
    protected Task getTaskWhenDone(Task task) {
        return new Task(
                task.getId(),
                Task.Status.READY_TO_DO,
                task.getDescription(),
                getDesignLinkForTask(task.getId()),
                getTestCaseForTask(task.getDescription()),
                ""
        );
    }

    private String getDesignLinkForTask(int taskId) {
        return "project/design_link_for_task"+taskId;
    }

    private String getTestCaseForTask(String taskDescription) {
        return "when " + taskDescription + " get result " + Math.random();
    }

    @Override
    protected String getDetails(Task task) {
        return " with taskID" + task.getId() + " and description" + task.getDescription();
    }
}
